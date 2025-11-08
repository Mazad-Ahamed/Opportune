package com.example.opportune.UI_Design

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.opportune.Chat_screen
import com.example.opportune.databinding.ActivitySignUpBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class Sign_up : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private var auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //intent to signIn activity
        binding.btnGoToSignIn.setOnClickListener {
            startActivity(Intent(this, Sign_in::class.java))
            finish()
        }

        signUpValidation()


    }





    fun signUpValidation() {
        binding.btnSignUp.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val confirmPassword = binding.etConfirmPassword.text.toString().trim()

            // Email & Password Regex Patterns
            val emailPattern = Regex("^[A-Za-z0-9._%+-]+@dipti\\.com\\.bd$")
            val passwordPattern =
                Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}$")

            when {
                email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() -> {
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

                !password.matches(passwordPattern) -> {
                    Snackbar.make(
                        binding.root,
                        "Password must contain at least 8 characters with uppercase, lowercase, number & special character",
                        Snackbar.LENGTH_LONG
                    ).show()
                }

                password != confirmPassword -> {
                    Snackbar.make(binding.root, "Passwords do not match", Snackbar.LENGTH_SHORT)
                        .show()
                }

                else -> {
                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                Snackbar.make(
                                    binding.root,
                                    "User created successfully",
                                    Snackbar.LENGTH_SHORT
                                ).show()
                                startActivity(Intent(this, Chat_screen::class.java))
                                finish()
                            } else {
                                val errorMessage =
                                    task.exception?.message ?: "Failed to create user"
                                Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_LONG)
                                    .show()
                            }
                        }
                }
            }
        }
    }
}