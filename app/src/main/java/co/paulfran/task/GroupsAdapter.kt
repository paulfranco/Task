package co.paulfran.task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GroupsAdapter(private val list: List<Group>, listenerContext: OnGroupClickListener): RecyclerView.Adapter<GroupViewHolder>() {

    private var myInterface: OnGroupClickListener = listenerContext

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return GroupViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val group = list[position]
        holder.bind(group)

        holder.itemView.setOnClickListener {
            myInterface.groupClicked(position)
        }

        holder.itemView.setOnLongClickListener {
            myInterface.groupLongClicked(position)
            true
        }
    }

    override fun getItemCount(): Int = list.size

}