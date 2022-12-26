package com.example.robolectricgettingstarted

import android.content.Intent
import android.widget.Button
import org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    @Test
    fun shouldReturnTrue() {
        assertEquals(1, 1)
    }

    @Test
    fun clickingLogin_shouldStartLoginActivity() {

        val controller = Robolectric.buildActivity(MainActivity::class.java)
        controller.setup() //moves activity to RESUMED state
        val activity = controller.get()

        activity.findViewById<Button>(R.id.login_btn).performClick()

        val expectedIntent = Intent(activity, LoginActivity::class.java)

        val actualIntent = Shadows.shadowOf(RuntimeEnvironment.getApplication()).nextStartedActivity

        assertEquals(expectedIntent.component, actualIntent.component)

    }
}
