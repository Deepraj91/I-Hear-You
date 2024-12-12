package com.example.ihearyou

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PerformanceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enable edge-to-edge display
        setContentView(R.layout.activity_performance)

        setupToolbar()
        handleWindowInsets()
        setupQuizInteraction()
    }

    /**
     * Sets up the toolbar with a back button.
     */
    private fun setupToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Show back button in the toolbar
    }

    /**
     * Adjusts padding to account for system bars when using edge-to-edge display.
     */
    private fun handleWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    /**
     * Sets up the quiz interaction, including handling the submit button click.
     */
    private fun setupQuizInteraction() {
        val question2Options: RadioGroup = findViewById(R.id.question_2_options)
        val submitButton: Button = findViewById(R.id.submit_button)

        submitButton.setOnClickListener {
            val selectedAnswerId = question2Options.checkedRadioButtonId

            if (selectedAnswerId != -1) {
                val selectedAnswer: RadioButton = findViewById(selectedAnswerId)
                checkAnswer(selectedAnswer)
            } else {
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * Checks if the selected answer is correct and displays a corresponding message.
     *
     * @param selectedAnswer The selected RadioButton.
     */
    private fun checkAnswer(selectedAnswer: RadioButton) {
        if (selectedAnswer.id == R.id.option_2b) {
            // Correct answer
            Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT).show()
        } else {
            // Incorrect answer
            Toast.makeText(this, "Incorrect Answer. Try again!", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Handles the back button press in the toolbar.
     */
    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed() // Navigate to the previous activity
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
