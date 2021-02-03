package co.paulfran.task.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.paulfran.task.models.Item
import co.paulfran.task.holders.ItemsViewHolder
import co.paulfran.task.OnItemClickListener
import co.paulfran.task.models.Group

class ItemsAdapter(private val group: Group, listernerContext: OnItemClickListener): RecyclerView.Adapter<ItemsViewHolder>() {

    private var myInterface: OnItemClickListener = listernerContext

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val item: Item = group.items[position]

        holder.bind(item)

        holder.itemView.setOnClickListener {
            myInterface.itemClicked(position)
        }

        holder.itemView.setOnLongClickListener {
            myInterface.itemLongClicked(position)
            true
        }
    }

    override fun getItemCount(): Int = group.items.size


}