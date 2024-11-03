package com.solidtype.solidnotes.notes.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.solidtype.solidnotes.ui.theme.BabyBlue
import com.solidtype.solidnotes.ui.theme.LightGreen
import com.solidtype.solidnotes.ui.theme.RedOrange
import com.solidtype.solidnotes.ui.theme.RedPink
import com.solidtype.solidnotes.ui.theme.Violet
@Entity
data class Note(
    val title:String,
    val content: String,
    val timestamp: Long,
    val color: Int,
   @PrimaryKey val id: Int? = null
){
    companion object{
        val noteColors= listOf(RedOrange, LightGreen,
            Violet, BabyBlue, RedPink)
    }
}

class NoteException(message: String): Exception(message)

