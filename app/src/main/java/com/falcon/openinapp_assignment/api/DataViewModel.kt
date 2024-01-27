package com.falcon.openinapp_assignment.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(private val repository: Repository): ViewModel(){

    val dataLiveData get() = repository.dataLiveData
    fun getData() {
        viewModelScope.launch {
            repository.getData()
        }
    }
}