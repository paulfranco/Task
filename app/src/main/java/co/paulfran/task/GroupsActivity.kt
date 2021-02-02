package co.paulfran.task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.paulfran.task.databinding.ActivityGroupsBinding

class GroupsActivity : AppCompatActivity(), OnGroupClickListener {

    lateinit var binding: ActivityGroupsBinding
    var groupsAdapter: GroupsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_groups)

        binding.groupsRecyclerView.layoutManager = LinearLayoutManager(this)

        AppData.initialize()

        groupsAdapter = GroupsAdapter(AppData.groups, this)

        binding.groupsRecyclerView.adapter = groupsAdapter

    }

    fun createNewGroup(v: View) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("New Project")
        builder.setMessage("Please Enter a title for the new project")

        val myInput = EditText(this)
        myInput.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(myInput)

        builder.setPositiveButton("save") { _, _ ->
            val groupName: String = myInput.text.toString()
            val newGroup = Group(groupName, mutableListOf())
            AppData.groups.add(newGroup)
           // groupsAdapter!!.notifyDataSetChanged()
            groupsAdapter!!.notifyItemInserted(AppData.groups.count())
        }

        builder.setNegativeButton("cancel") { _, _ ->

        }

        val dialogue: AlertDialog = builder.create()
        dialogue.show()
    }

    override fun groupClicked(index: Int) {

        val intent = Intent(this, ItemsActivity::class.java)
        intent.putExtra("groupIndex", index)
        startActivity(intent)
    }

    override fun groupLongClicked(index: Int) {
        TODO("Not yet implemented")
    }
}



