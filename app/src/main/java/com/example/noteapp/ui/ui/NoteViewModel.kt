package com.example.noteapp.ui.ui

import androidx.lifecycle.*
import com.example.noteapp.data.Note
import com.example.noteapp.ui.repository.NoteRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*


class NoteViewModel :ViewModel() {
     val repo=NoteRepository()
     val newNotes=MutableLiveData<String>()
     private val _notes=MutableLiveData<List<Note>>()
     val notes:LiveData<List<Note>> = repo.getAllNotes().asLiveData()
//     init { loadNotes() }
     fun addNote(){
          viewModelScope.launch {
               newNotes.value?.let {
                    repo.insertNew(Note(0,it,Date(),true))
                    newNotes.postValue("")
               }
          }
     }

//     private fun loadNotes(){
//          viewModelScope.launch {
//              repo.getAllNotes().collect{
//                   _notes.postValue(it)
//              }
//
//          }
//     }
}