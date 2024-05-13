package com.example.tugas3_20411019

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas3_20411019.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class Register_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnRegister.setOnClickListener {
            val email: String = binding.editEmail.text.toString().trim()
            val password: String = binding.edtPassword.text.toString().trim()
            val confirmPassword: String = binding.edtConfirmPassword.text.toString().trim()

            if (email.isEmpty()) {
                binding.editEmail.error = "Input Email"
                binding.editEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.editEmail.error = "Invalid email"
                binding.editEmail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length < 6) {
                binding.edtPassword.error = "Password must be more than 6 characters"
                binding.edtPassword.requestFocus()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                binding.edtConfirmPassword.error = "Password must be match"
                binding.edtConfirmPassword.requestFocus()
                return@setOnClickListener
            }
            registerUser(email, password)
        }

        binding.textLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    private fun registerUser(email: String, password: String) {

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                Intent(this, MainActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
            else {
                Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser != null) {
            Intent(this, MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }

}

