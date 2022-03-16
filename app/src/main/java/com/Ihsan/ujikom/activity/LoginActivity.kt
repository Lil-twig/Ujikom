package com.Ihsan.ujikom.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.Ihsan.ujikom.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val textVIew = findViewById<TextView>(R.id.link_toSignUp)
        textVIew.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignInActivity::class.java))
        }
    }
}