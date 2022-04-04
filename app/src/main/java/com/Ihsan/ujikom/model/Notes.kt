package com.Ihsan.ujikom.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notesTable")
class Notes(
    @ColumnInfo(name = "title")
            val noteTitle:String,

    @ColumnInfo(name = "desciption")
            val noteDesc : String,

    @ColumnInfo(name = "timestamp")
            val timeStamp :String )

{

    @PrimaryKey (autoGenerate = true)
    var id = 0


}