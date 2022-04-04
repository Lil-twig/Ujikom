package com.Ihsan.ujikom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.Ihsan.ujikom.R
import com.Ihsan.ujikom.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var notesRV :RecyclerView
    lateinit var addNote : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        notesRV  = findViewById(R.id.idRVNotes)
        addNote  = findViewById(R.id.idFABAddNote)

    }


}