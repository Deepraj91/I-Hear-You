package com.example.ihearyou
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.FirebaseException
import java.util.concurrent.TimeUnit

class LoginActivity : AppCompatActivity() {

    private lateinit var phoneNumberEditText: EditText
    private lateinit var otpEditText: EditText
    private lateinit var sendOtpButton: Button
    private lateinit var verifyOtpButton: Button
    private lateinit var languageSpinner: Spinner

    private var verificationId: String? = null // Nullable to avoid initialization issues

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize Views
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText)
        otpEditText = findViewById(R.id.otpEditText)
        sendOtpButton = findViewById(R.id.sendOtpButton)
        verifyOtpButton = findViewById(R.id.verifyOtpButton)
        languageSpinner = findViewById(R.id.languageSpinner)

        // Set up Spinner (Language selection)
        val languages = arrayOf("English", "Hindi", "Tamil", "Kannada")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        languageSpinner.adapter = adapter

        // Handle Send OTP button click
        sendOtpButton.setOnClickListener {
            val phoneNumber = phoneNumberEditText.text.toString()
            if (phoneNumber.isEmpty()) {
                Toast.makeText(this, "Please enter a valid phone number", Toast.LENGTH_SHORT).show()
            } else {
                sendOtp(phoneNumber) // Function to send OTP
            }
        }

        // Handle Verify OTP button click
        verifyOtpButton.setOnClickListener {
            val otp = otpEditText.text.toString()
            if (otp.isEmpty()) {
                Toast.makeText(this, "Please enter the OTP", Toast.LENGTH_SHORT).show()
            } else {
                verifyOtp(otp) // Function to verify OTP
            }
        }
    }

    private fun sendOtp(phoneNumber: String) {
        // Firebase Authentication - Send OTP
        val options = PhoneAuthOptions.newBuilder(FirebaseAuth.getInstance())
            .setPhoneNumber(phoneNumber) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout duration
            .setActivity(this) // Current Activity
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                    // Auto-verification completed (e.g., verification code is auto-filled)
                    Toast.makeText(this@LoginActivity, "Phone number verified automatically", Toast.LENGTH_SHORT).show()
                }

                override fun onVerificationFailed(e: FirebaseException) {
                    // Handle verification failure
                    Toast.makeText(this@LoginActivity, "Verification failed: ${e.message}", Toast.LENGTH_SHORT).show()
                }

                override fun onCodeSent(verificationId: String, token: PhoneAuthProvider.ForceResendingToken) {
                    // OTP sent successfully
                    this@LoginActivity.verificationId = verificationId
                    otpEditText.visibility = View.VISIBLE
                    verifyOtpButton.visibility = View.VISIBLE
                    sendOtpButton.visibility = View.GONE
                    Toast.makeText(this@LoginActivity, "OTP sent. Please check your phone.", Toast.LENGTH_SHORT).show()
                }
            })
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun verifyOtp(otp: String) {
        // Verify OTP entered by the user
        if (verificationId == null) {
            Toast.makeText(this, "Verification ID is null. Please resend the OTP.", Toast.LENGTH_SHORT).show()
            return
        }

        val credential = PhoneAuthProvider.getCredential(verificationId!!, otp)

        FirebaseAuth.getInstance().signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // OTP Verified and User Logged In Successfully
                    Toast.makeText(this, "OTP Verified! You are logged in.", Toast.LENGTH_SHORT).show()
                    // Proceed to next activity after successful login
                } else {
                    // OTP Verification Failed
                    Toast.makeText(this, "OTP Verification failed", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
