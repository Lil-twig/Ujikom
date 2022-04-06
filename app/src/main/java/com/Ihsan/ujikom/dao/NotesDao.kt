package com.Ihsan.ujikom.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.Ihsan.ujikom.model.Notes
import com.Ihsan.ujikom.model.NotesFirebase


@Dao
interface NotesDao {

//    @Insert( onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insert (notes: com.Ihsan.ujikom.model.NotesFirebase)
//
//    @Update
//    suspend fun update (notes: com.Ihsan.ujikom.model.NotesFirebase)
//
//    @Delete
//    suspend fun delete (notes: com.Ihsan.ujikom.model.NotesFirebase)

//    @Query("Select * From notesTable order by id ASC")
//    fun getAllNotes() :LiveData<List<NotesFirebase>>

}