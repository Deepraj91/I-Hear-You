package com.example.ihearyou

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class LearningComponentsActivity : AppCompatActivity() {

    // Declare VideoView variables
    private lateinit var gujaratiVideo: VideoView
    private lateinit var numbersVideo: VideoView
    private lateinit var englishVideo: VideoView
    private lateinit var moreVideo: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning_components)

        // Initialize video views
        gujaratiVideo = findViewById(R.id.gujarati_video)
        numbersVideo = findViewById(R.id.numbers_video)
        englishVideo = findViewById(R.id.english_video)
        moreVideo = findViewById(R.id.more_video)

        // Setup video views with respective raw resources
        setupVideoView(gujaratiVideo, R.raw.gujarati_alphabets)
        setupVideoView(numbersVideo, R.raw.numbers)
        setupVideoView(englishVideo, R.raw.alphabets)
        setupVideoView(moreVideo, R.raw.math_signs)
    }

    /**
     * Sets up a VideoView with a video file and a MediaController.
     * @param videoView The VideoView to set up.
     * @param rawResourceId The raw resource ID of the video file.
     */
    private fun setupVideoView(videoView: VideoView, rawResourceId: Int) {
        val videoUri = Uri.parse("android.resource://${packageName}/$rawResourceId")
        videoView.setVideoURI(videoUri)

        // Add MediaController for playback controls
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        // Automatically start the video when it's clicked
        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.setOnVideoSizeChangedListener { _, _, _ ->
                videoView.start() // Start video playback
            }
        }

        // Focus the video view to ensure it displays properly
        videoView.setZOrderOnTop(true)
    }
}
