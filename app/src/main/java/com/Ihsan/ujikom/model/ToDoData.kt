package com.Ihsan.ujikom.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.Ihsan.ujikom.data.Priority
import kotlinx.android.parcel.Parcelize

@Entity(tableName ="todo_table")
@Parcelize
class ToDoData (
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var title:String,
    var priority: Priority,
    var description:Strin

):Parcelable