package com.bhavesh.xetaanalyticsassignment.view_model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhavesh.xetaanalyticsassignment.remote.dto.FoodApiDto
import com.bhavesh.xetaanalyticsassignment.repository.Repository
import kotlinx.coroutines.launch

class XetaViewModel: ViewModel() {
    private val repository = Repository()
    var foodApiDto = mutableStateOf<FoodApiDto?>(null)
    var errorMessage = mutableStateOf<String?>(null)

    fun getFoodApiDto(){
        viewModelScope.launch {
            repository.getFoodApiDto { data ->
                foodApiDto.value = data
                if(data == null){
                    errorMessage.value = "Failed to fetch messages."
                }
            }
        }
    }
}