package com.example.ihearyou
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView

class GujaratiNewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gujarati_news)

        val gujaratiVideo: VideoView = findViewById(R.id.gujarati_video)

        // Set video URI for the Gujarati VideoView
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.gujarati_alphabets)
        gujaratiVideo.setVideoURI(videoUri)

        // Set click listener to play the video
        gujaratiVideo.setOnClickListener {
            if (!gujaratiVideo.isPlaying) {
                gujaratiVideo.start()
            }
        }
    }
}