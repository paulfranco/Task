package co.paulfran.task.holders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.paulfran.task.R
import co.paulfran.task.models.Item

class ItemsViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.item_row, parent, false)) {

    private var itemNameTV: TextView? = null
    private var itemCheckBox: CheckBox? = null

    init {
        itemNameTV = itemView.findViewById(R.id.itemNameTextView)
        itemCheckBox = itemView.findViewById(R.id.itemCheckBox)
    }

    fun bind(item: Item) {
        itemNameTV!!.text = item.name
        itemCheckBox!!.isChecked = item.completed
    }
}