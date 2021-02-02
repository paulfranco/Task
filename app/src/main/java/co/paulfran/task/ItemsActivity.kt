package co.paulfran.task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import co.paulfran.task.databinding.ActivityItemsBinding

class ItemsActivity : AppCompatActivity(), OnItemClickListener{

    lateinit var binding: ActivityItemsBinding
    lateinit var thisGroup: Group
    var itemsAdapter: ItemsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_items)


        var selectedIndex = intent.getIntExtra("groupIndex", 0)
        thisGroup = AppData.groups[selectedIndex]

        binding.toolbarTitle.text = thisGroup.name

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        binding.itemsRv.layoutManager = LinearLayoutManager(this)
        itemsAdapter = ItemsAdapter(thisGroup, this)
        binding.itemsRv.adapter = itemsAdapter

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun itemClicked(index: Int) {
        thisGroup.items[index].completed = !thisGroup.items[index].completed
        itemsAdapter!!.notifyDataSetChanged()
    }

    override fun itemLongClicked(index: Int) {
        TODO("Not yet implemented")
    }
}