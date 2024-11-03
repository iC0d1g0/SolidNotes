package com.solidtype.solidnotes.notes.presentation.util

sealed class Pantallas(val route: String) {
    object NotesScreens: Pantallas("notes_screen")
    object AddEditNoteScreens: Pantallas("add_edit_note_screen")
}
