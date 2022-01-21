package com.walaa.noteapp.feature_note.data.repository

import com.walaa.noteapp.feature_note.data.data_source.NoteDao
import com.walaa.noteapp.feature_note.domain.model.Note
import com.walaa.noteapp.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    val dao:NoteDao
):NoteRepository {
    override fun getNote(): Flow<List<Note>> {
       return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
       return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
       dao.deleteNote(note)
    }
}