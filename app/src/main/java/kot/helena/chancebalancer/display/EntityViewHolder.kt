package kot.helena.chancebalancer.display

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kot.helena.chancebalancer.EntityModel
import kot.helena.chancebalancer.databinding.DisplayEntityViewBinding
import kotlin.properties.Delegates

class EntityViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    private var binding: DisplayEntityViewBinding by Delegates.notNull()

    companion object {
        fun createBinding(parent: ViewGroup): DisplayEntityViewBinding {
            return DisplayEntityViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        }
    }

    constructor(binding: DisplayEntityViewBinding) : this(binding.root) {
        this.binding = binding
    }

    fun bind(model: EntityModel) {
        binding.model = model
        binding.executePendingBindings()
    }
}