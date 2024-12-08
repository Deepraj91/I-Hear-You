package com.example.ihearyou

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StudentActivity : AppCompatActivity() {

    private lateinit var notificationBell: ImageView
    private lateinit var notepad: ImageView
    private lateinit var learningComponents: TextView
    private lateinit var gujaratiNews: TextView
    private lateinit var exercises: TextView
    private lateinit var performance: TextView
    private lateinit var wordToSign: Button
    private lateinit var signToWord: Button
    private lateinit var noteEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        // Initialize views
        notificationBell = findViewById(R.id.notificationBell)
        notepad = findViewById(R.id.notepad)
        learningComponents = findViewById(R.id.learningComponents)
        gujaratiNews = findViewById(R.id.gujaratiNews)
        exercises = findViewById(R.id.exercises)
        performance = findViewById(R.id.performance)
        wordToSign = findViewById(R.id.wordToSign)
        signToWord = findViewById(R.id.signToWord)
        noteEditText = findViewById(R.id.noteEditText)

        // Ensure EditText doesn't trigger unwanted actions
        noteEditText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                // Do nothing when the EditText gains focus
            }
        }

        // Set up click listeners
        notificationBell.setOnClickListener { navigateToActivity(NotificationActivity::class.java) }
        notepad.setOnClickListener { navigateToActivity(NotepadActivity::class.java) }
        learningComponents.setOnClickListener { navigateToActivity(LearningComponentsActivity::class.java) }
        gujaratiNews.setOnClickListener { navigateToActivity(GujaratiNewsActivity::class.java) }
        exercises.setOnClickListener { navigateToActivity(ExercisesActivity::class.java) }
        performance.setOnClickListener { navigateToActivity(PerformanceActivity::class.java) }
        wordToSign.setOnClickListener { navigateToActivity(WordToSignActivity::class.java) }
        signToWord.setOnClickListener { navigateToActivity(SignToWordActivity::class.java) }
    }

    // Method to handle activity navigation
    private fun navigateToActivity(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}
