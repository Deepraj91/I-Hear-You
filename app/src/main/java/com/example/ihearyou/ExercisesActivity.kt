package com.example.ihearyou

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class ExercisesActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercises)

        val testSection = findViewById<LinearLayout>(R.id.testSection)

        // Set click listeners for each exercise
        findViewById<LinearLayout>(R.id.exercise1).setOnClickListener {
            scrollToTestSection(testSection)
        }

        findViewById<LinearLayout>(R.id.exercise2).setOnClickListener {
            scrollToTestSection(testSection)
        }

        findViewById<LinearLayout>(R.id.exercise3).setOnClickListener {
            scrollToTestSection(testSection)
        }

        findViewById<LinearLayout>(R.id.exercise4).setOnClickListener {
            scrollToTestSection(testSection)
        }

        val backButton: ImageView = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed() // Navigate back to the previous screen
        }
    }

    private fun scrollToTestSection(testSection: View) {
        testSection.visibility = View.VISIBLE
        testSection.requestFocus() // Scrolls to the section
    }
}
