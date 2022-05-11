package com.example.noteapp.ui.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentNoteBinding
import com.example.noteapp.ui.adapter.NoteAdapter

class NoteFragment : Fragment() {
    private lateinit var binding : FragmentNoteBinding
    private val viewModel : NoteViewModel by  viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_note, container, false)
        binding.lifecycleOwner=this
        binding.viewM=viewModel
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val adapter = NoteAdapter(mutableListOf())
        binding.rec.adapter=adapter
    }


}