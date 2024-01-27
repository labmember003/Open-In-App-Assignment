package com.falcon.openinapp_assignment.api

import com.falcon.openinapp_assignment.api.dataclasses.Data
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("dashboardNew")
    suspend fun getDashboardData(): Response<Data>
}
