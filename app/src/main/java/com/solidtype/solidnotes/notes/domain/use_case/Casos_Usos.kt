package com.solidtype.solidnotes.notes.domain.use_case

data class Casos_Usos(
    val addNoteCase: AddNoteCase,
    val deleteNote: DeleteNote,
    val getNotesById: GetNotesById,
    val getNotesCase: GetNotesCase,
    val updateNotesCase: UpdateNotesCase

)
