package com.solidtype.solidnotes.notes.data.data_source.settings

import androidx.room.Database
import androidx.room.RoomDatabase
import com.solidtype.solidnotes.notes.data.data_source.NoteDao
import com.solidtype.solidnotes.notes.domain.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NotesDB: RoomDatabase() {

    abstract val notesdb: NoteDao
    companion object{
        const val  DATABASE="Notes_DB"
    }


}