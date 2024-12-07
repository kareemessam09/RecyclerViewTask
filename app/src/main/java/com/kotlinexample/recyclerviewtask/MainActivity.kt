package com.kotlinexample.task1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kotlinexample.task1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        binding.login.setOnClickListener {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()
            if (validatePassword(password).not()) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SecondaryActivity::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
                finish()
            }

        }
    }

    fun validatePassword(password: String): Boolean {
        val minLength = 8
        val maxLength = 16

        val hasUpperCase = password.any { it.isUpperCase() }
        val hasLowerCase = password.any { it.isLowerCase() }
        val hasNumbers = password.any { it.isDigit() }
        val hasSpecialChar = password.any { it in "!@#$%^&*(),.?\":{}|<>" }
        val isValidLength = password.length in minLength..maxLength

        return isValidLength && hasUpperCase && hasLowerCase && hasNumbers && hasSpecialChar
    }



}