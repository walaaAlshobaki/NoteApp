package com.walaa.noteapp.feature_note.domain.util

sealed class NoteOder(val orderType: OrderType){
    class Title(orderType: OrderType):NoteOder(orderType)
    class Date(orderType: OrderType):NoteOder(orderType)
    class Color(orderType: OrderType):NoteOder(orderType)


    fun copy(orderType: OrderType):NoteOder{
        return when(this){
            is Title-> Title(orderType)
            is Date-> Date(orderType)
            is Color-> Color(orderType)
        }
    }
}
