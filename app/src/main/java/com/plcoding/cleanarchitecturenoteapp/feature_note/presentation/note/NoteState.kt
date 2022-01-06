package com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.note

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.NoteOder
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.OrderType

data class NoteState(
    val notes:List<Note> = emptyList(),
    val noteOder: NoteOder=NoteOder.Date(OrderType.Descending),
    val isOrderSectionVisible:Boolean=false
)
