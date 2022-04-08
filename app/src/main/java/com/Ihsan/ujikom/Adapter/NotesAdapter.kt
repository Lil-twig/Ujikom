package com.Ihsan.ujikom.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.Ihsan.ujikom.R
import com.Ihsan.ujikom.model.NotesFirebase


class NotesAdapter (
        val context: Context,
        val noteClickInterface: NoteClickInterface,
        val noteClickDeleteInterface: NoteClickDeleteInterface
        ) : RecyclerView.Adapter<NotesAdapter.ViewHolder>(){

        private val allNotes = ArrayList<NotesFirebase>()


                inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
                        val noteTV = itemView.findViewById<TextView>(R.id.idTVNoteTitle)
                        val timeTV = itemView.findViewById<TextView>(R.id.idTVTimeStamp)
                        val deleteIV = itemView.findViewById<ImageView>(R.id.idTVDelete)
                }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.note_rv_item, parent, false);
                return ViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                holder.noteTV.setText(allNotes.get(position).noteTitle)
                holder.timeTV.setText("Last Update : "+ allNotes.get(position).timeStamp)
                Log.d("test",allNotes.get(position).toString())


                holder.deleteIV.setOnClickListener {
                        noteClickDeleteInterface.onDeleteIconClick(allNotes.get(position))
                }

                holder.itemView.setOnClickListener {
                        noteClickInterface.onNoteClick(allNotes.get(position))
                }
        }

        override fun getItemCount(): Int {
                return allNotes.size
        }

        fun updateList(newList: ArrayList<NotesFirebase>){
                allNotes.clear()
                allNotes.addAll(newList)
                notifyDataSetChanged()
        }
}

interface NoteClickDeleteInterface{
        fun onDeleteIconClick(note: NotesFirebase)
}

interface NoteClickInterface{
        fun onNoteClick(get: NotesFirebase)
}