package com.example.noteapp.ui.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.data.Note

@BindingAdapter(value = ["app:set"])
fun setRecycleItems(view : RecyclerView, items : List<Note>?){
    if(items != null){
        (view.adapter as NoteAdapter).setItem(items)
    }else{
        (view.adapter as NoteAdapter).setItem(emptyList())
    }
}
