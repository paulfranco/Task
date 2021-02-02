package co.paulfran.task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import co.paulfran.task.databinding.ActivityItemsBinding

class ItemsActivity : AppCompatActivity() {

    lateinit var binding: ActivityItemsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_items)


        var selectedIndex = intent.getIntExtra("groupIndex", 0)
        var thisGroup = AppData.groups[selectedIndex]

        binding.toolbarTitle.text = thisGroup.name

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}