import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.ihearyou.R

class StudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        // Notification Bell
        val notificationBell = findViewById<ImageView>(R.id.notificationBell)
        notificationBell.setOnClickListener {
            // Navigate to NotificationActivity
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }

        // Learning Components
        val learningComponents = findViewById<LinearLayout>(R.id.learningComponents)
        learningComponents.setOnClickListener {
            // Open Learning Activity
            val intent = Intent(this, LearningActivity::class.java)
            startActivity(intent)
        }

        // Word to Sign
        val wordToSignButton = findViewById<Button>(R.id.wordToSign)
        wordToSignButton.setOnClickListener {
            // Navigate to WordToSignActivity
            val intent = Intent(this, WordToSignActivity::class.java)
            startActivity(intent)
        }

        // Sign to Word
        val signToWordButton = findViewById<Button>(R.id.signToWord)
        signToWordButton.setOnClickListener {
            // Open Camera and Translator
            val intent = Intent(this, SignToWordActivity::class.java)
            startActivity(intent)
        }
    }
}
