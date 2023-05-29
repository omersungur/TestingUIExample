package com.omersungur.testinguiexample.ui

import androidx.navigation.NavController
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.omersungur.testinguiexample.R
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class FirstFragmentTest {

    @Test
    fun clickFloatActionButton_navigateToSecondFragment() {

        val navController = mock(NavController::class.java)

        val scenario = launchFragmentInContainer<FirstFragment>()
        scenario.onFragment { fragment ->
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        onView(withId(R.id.nextButton)).perform(click())

        verify(navController).navigate(
            FirstFragmentDirections.actionFirstFragmentToSecondFragment()
        )
    }
}