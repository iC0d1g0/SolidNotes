package com.solidtype.solidnotes.di

import android.app.Application
import androidx.room.Room
import com.solidtype.solidnotes.notes.data.data_source.NoteDao
import com.solidtype.solidnotes.notes.data.data_source.settings.NotesDB
import com.solidtype.solidnotes.notes.data.repository.NoteRepositoryImpl
import com.solidtype.solidnotes.notes.domain.repository.NoteRepository
import com.solidtype.solidnotes.notes.domain.use_case.AddNoteCase
import com.solidtype.solidnotes.notes.domain.use_case.Casos_Usos
import com.solidtype.solidnotes.notes.domain.use_case.DeleteNote
import com.solidtype.solidnotes.notes.domain.use_case.GetNotesById
import com.solidtype.solidnotes.notes.domain.use_case.GetNotesCase
import com.solidtype.solidnotes.notes.domain.use_case.UpdateNotesCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Application) = Room.databaseBuilder(
        context, NotesDB::class.java, NotesDB.DATABASE
    ).build()

    @Singleton
    @Provides
    fun provideNoteRepoInterface(db: NotesDB): NoteRepository = NoteRepositoryImpl(db.notesdb)

    @Singleton
    @Provides
    fun provideCasosDeUso(repo: NoteRepository) = Casos_Usos(
        addNoteCase = AddNoteCase(repo),
        deleteNote = DeleteNote(repo),
        getNotesById = GetNotesById(repo),
        getNotesCase = GetNotesCase(repo),
        updateNotesCase = UpdateNotesCase(repo),
    )

}