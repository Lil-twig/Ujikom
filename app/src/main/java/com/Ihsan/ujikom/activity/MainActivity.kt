package com.Ihsan.ujikom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.Ihsan.ujikom.R
import com.Ihsan.ujikom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView()



    }

    private fun recyclerView() {

    }
}