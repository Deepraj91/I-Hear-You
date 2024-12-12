package com.example.ihearyou

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView

class GujaratiNewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gujarati_news)

        val gujaratiVideo: VideoView = findViewById(R.id.gujarati_video)
        val playPoemButton: Button = findViewById(R.id.play_poem_button)

        // URI for the poem video
        val poemUri = Uri.parse("android.resource://${packageName}/${R.raw.poem1}")

        // Button to play the poem video
        playPoemButton.setOnClickListener {
            gujaratiVideo.stopPlayback() // Stop current playback
            gujaratiVideo.setVideoURI(poemUri) // Set URI for the poem video
            gujaratiVideo.start() // Start playback
        }
    }
}
