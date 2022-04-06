package com.Ihsan.ujikom.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.Ihsan.ujikom.database.NotesDatabase
import com.Ihsan.ujikom.model.Notes
import com.Ihsan.ujikom.model.NotesFirebase
import com.Ihsan.ujikom.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class NotesViewModel(application: Application) : AndroidViewModel(application) {

//    val allNotes: LiveData<List<NotesFirebase>>
//abstract val repository : NoteRepository

    init {
//        val dao = NotesDatabase.getDatabase(application).getNotesDao()
//        repository = NoteRepository(dao)
//        allNotes = repository.allNotes
    }

//    fun deleteNote(notes: NotesFirebase) = viewModelScope.launch(Dispatchers.IO) {
//        repository.delete(notes)
//    }
//
//    fun updateNote(notes: NotesFirebase) = viewModelScope.launch(Dispatchers.IO) {
//        repository.update(notes)
//    }
//
//    fun addNote(notes: NotesFirebase) = viewModelScope.launch(Dispatchers.IO) {
//        repository.insert(notes)
//    }

}