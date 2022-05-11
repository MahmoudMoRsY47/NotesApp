package com.example.noteapp.data

import android.content.Context
import androidx.room.*

@Database(entities = [Note::class], version = 1)
@TypeConverters(Converters::class)
abstract class NoteDatabase : RoomDatabase(){
    abstract fun noteDao(): NoteDao

    companion object{
        private const val DATABASE_NAME="MyNoteDatabase"
       @Volatile private var instance: NoteDatabase?=null

        fun getInstance(context: Context): NoteDatabase {
            return instance ?: synchronized(this){ buildDataBase(context).also { instance =it }}
//            if (instance==null){
//               instance = buildDataBase(context)
//            }
//            return instance!!
        }


        fun getInstanceWithoutContext(): NoteDatabase {
            return instance!!
        }

        fun buildDataBase(context:Context): NoteDatabase {
            return Room.databaseBuilder(context, NoteDatabase::class.java, DATABASE_NAME).build()
        }
    }

}