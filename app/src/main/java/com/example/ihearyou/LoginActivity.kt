package com.example.ihearyou

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var languageSpinner: Spinner
    private lateinit var roleSpinner: Spinner
    private lateinit var loginButton: Button

    // Default email and password for validation
    private val defaultEmail = "kushwahadeepraj91@gmail.com"
    private val defaultPassword = "number7024313357"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize Views
        emailInput = findViewById(R.id.emailInput)
        passwordInput = findViewById(R.id.passwordInput)
        languageSpinner = findViewById(R.id.languageSpinner)
        roleSpinner = findViewById(R.id.roleSpinner)
        loginButton = findViewById(R.id.loginButton)

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

        // Handle Login Button Click
        loginButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()
            val selectedLanguage = languageSpinner.selectedItem.toString()
            val selectedRole = roleSpinner.selectedItem.toString()

            // Validate Input
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            } else if (selectedLanguage.isEmpty() || selectedRole.isEmpty()) {
                Toast.makeText(this, "Please select both language and role", Toast.LENGTH_SHORT).show()
            } else {
                // Check if email and password match the default credentials
                if (email == defaultEmail && password == defaultPassword) {
                    // Navigate to the next activity based on role
                    val intent = when (selectedRole) {
                        "Student" -> Intent(this, StudentActivity::class.java)
                        else -> null
                    }
                    intent?.putExtra("selectedLanguage", selectedLanguage)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
