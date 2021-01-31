package co.paulfran.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import co.paulfran.task.databinding.ActivityGroupsBinding

class GroupsActivity : AppCompatActivity() {

    lateinit var binding: ActivityGroupsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_groups)

        

    }
}