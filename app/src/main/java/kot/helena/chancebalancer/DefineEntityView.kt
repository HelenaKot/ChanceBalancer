package kot.helena.chancebalancer

import android.app.Activity
import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.CardView
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.widget.EditText
import kot.helena.chancebalancer.databinding.DefineEntityViewBinding
import kotlinx.android.synthetic.main.define_entity_view.view.*

class DefineEntityView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0)
    : CardView(context, attrs, defStyle) {
    private val attackChanceField: EditText by lazy { input_atk_chance }
    private val attackDamageField: EditText by lazy { input_atc_dmg }
    private val defenceChanceField: EditText by lazy { input_def_chance }
    private val defenceTimesField: EditText by lazy { input_def_times }
    private val healthField: EditText by lazy { input_hp }
    private val armorField: EditText by lazy { input_armor }

    private val model: EntityModel = EntityModel()

    init {
        val binding: DefineEntityViewBinding = DataBindingUtil.setContentView(this.context as Activity, R.layout.define_entity_view)
        attackChanceField.afterTextChanged { input -> model.attackChance = input.toInt() }
        attackDamageField.afterTextChanged { input -> model.attackDamage = input.toInt() }
        defenceChanceField.afterTextChanged { input -> model.defenceChance = input.toInt() }
        defenceTimesField.afterTextChanged { input -> model.defenceTimes = input.toInt() }
        healthField.afterTextChanged { input -> model.health = input.toInt() }
        armorField.afterTextChanged { input -> model.armor = input.toInt() }
    }

    fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
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