package co.paulfran.task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GroupsAdapter(private val list: List<Group>): RecyclerView.Adapter<GroupViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return GroupViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val group = list[position]
        holder.bind(group)
    }

    override fun getItemCount(): Int = list.size

}