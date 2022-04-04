package com.Ihsan.ujikom.activity.Adapter

import android.content.Context
//import android.provider.ContactsContract
import android.provider.ContactsContract.CommonDataKinds.Note


class NotesAdapter (
        val context: Context,
        val noteClickInterface: NoteClickInterface,
        val noteClickDeleteInterface: NoteClickDeleteInterface) {
}

interface NoteClickDeleteInterface{
        fun onDeleteIconClick(note: Note)
}

interface NoteClickInterface{
        fun onDeleteIconClick(note: Note)
}