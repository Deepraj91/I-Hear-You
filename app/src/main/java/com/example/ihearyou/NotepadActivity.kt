package com.example.ihearyou

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NotepadActivity : AppCompatActivity() {

    private var savedNote: String? = null // Temporary storage for note text

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_notepad)

        // Handle window insets for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val noteEditText: EditText = findViewById(R.id.noteEditText)
        val saveButton: Button = findViewById(R.id.saveButton)
        val backButton: ImageButton = findViewById(R.id.backButton)

        // Restore the saved note (if any)
        savedNote?.let {
            noteEditText.setText(it)
        }

        // Save button click listener
        saveButton.setOnClickListener {
            val noteText = noteEditText.text.toString()
            if (noteText.isBlank()) {
                Toast.makeText(this, "Note is empty!", Toast.LENGTH_SHORT).show()
            } else {
                savedNote = noteText
                Toast.makeText(this, "Note saved!", Toast.LENGTH_SHORT).show()
            }
        }

        // Back button click listener
        backButton.setOnClickListener {
            finish() // Finish the current activity and go back to the previous one
        }
    }
}
