package com.example.ihearyou

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var languageSpinner: Spinner
    private lateinit var roleSpinner: Spinner
    private lateinit var goButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize Views
        languageSpinner = findViewById(R.id.languageSpinner)
        roleSpinner = findViewById(R.id.roleSpinner)
        goButton = findViewById(R.id.goButton)

        // Set up Language Spinner
        val languages = arrayOf("English", "Hindi", "gujarati")
        val languageAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        languageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        languageSpinner.adapter = languageAdapter

        // Set up Role Spinner
        val roles = arrayOf("Student", "Parent", "Admin")
        val roleAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, roles)
        roleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        roleSpinner.adapter = roleAdapter

        // Handle Go Button Click
        goButton.setOnClickListener {
            val selectedLanguage = languageSpinner.selectedItem.toString()
            val selectedRole = roleSpinner.selectedItem.toString()

            if (selectedLanguage.isEmpty() || selectedRole.isEmpty()) {
                Toast.makeText(this, "Please select both language and role", Toast.LENGTH_SHORT).show()
            } else {
                // Navigate to next activity based on selected role
                val intent = when (selectedRole) {
                    "Student" -> Intent(this, StudentActivity::class.java)
                    "Parent" -> Intent(this, ParentActivity::class.java)
                    "Admin" -> Intent(this, AdminActivity::class.java)
                    else -> null
                }

                intent?.putExtra("selectedLanguage", selectedLanguage)
                startActivity(intent)
            }
        }
    }
}
