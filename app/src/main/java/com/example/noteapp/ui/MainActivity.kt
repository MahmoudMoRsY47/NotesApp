package com.example.noteapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.noteapp.R
import com.example.noteapp.data.NoteDatabase
import com.example.noteapp.databinding.ActivityMainBinding
import com.example.noteapp.ui.ui.NoteFragment

class MainActivity : AppCompatActivity() {
    private val fragment = NoteFragment()
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        NoteDatabase.getInstance(applicationContext)
        initView()
    }
    private fun initView() {
        val transiction= supportFragmentManager.beginTransaction()
        transiction.replace(R.id.fra,fragment)
        transiction.commit()
    }
}