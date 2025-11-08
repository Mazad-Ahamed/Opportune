package com.example.opportune

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.opportune.UI_Design.Sign_in
import com.example.opportune.databinding.ActivityChatScreenBinding
import com.google.firebase.auth.FirebaseAuth

class Chat_screen : AppCompatActivity() {
    private lateinit var binding: ActivityChatScreenBinding
    private var auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityChatScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logOutBtn.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, Sign_in::class.java))
            finish()
        }
    }
}