package com.solidtype.solidnotes.notes.domain.util

sealed class OrderType {

    object Ascending:OrderType()
    object Descending:OrderType()


}