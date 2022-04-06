package com.Ihsan.ujikom.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.Ihsan.ujikom.R
import com.Ihsan.ujikom.model.Notes
import com.Ihsan.ujikom.model.NotesFirebase
import com.Ihsan.ujikom.viewmodel.NotesViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_edit_note.*
import java.text.SimpleDateFormat
import java.util.*

class AddEditNoteActivity : AppCompatActivity() {

    lateinit var noteTitleEdt: EditText
    lateinit var noteDescriptionEdt: EditText
    lateinit var addupdateBtn: Button
    lateinit var viewModel: NotesViewModel
    var noteID = -1

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database : FirebaseDatabase
    lateinit var  userID : String
    private lateinit var userNotesDatabase : DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_note)

        noteTitleEdt = findViewById(R.id.idEdtNoteTitle)
        noteDescriptionEdt = findViewById(R.id.idEdtNoteDescription)
        addupdateBtn = findViewById(R.id.idBtnAddUpdate)

//        viewModel = ViewModelProvider(
//            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
//        ).get(NotesViewModel::class.java)

        firebaseAuth = FirebaseAuth.getInstance()
        userID = firebaseAuth.uid.toString()
        database = FirebaseDatabase.getInstance()

        userNotesDatabase = database.reference.child("notes").child(userID)




        val noteType = intent.getStringExtra("noteType")
        if (noteType.equals("Edit")) {

            val randomString = getRandomString(16)
            val noteTitle = intent.getStringExtra("title")
            val noteDesc = intent.getStringExtra("description")

            noteID = intent.getIntExtra("noteID", -1)
            addupdateBtn.setText("Update Note")
            noteTitleEdt.setText(noteTitle)
            noteDescriptionEdt.setText(noteDesc)
            userNotesDatabase.child(randomString).child("notetitle").setValue(noteTitle)
            userNotesDatabase.child(randomString).child("notedesc").setValue(noteDesc)



        } else {
            addupdateBtn.setText("Save Note")

        }

        addupdateBtn.setOnClickListener {

            val noteTitle = noteTitleEdt.text.toString()
            val noteDescription = noteDescriptionEdt.text.toString()
            val randomString = getRandomString(16)

            if (noteType.equals("Edit")) {
                val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                val currentDate: String = sdf.format(Date())

//                viewModel.updateNote(updateNote)
                Toast.makeText(this, "Note Updated...", Toast.LENGTH_LONG).show()


            } else {
                if (noteTitle.isNotEmpty() && noteDescription.isNotEmpty()) {
                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                    val currentDate: String = sdf.format(Date())
//                    viewModel.addNote(NotesFirebase(noteTitle, noteDescription, currentDate))
                    Toast.makeText(this, "Note Added...", Toast.LENGTH_LONG).show()
                    userNotesDatabase.child(randomString).child("noteTitle").setValue(noteTitle)
                    userNotesDatabase.child(randomString).child("noteDesc").setValue(noteDescription)
                    userNotesDatabase.child(randomString).child("timeStamp").setValue(currentDate)


                }
            }

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
//            finish()

        }
    }
    fun getRandomString(length: Int) : String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }


}