package com.solidtype.solidnotes.notes.domain.util

import javax.inject.Inject

sealed class NoteOrder (val orderType: OrderType) {

    class Title (orderType: OrderType):NoteOrder(orderType)
    class Date (orderType: OrderType):NoteOrder(orderType)
    class Color (orderType: OrderType):NoteOrder(orderType)

    fun copy(orderType: OrderType) = when(this){
        is Title -> Title(orderType)
        is Date -> Date(orderType)
        is Color -> Color(orderType)
    }

}
