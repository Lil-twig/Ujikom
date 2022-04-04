package com.Ihsan.ujikom.repository

import androidx.lifecycle.LiveData
import com.Ihsan.ujikom.activity.dao.NotesDao
import com.Ihsan.ujikom.model.Notes

class NoteRepository(private val notesDao: NotesDao) {

    val allNotes :LiveData<List<Notes>> = notesDao.getAllNotes()

    suspend fun insert(notes: Notes) {
        notesDao.insert(notes)
    }

    suspend fun update(notes: Notes) {
        notesDao.update(notes)
    }

    suspend fun delete(notes: Notes) {
        notesDao.delete(notes)
    }
}