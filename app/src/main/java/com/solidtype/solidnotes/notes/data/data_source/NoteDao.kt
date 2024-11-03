package com.solidtype.solidnotes.notes.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.solidtype.solidnotes.notes.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM Note")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM Note WHERE title LIKE :search " +
    "OR content LIKE :search")
    fun search(search:String):Flow<List<Note>>

    @Query("SELECT * FROM Note WHERE id = :id")
    suspend fun getNoteById(id:Int):Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(notes:Note)

    @Delete
    suspend fun deleteNote(note:Note)

    @Update
    suspend fun updateNote(note:Note)

}