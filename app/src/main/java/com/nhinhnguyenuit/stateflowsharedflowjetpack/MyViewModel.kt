package com.nhinhnguyenuit.stateflowsharedflowjetpack

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    //state flow to manage state
    private val _textState = MutableStateFlow<String>("initial text")
    val textState: StateFlow<String> = _textState

    //sharedflow to emit events
    private val _events = MutableSharedFlow<String>()
    val events: SharedFlow<String> = _events

    //update new status of text
    fun updateText(newValue: String) {
        _textState.value = newValue
    }

    //emit an events
    fun sentEvent(event: String) {
        viewModelScope.launch {
            _events.emit(event)
        }
    }
}

data class Nhinh(var tet: String)