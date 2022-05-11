package com.example.noteapp.data

import android.provider.ContactsContract
import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun dataToLong(data: Date) : Long{
        return data.time
    }

    @TypeConverter
    fun dataToLong(long: Long) : Date {
        return Date(long)
    }
}