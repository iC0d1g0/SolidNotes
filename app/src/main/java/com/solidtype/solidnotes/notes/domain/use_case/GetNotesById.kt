package com.solidtype.solidnotes.notes.domain.use_case

import com.solidtype.solidnotes.notes.domain.repository.NoteRepository
import javax.inject.Inject

class GetNotesById @Inject constructor(private val repo: NoteRepository) {

    suspend operator fun invoke(id:Int) = repo.getNotesById(id)
}
