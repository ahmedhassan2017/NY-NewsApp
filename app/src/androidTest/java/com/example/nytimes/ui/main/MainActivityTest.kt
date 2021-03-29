package com.example.nytimes.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.example.nytimes.R
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

class MainActivityTest {


    @Rule
    @JvmField
    public var activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun recyclerViewTest (){
        Espresso.onView(withId(R.id.recycler)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2,
            click()))
    }

    @Test
    fun onItemClicked() {
    }
}