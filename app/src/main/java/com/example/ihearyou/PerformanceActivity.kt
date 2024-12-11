package com.example.ihearyou

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.widget.Toolbar

class PerformanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_performance)

        // Set up the toolbar and enable back button
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)  // Show back button in the toolbar

        // Handle window insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get the RadioGroup and the submit button
        val question2Options: RadioGroup = findViewById(R.id.question_2_options)
        val submitButton: Button = findViewById(R.id.submit_button)

        // Set click listener for the submit button
        submitButton.setOnClickListener {
            // Get selected answer
            val selectedAnswer = findViewById<RadioButton>(question2Options.checkedRadioButtonId)

            // Check if an option was selected
            if (selectedAnswer != null) {
                // Check if the selected answer is correct (option 2b: "4")
                if (selectedAnswer.id == R.id.option_2b) {
                    // Correct answer
                    Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT).show()
                } else {
                    // Incorrect answer
                    Toast.makeText(this, "Incorrect Answer. Try again!", Toast.LENGTH_SHORT).show()
                }
            } else {
                // No option selected
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Handle back button press in the toolbar
    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()  // Go back to the previous activity
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
