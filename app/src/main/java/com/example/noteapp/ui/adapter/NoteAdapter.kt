package com.example.noteapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.data.Note
import com.example.noteapp.databinding.NoteItemBinding
import kotlin.random.Random

class NoteAdapter(private var item:List<Note>) :RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private var lastPosition =-1
    class NoteViewHolder(viewItem : View) : RecyclerView.ViewHolder(viewItem) {
        val binding = NoteItemBinding.bind(viewItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val current=item[position]
        setAnimation(holder.itemView, position)
        holder.binding.apply {
            note.text=current.content
            date.text=current.date.toString()
        }
    }

    override fun getItemCount()=item.size

    private fun setAnimation(viewToAnimate: View, position: Int) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            val anim = ScaleAnimation(
                0.0f,
                1.0f,
                0.0f,
                1.0f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            )
            anim.duration = Random.nextLong(501) //to make duration random number between [0,501)
            viewToAnimate.startAnimation(anim)
            lastPosition = position
        }
    }



    fun setItem(newItem: List<Note>){
        item=newItem
        notifyDataSetChanged()
    }

}
