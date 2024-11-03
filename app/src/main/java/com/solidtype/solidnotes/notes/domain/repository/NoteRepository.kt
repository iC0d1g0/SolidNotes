package com.solidtype.solidnotes.notes.domain.repository

import com.solidtype.solidnotes.notes.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getNotes(): Flow<List<Note>>
    fun search(search:String):Flow<List<Note>>
    suspend fun getNotesById(id: Int):Note?
    suspend fun insertNotes(notes:Note)
    suspend fun delete(note: Note)
    suspend fun updateNote(note:Note)

}