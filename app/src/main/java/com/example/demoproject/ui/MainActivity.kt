package com.example.demoproject.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.demoproject.MapsActivity
import com.example.demoproject.R
import com.example.demoproject.Utits.*
import com.example.demoproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setClickListener()
    }

    private fun setClickListener() {
        binding?.apply {
            userEmail.onTextChanged {
                Log.d("MainActivity","setClickListener A13 : $it")
                validateCredential()
            }
            userPassword.onTextChanged {
                validateCredential()
            }
            userLogin.setOnClickListener {
                    startActivity(Intent(applicationContext,MapsActivity::class.java).putExtra(USER_MAIL_KEY,userEmail.text.toString()))
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.login_success),
                        Toast.LENGTH_SHORT
                    ).show()
            }
        }
    }

    private fun validateCredential() {
        binding?.apply {
            Log.d("MainActivity","validateCredential A13 : ${userEmail.text.toString().validateMail()}  , ${userPassword.text.toString().validatePassword()}")
            userLogin.isEnabled = userEmail.text.toString().validateMail() && userPassword.text.toString().validatePassword()
        }
    }
}