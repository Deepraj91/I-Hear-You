package com.example.ihearyou

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class WordToSignActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_to_sign)

        // Find views by their IDs
        val backButton = findViewById<ImageView>(R.id.backButton)
        val translateButton = findViewById<Button>(R.id.translateButton)
        val inputText = findViewById<EditText>(R.id.inputText)

        // Back button functionality
        backButton.setOnClickListener {
            finish() // Close this activity and return to the previous one
        }

        // Translate button functionality
        translateButton.setOnClickListener {
            val text = inputText.text.toString().trim() // Get text from EditText
            if (text.isNotEmpty()) {
                val intent = Intent(this, TranslateActivity::class.java)
                intent.putExtra("text", text) // Pass the entered text to the next activity
                startActivity(intent) // Start the next activity
            } else {
                inputText.error = "Please enter some text to translate!" // Show error if empty
            }

        }
    }
}
