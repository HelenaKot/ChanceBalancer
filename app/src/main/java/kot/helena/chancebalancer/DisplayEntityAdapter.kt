package kot.helena.chancebalancer

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kot.helena.chancebalancer.databinding.DisplayEntityViewBinding
import kotlin.properties.Delegates

class DisplayEntityAdapter : RecyclerView.Adapter<DisplayEntityAdapter.EntityViewHolder>() {
    private var data: List<EntityModel> = ArrayList()

    fun setData(data: List<EntityModel>) {
        this.data = data
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = DisplayEntityViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EntityViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class EntityViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        private var binding: DisplayEntityViewBinding by Delegates.notNull()

        constructor(binding: DisplayEntityViewBinding) : this(binding.root) {
            this.binding = binding
        }

        fun bind(model: EntityModel) {
            binding.model = model
            binding.executePendingBindings()
        }
    }

}