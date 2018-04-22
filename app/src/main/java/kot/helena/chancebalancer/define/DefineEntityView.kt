package kot.helena.chancebalancer.define

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import kot.helena.chancebalancer.EntityModel
import kot.helena.chancebalancer.databinding.DefineEntityViewBinding
import java.lang.Integer.parseInt

class DefineEntityView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0)
    : FrameLayout(context, attrs, defStyle) {
    private var binding: DefineEntityViewBinding = DefineEntityViewBinding.inflate(LayoutInflater.from(context), this, true)
    val model: EntityModel
        get() = getEntityModel()

    private fun CharSequence.safeFormatInt(): Int {
        if (this.isBlank()) return 0
        return parseInt(this.toString())
    }

    private fun getEntityModel(): EntityModel {
        val model = EntityModel()
        model.name = binding.inputName.text.toString()
        model.attackChance = binding.inputAtkChance.text.safeFormatInt()
        model.attackDamage = binding.inputAtcDmg.text.safeFormatInt()
        model.attackDamage = binding.inputAtcDmg.text.safeFormatInt()
        model.defenceChance = binding.inputDefChance.text.safeFormatInt()
        model.defenceTimes = binding.inputDefTimes.text.safeFormatInt()
        model.health = binding.inputHp.text.safeFormatInt()
        model.armor = binding.inputArmor.text.safeFormatInt()
        return model
    }
}