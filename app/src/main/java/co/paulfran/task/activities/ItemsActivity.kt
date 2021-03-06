package co.paulfran.task.activities

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import co.paulfran.task.*
import co.paulfran.task.adapters.ItemsAdapter
import co.paulfran.task.data.AppData
import co.paulfran.task.databinding.ActivityItemsBinding
import co.paulfran.task.models.Group
import co.paulfran.task.models.Item

class ItemsActivity : BaseActivity(), OnItemClickListener {

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
        binding.newItemEt.setOnKeyListener { view, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                if (event.action == KeyEvent.ACTION_DOWN) {
                    val name: String = binding.newItemEt.text.toString()
                    val item = Item(name, false)
                    thisGroup.items.add(item)
                    //itemsAdapter!!.notifyDataSetChanged()
                    itemsAdapter!!.notifyItemInserted(thisGroup.items.count())
                    // clear the EditText
                    binding.newItemEt.text.clear()

                    // hide keyboard
                    val inputManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputManager.hideSoftInputFromWindow(view.windowToken, 0)
                }
            }
            false
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    override fun itemClicked(index: Int) {
        thisGroup.items[index].completed = !thisGroup.items[index].completed
        itemsAdapter!!.notifyDataSetChanged()
    }

    override fun itemLongClicked(index: Int) {
        thisGroup.items.removeAt(index)
        itemsAdapter!!.notifyItemRemoved(index)
        showErrorSnackBar("Deleted Item")
    }
}