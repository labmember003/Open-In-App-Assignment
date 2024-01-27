package com.falcon.openinapp_assignment.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.falcon.openinapp_assignment.api.dataclasses.Data
import org.json.JSONObject
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {

    private val _dataLiveData = MutableLiveData<NetworkResult<Data>>()
    val dataLiveData : LiveData<NetworkResult<Data>>
        get() = _dataLiveData

    suspend fun getData() {
        _dataLiveData.postValue(NetworkResult.Loading())
        val response = apiService.getDashboardData()
        if (response.isSuccessful && response.body() != null) {
            _dataLiveData.postValue(NetworkResult.Success(response.body()!!))
        } else if (response.errorBody() != null) {
            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
            _dataLiveData.postValue(NetworkResult.Error(errorObj.getString("message")))
        } else {
            _dataLiveData.postValue(NetworkResult.Error("Something Went Wrong"))
        }
    }
}