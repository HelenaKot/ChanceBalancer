package kot.helena.chancebalancer.display

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kot.helena.chancebalancer.EntityModel

class DisplayEntityAdapter : RecyclerView.Adapter<EntityViewHolder>() {
    private var data: List<EntityModelWrapper> = ArrayList()

    fun setData(data: List<EntityModel>) {
        this.data = data.map { datum -> EntityModelWrapper(datum) }
        notifyDataSetChanged()
    }

    fun isEmpty(): Boolean {
        return data.isEmpty()
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        holder.bind(data[position].model)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        return EntityViewHolder(EntityViewHolder.createBinding(parent))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class EntityModelWrapper constructor(val model: EntityModel) {
        var selectedLeft = false
        var selectedRight = false
    }

}