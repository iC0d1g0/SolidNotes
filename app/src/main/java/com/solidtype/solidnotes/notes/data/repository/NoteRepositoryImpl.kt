package com.solidtype.solidnotes.notes.data.repository

import com.solidtype.solidnotes.notes.data.data_source.NoteDao
import com.solidtype.solidnotes.notes.domain.model.Note
import com.solidtype.solidnotes.notes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val dao: NoteDao) :NoteRepository{
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override fun search(search: String): Flow<List<Note>> {
       return dao.search(search)
    }

    override suspend fun getNotesById(id:Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNotes(notes: Note) {
           dao.insertNotes(notes)
    }

    override suspend fun delete(note: Note) {
        dao.deleteNote(note)
    }

    override suspend fun updateNote(note: Note) {
        dao.updateNote(note)
    }
}