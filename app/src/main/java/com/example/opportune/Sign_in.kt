package com.example.opportune

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.opportune.databinding.ActivitySignInBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class Sign_in : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private var auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGoToSignUp.setOnClickListener {
            startActivity(Intent(this, Sign_up::class.java))
            finish()
        }
        signInValidation()
    }

    fun signInValidation() {
        binding.btnSignIn.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            // Email Regex Pattern
            val emailPattern = Regex("^[A-Za-z0-9._%+-]+@dipti\\.com\\.bd$")

            when {
                email.isEmpty() || password.isEmpty() -> {
                    Snackbar.make(binding.root, "All fields are required", Snackbar.LENGTH_SHORT)
                        .show()
                }

                !email.matches(emailPattern) -> {
                    Snackbar.make(
                        binding.root,
                        "Use official email (example@dipti.com.bd)",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                Snackbar.make(
                                    binding.root,
                                    "Sign in successful",
                                    Snackbar.LENGTH_SHORT
                                ).show()
                                startActivity(Intent(this, Chat_screen::class.java))
                                finish()
                            } else {
                                val errorMessage =
                                    task.exception?.message ?: "Failed to sign in"
                                Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_LONG)
                                    .show()
                            }
                        }
                }
            }
        }
    }

}

