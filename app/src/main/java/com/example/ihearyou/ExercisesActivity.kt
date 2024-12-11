package com.example.ihearyou

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class ExercisesActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercises)

        val animalsSection: LinearLayout = findViewById(R.id.animals_section)
        val basicsSection: LinearLayout = findViewById(R.id.basics_section)

        animalsSection.setOnClickListener {
            // Navigate to AnimalsActivity
            val intent = Intent(this, AnimalsActivity::class.java)
            startActivity(intent)
        }

        basicsSection.setOnClickListener {
            // Navigate to BasicsActivity
            val intent = Intent(this, BasicsActivity::class.java)
            startActivity(intent)
        }
    }
}
