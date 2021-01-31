package co.paulfran.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.paulfran.task.databinding.ActivityGroupsBinding

class GroupsActivity : AppCompatActivity() {

    lateinit var binding: ActivityGroupsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_groups)

        binding.groupsRecyclerView.layoutManager = LinearLayoutManager(this)

        AppData.initialize()
        
        val groupsAdapter = GroupsAdapter(AppData.groups)

        binding.groupsRecyclerView.adapter = groupsAdapter

    }
}

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