package com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.note.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.NoteOder
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.OrderType


@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder:NoteOder=NoteOder.Date(OrderType.Descending),
    onOrderChange:(NoteOder) ->Unit
){


    Column(
        modifier = modifier,

    ) {

        Row(modifier = modifier.fillMaxWidth()) {
            DefaultRadioButton(text = "Title", selected =noteOrder is NoteOder.Title
                , onSelect = { onOrderChange(NoteOder.Title(noteOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(text = "Date", selected =noteOrder is NoteOder.Date
                , onSelect = { onOrderChange(NoteOder.Date(noteOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(text = "Color", selected =noteOrder is NoteOder.Color
                , onSelect = { onOrderChange(NoteOder.Color(noteOrder.orderType)) }
            )

        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = modifier.fillMaxWidth()) {
            DefaultRadioButton(text = "Ascending", selected =noteOrder.orderType is OrderType.Ascending
                , onSelect = { onOrderChange(noteOrder.copy(OrderType.Ascending)) }
            )
            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(text = "Descending", selected =noteOrder.orderType is OrderType.Descending
                , onSelect = { onOrderChange(noteOrder.copy(OrderType.Descending)) }
            )


        }
    }

}