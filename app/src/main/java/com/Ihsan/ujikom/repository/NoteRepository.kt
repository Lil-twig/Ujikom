package com.Ihsan.ujikom.repository

import androidx.lifecycle.LiveData
import com.Ihsan.ujikom.dao.NotesDao
import com.Ihsan.ujikom.model.Notes
import com.Ihsan.ujikom.model.NotesFirebase

class NoteRepository(private val notesDao: NotesDao) {

////    val allNotes :LiveData<List<NotesFirebase>> = notesDao.getAllNotes()
////
////    suspend fun insert(notes: NotesFirebase) {
////        notesDao.insert(notes)
////        return
////    }
////
////    suspend fun update(notes: NotesFirebase) {
////        notesDao.update(notes)
////        return
////    }
////
//    suspend fun delete(notes: NotesFirebase) {
//        notesDao.delete(notes)
//        return
//    }
}