package com.solidtype.solidnotes.notes.presentation.notes


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solidtype.solidnotes.notes.domain.model.Note
import com.solidtype.solidnotes.notes.domain.use_case.Casos_Usos
import com.solidtype.solidnotes.notes.domain.util.NoteOrder
import com.solidtype.solidnotes.notes.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val casosUsos: Casos_Usos) : ViewModel() {

    var uiState = MutableStateFlow(NoteState())
        private set
    private var recentlyDeletedNote: Note? = null

    private var getNotesJob: Job? = null

init {
    getNotes(NoteOrder.Date(OrderType.Descending))
}
    fun a(){
        println("Nada")
    }

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.Order -> {
                if(uiState.value.noteOrder::class == event.noteorder::class &&
                    uiState.value.noteOrder.orderType == event.noteorder.orderType) return

                getNotes(event.noteorder)
            }

            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    casosUsos.deleteNote(event.note)
                    recentlyDeletedNote = event.note
                }
            }

            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    casosUsos.addNoteCase(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }

            is NotesEvent.ToggleOrderSection -> {
                uiState.update {
                    it.copy(isOrderSectionVisible = !uiState.value.isOrderSectionVisible)
                }
            }
        }
    }

    private fun getNotes(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        getNotesJob = viewModelScope.launch {
            casosUsos.getNotesCase(noteOrder).onEach { notes ->
                uiState.update {
                    it.copy(
                        notes = notes,
                        noteOrder = noteOrder
                    )
                }
            }.launchIn(viewModelScope)
        }
    }
}