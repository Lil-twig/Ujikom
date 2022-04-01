package com.Ihsan.ujikom.data

import androidx.room.TypeConverter
import java.math.RoundingMode.valueOf


class Converter {

    @TypeConverter
    fun fromPriority(priority: Priority):String{
        return  priority.name
    }

    @TypeConverter
    fun toPriority(priority: String):Priority{
        return Priority.valueOf(priority)
    }


}