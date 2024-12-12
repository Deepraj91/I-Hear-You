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

        val basicsSection: LinearLayout = findViewById(R.id.basics_section)

        basicsSection.setOnClickListener {
            // Navigate to BasicsActivity
            val intent = Intent(this, BasicsActivity::class.java)
            startActivity(intent)
        }
    }
}