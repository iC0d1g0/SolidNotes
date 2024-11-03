package com.solidtype.solidnotes.notes.domain.use_case

import com.solidtype.solidnotes.notes.domain.model.Note
import com.solidtype.solidnotes.notes.domain.model.NoteException
import com.solidtype.solidnotes.notes.domain.repository.NoteRepository
import com.solidtype.solidnotes.notes.domain.util.NoteOrder
import javax.inject.Inject

class AddNoteCase @Inject constructor(private val repo:NoteRepository) {

    @Throws(IllegalArgumentException::class)
    suspend operator fun invoke(note: Note){
        if(note.title.isBlank() || note.content.isBlank()) throw NoteException("Note must have a title and content")

        repo.insertNotes(note)
    }
}