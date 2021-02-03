package co.paulfran.task.holders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.paulfran.task.R
import co.paulfran.task.models.Group

class GroupViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.group_row, parent, false)) {
    private var groupNameTextView: TextView? = null
    private var groupCountTextView: TextView? = null

    init {
        groupNameTextView = itemView.findViewById(R.id.group_name_tv)
        groupCountTextView = itemView.findViewById(R.id.group_count_tv)
    }

    fun bind(group: Group) {
        groupNameTextView!!.text = group.name
        groupCountTextView!!.text = "${group.items.count()} items"
    }
}