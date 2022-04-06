package com.Ihsan.ujikom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.Ihsan.ujikom.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlin.properties.Delegates

class ProfileActivity : AppCompatActivity() {

    lateinit var firebaseAuth : FirebaseAuth
    lateinit var database : FirebaseDatabase
    lateinit var txt_Profile : TextView
    lateinit var txt_Notes : TextView

    var notesCount by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        txt_Profile = findViewById(R.id.txt_profile)
        txt_Notes = findViewById(R.id.txt_Profile_Note)


        firebaseAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        notesCount = 0

        val email = firebaseAuth.currentUser?.email

        val notes = firebaseAuth.uid?.let { database.reference.child("notes").child(it) }
        notes?.get()?.addOnSuccessListener {
            for ((_,_) in it.value as Map<Any,Any>){
                notesCount++
            }
            txt_Profile.setText(email)
            txt_Notes.setText(notesCount.toString())
        }



    }
}