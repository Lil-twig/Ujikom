package com.Ihsan.ujikom.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Adapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.Ihsan.ujikom.R
import com.Ihsan.ujikom.Adapter.NoteClickDeleteInterface
import com.Ihsan.ujikom.Adapter.NoteClickInterface
import com.Ihsan.ujikom.Adapter.NotesAdapter
import com.Ihsan.ujikom.model.NotesFirebase
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity(), NoteClickDeleteInterface, NoteClickInterface {
    lateinit var notesRV :RecyclerView
    lateinit var addNote : FloatingActionButton
//    lateinit var viewModel: NotesViewModel
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database : FirebaseDatabase
    lateinit var  userID : String
    private lateinit var userNotesDatabase : DatabaseReference
    lateinit var listNote : ArrayList<NotesFirebase>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAuth = FirebaseAuth.getInstance()
        userID = firebaseAuth.uid.toString()
        database = FirebaseDatabase.getInstance()

        userNotesDatabase = database.reference.child("notes").child(userID)


        notesRV  = findViewById(R.id.idRVNotes)
        addNote  = findViewById(R.id.idFABAddNote)

        notesRV.layoutManager = LinearLayoutManager(this)

        val noteRVAdapter = NotesAdapter(this, this, this)
        notesRV.adapter = noteRVAdapter
//        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NotesViewModel::class.java)
        userNotesDatabase.get().addOnSuccessListener {

            listNote = arrayListOf()
            if (it.value != null){
                for ((k,v) in it.value as Map<Any, Any>){
                    var note = NotesFirebase(k.toString(),"","", "")
                    for ((x,y) in v as Map<Any, Any>){
                        when(x){
                            "noteTitle"->{
                                note.noteTitle = y as String
                            }
                            "noteDesc"->{
                                note.noteDesc = y as String
                            }
                            "timeStamp"->{
                                note.timeStamp = y as String
                            }
                        }
                    }
                    listNote.add(note)

                }


            }

//            Log.d("test", it.value)
            noteRVAdapter.updateList(listNote)

        }


        addNote.setOnClickListener {
            val intent = Intent(this@MainActivity,AddEditNoteActivity::class.java)
            startActivity(intent)
//            this.finish()
        }

    }

    override fun onDeleteIconClick(note: NotesFirebase) {
//        viewModel.deleteNote(note)
        database.getReference()
            .child("notes")
            .child(firebaseAuth.uid.toString())
            .child(note.id)
            .removeValue().addOnSuccessListener {
                listNote.remove(note)
                startActivity(Intent(this, MainActivity::class.java)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))
                Toast.makeText(this, "${note.noteTitle} Deleted", Toast.LENGTH_LONG).show()
        }

    }

    override fun onNoteClick(note: NotesFirebase) {
        val intent = Intent(this@MainActivity, AddEditNoteActivity::class.java)
        intent.putExtra("noteType", "Edit")
        intent.putExtra("title", note.noteTitle)
        intent.putExtra("description", note.noteDesc)
        startActivity(intent)
//        finish()
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.itmLogout -> {
                firebaseAuth.signOut()
                Toast.makeText(this, "Logout sukses", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                true

            }
            R.id.itmProfile -> {
                startActivity(Intent(this, ProfileActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.my_menu, menu)
        return true
    }
}