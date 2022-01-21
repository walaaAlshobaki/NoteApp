package com.walaa.noteapp.feature_note.presentation.note

import com.walaa.noteapp.feature_note.domain.model.Note
import com.walaa.noteapp.feature_note.domain.util.NoteOder

sealed class NotesEvent{
    data class Order(val noteOder: NoteOder):NotesEvent()
    data class DeleteNote(val note: Note):NotesEvent()
    object RestoreNote:NotesEvent()
    object ToggleOrderSection:NotesEvent()


}
