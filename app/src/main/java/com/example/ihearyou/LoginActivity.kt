package com.example.ihearyou

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var languageSpinner: Spinner
    private lateinit var roleSpinner: Spinner
    private lateinit var ageSpinner: Spinner
    private lateinit var goButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize Views
        languageSpinner = findViewById(R.id.languageSpinner)
        roleSpinner = findViewById(R.id.roleSpinner)
        ageSpinner = findViewById(R.id.ageSpinner)
        goButton = findViewById(R.id.goButton)

        // Set up Language Spinner
        val languages = arrayOf("English", "Hindi", "Gujarati")
        val languageAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        languageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        languageSpinner.adapter = languageAdapter

        // Set up Role Spinner
        val roles = arrayOf("Student", "Parent", "Admin")
        val roleAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, roles)
        roleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        roleSpinner.adapter = roleAdapter

        // Set up Age Spinner
        val ages = arrayOf("Select Age", "1-12", "12-20", "20-46", "46-60", "60+")
        val ageAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ages)
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        ageSpinner.adapter = ageAdapter

        // Handle Go Button Click
        goButton.setOnClickListener {
            val selectedLanguage = languageSpinner.selectedItem.toString()
            val selectedRole = roleSpinner.selectedItem.toString()
            val selectedAge = ageSpinner.selectedItem.toString()

            // Validate Inputs
            if (selectedLanguage.isEmpty() || selectedRole.isEmpty() || selectedAge == "Select Age") {
                Toast.makeText(this, "Please select language, role, and age", Toast.LENGTH_SHORT).show()
            } else {
                // Navigate to the next activity based on role
                val intent = when (selectedRole) {
                    "Student" -> Intent(this, StudentActivity::class.java)
                    "Parent" -> Intent(this, ParentActivity::class.java)
                    "Admin" -> Intent(this, AdminActivity::class.java)
                    else -> null
                }

                if (intent != null) {
                    intent.putExtra("selectedLanguage", selectedLanguage)
                    intent.putExtra("selectedAge", selectedAge)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Invalid role selected", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
