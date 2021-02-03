package co.paulfran.task.activities

import android.content.Intent
import android.os.Build
import co.paulfran.task.data.AppData
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class GroupsActivityTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    // Tests Navigation from the GroupsActivity to the ItemsActivity
    @Test
    fun groupClicked() {
        // Given
        val activityController = Robolectric.buildActivity(GroupsActivity::class.java)
            .create()
            .resume()
            .visible()
        val systemUnderTest = activityController.get()

        // When
        systemUnderTest.groupClicked(0)
        val expectedIntent = Intent(systemUnderTest, ItemsActivity::class.java)
        val shadowActivity = Shadows.shadowOf(systemUnderTest)
        val actualIntent = shadowActivity.getNextStartedActivity()

        // Then
        assertTrue(actualIntent.filterEquals(expectedIntent))

    }
}