package com.Ihsan.ujikom.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.Ihsan.ujikom.activity.database.NotesDatabase
import com.Ihsan.ujikom.model.Notes
import com.Ihsan.ujikom.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes: LiveData<List<Notes>>
    val repository : NoteRepository

    init {
        val dao = NotesDatabase.getDatabase(application).getNotesDao()
        repository = NoteRepository(dao)
        allNotes = repository.allNotes
    }

    fun deleteNote(notes : Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(notes)
    }

    fun updateNote(notes: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(notes)
    }

    fun addNote(notes: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(notes)
    }

}