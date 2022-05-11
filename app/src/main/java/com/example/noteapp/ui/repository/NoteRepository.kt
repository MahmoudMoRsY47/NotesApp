package com.example.noteapp.ui.repository

import com.example.noteapp.data.Note
import com.example.noteapp.data.NoteDatabase
import io.reactivex.rxjava3.core.Completable

class NoteRepository {
    val dao= NoteDatabase.getInstanceWithoutContext()
   suspend fun insertNew(note : Note){
       return dao.noteDao().insertNote(note)
    }
    fun getAllNotes()=dao.noteDao().getAllNote()
}