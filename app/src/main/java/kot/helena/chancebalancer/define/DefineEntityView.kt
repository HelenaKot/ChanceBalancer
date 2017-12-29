package kot.helena.chancebalancer.define

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.FrameLayout
import kot.helena.chancebalancer.EntityModel
import kot.helena.chancebalancer.R
import kotlinx.android.synthetic.main.define_entity_view.view.*

class DefineEntityView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0)
    : FrameLayout(context, attrs, defStyle) {
    private val nameField: EditText by lazy { input_name }
    private val attackChanceField: EditText by lazy { input_atk_chance }
    private val attackDamageField: EditText by lazy { input_atc_dmg }
    private val defenceChanceField: EditText by lazy { input_def_chance }
    private val defenceTimesField: EditText by lazy { input_def_times }
    private val healthField: EditText by lazy { input_hp }
    private val armorField: EditText by lazy { input_armor }

    val model: EntityModel = EntityModel()

    init {
        LayoutInflater.from(context).inflate(R.layout.define_entity_view, this, true)
        nameField.afterTextChanged { input -> model.name = input }
        attackChanceField.afterTextChanged { input -> model.attackChance = input.safeFormatInt() }
        attackDamageField.afterTextChanged { input -> model.attackDamage = input.safeFormatInt() }
        defenceChanceField.afterTextChanged { input -> model.defenceChance = input.safeFormatInt() }
        defenceTimesField.afterTextChanged { input -> model.defenceTimes = input.safeFormatInt() }
        healthField.afterTextChanged { input -> model.health = input.safeFormatInt() }
        armorField.afterTextChanged { input -> model.armor = input.safeFormatInt() }
    }

    private fun String.safeFormatInt(): Int {
        if (this.isBlank()) return 0
        return this.toInt()
    }

    private fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                afterTextChanged.invoke(editable.toString())
            }
        })
    }

}