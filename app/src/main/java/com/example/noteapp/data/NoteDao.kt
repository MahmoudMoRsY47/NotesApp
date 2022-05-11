package com.example.noteapp.data

import androidx.room.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(note: Note)
    @Delete
    suspend fun deleteNote(note: Note)
    @Update
    suspend fun updateNote(note: Note)

    @Query("SELECT * FROM NOTE_TABLE ORDER BY id DESC")
    fun getAllNote():Flow<List<Note>>
}