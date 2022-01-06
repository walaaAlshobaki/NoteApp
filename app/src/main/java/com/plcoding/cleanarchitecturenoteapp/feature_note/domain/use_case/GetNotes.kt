package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case

import androidx.compose.ui.text.toLowerCase
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.NoteOder
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(
    private val repository: NoteRepository
) {
    operator  fun invoke(
        noteOder: NoteOder=NoteOder.Date(OrderType.Descending)
    ): Flow<List<Note>>{
        return repository.getNote().map {
            notes->
            when(noteOder.orderType){
                is OrderType.Ascending->{
                    when(noteOder){
                        is NoteOder.Title->notes.sortedBy { it.title.toLowerCase() }
                        is NoteOder.Date->notes.sortedBy { it.timeStamp }
                        is NoteOder.Color->notes.sortedBy { it.color}
                    }
                }
                is OrderType.Descending->{
                    when(noteOder){
                        is NoteOder.Title->notes.sortedByDescending { it.title.toLowerCase() }
                        is NoteOder.Date->notes.sortedByDescending { it.timeStamp }
                        is NoteOder.Color->notes.sortedByDescending { it.color}
                    }
                }
            }
        }
    }
}