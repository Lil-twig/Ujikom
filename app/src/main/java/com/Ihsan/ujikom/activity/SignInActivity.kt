package com.Ihsan.ujikom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.Ihsan.ujikom.R
import com.Ihsan.ujikom.databinding.ActivitySignInBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignInBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding = ActivitySignInBinding.inflate(layoutInflater)

        binding.btnSignUp.setOnClickListener {

            val namaOrangtua = binding.signNamaOrangTua.text.toString()
            val password = binding.signPw.text.toString()
            val namaAnak = binding.signAnak.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Users")



        }

    }
}