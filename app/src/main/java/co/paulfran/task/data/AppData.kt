package co.paulfran.task.data

import co.paulfran.task.models.Group
import co.paulfran.task.models.Item

class AppData {

    companion object DataHolder {
        var groups: MutableList<Group> = mutableListOf()

        fun initialize() {
            val item1 = Item("Bread", false)
            val item2 = Item("Bread1", false)
            val item3 = Item("Bread2", false)
            val item4 = Item("Bread3", false)

            val group1 = Group("Home", mutableListOf(item1, item2))
            val group2 = Group("Office", mutableListOf(item3, item4))

            groups = mutableListOf(group1, group2)
        }
    }
}