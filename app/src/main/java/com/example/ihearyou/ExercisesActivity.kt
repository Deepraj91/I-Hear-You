package com.example.ihearyou

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ExercisesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercises)

        // URLs for the forms
        val gujaratiAlphabetUrl = "https://docs.google.com/forms/d/e/1FAIpQLScLkxVm4-KAJWKUs94RVdGLCbnwIvWA_7R44YRLmieW4lqDrw/viewform?usp=header"
        val numberUrl = "https://docs.google.com/forms/d/e/1FAIpQLSfxtK3pMGE4VjWM2PqaE0bsVnsAtAnrq4SUHsEM-0uPAXuxnQ/viewform?usp=header"

        // Click listener for Gujarati Alphabet
        findViewById<TextView>(R.id.exercise1_link).setOnClickListener {
            openLink(gujaratiAlphabetUrl)
        }

        // Click listener for Numbers
        findViewById<TextView>(R.id.exercise2_link).setOnClickListener {
            openLink(numberUrl)
        }

        // Back button navigation
        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    // Function to open URL
    private fun openLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
