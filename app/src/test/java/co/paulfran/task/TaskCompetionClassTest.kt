package co.paulfran.task

import co.paulfran.task.models.Group
import co.paulfran.task.models.Item
import org.junit.Test

import org.junit.Assert.*

class TaskCompetionClassTest {

    @Test
    fun findCompletionTest() {
        val items = mutableListOf(
                Item("Bread", false), Item("Milk", true)
        )

        val group = Group("TestGrp", items)
        val result = findCompletion(group)

        assertEquals(result.activeRate, 50f)
        assertEquals(result.completedRate, 50f)
    }
}