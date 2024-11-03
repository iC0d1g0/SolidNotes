package com.solidtype.solidnotes.notes.domain.use_case

import com.solidtype.solidnotes.notes.domain.model.Note
import com.solidtype.solidnotes.notes.domain.repository.NoteRepository
import com.solidtype.solidnotes.notes.domain.util.NoteOrder
import com.solidtype.solidnotes.notes.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetNotesCase @Inject constructor(private val repo: NoteRepository) {

    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)): Flow<List<Note>> {

        return repo.getNotes().map { notes ->
            when (noteOrder.orderType) {
                is OrderType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy {it.title.lowercase()}
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy {it.title.lowercase()}
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
            }
        }
    }
}