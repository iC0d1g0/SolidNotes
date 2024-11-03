package com.solidtype.solidnotes.notes.domain.use_case

import com.solidtype.solidnotes.notes.domain.model.Note
import com.solidtype.solidnotes.notes.domain.repository.NoteRepository
import javax.inject.Inject

class UpdateNotesCase @Inject constructor(private val repo:NoteRepository) {
    suspend operator fun invoke(note: Note) = repo.updateNote(note)
}