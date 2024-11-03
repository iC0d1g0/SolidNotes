package com.solidtype.solidnotes.notes.presentation.notes

import com.solidtype.solidnotes.notes.domain.model.Note
import com.solidtype.solidnotes.notes.domain.util.NoteOrder

sealed class NotesEvent {

    data class Order(val noteorder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()

    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()



}