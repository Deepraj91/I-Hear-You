package com.example.ihearyou

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class GujaratiNewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gujarati_news)

        // Find the Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)

        // Set up the toolbar with a back button
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        // Handle back button click
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}
