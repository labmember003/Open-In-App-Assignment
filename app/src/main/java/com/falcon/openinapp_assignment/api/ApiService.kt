package com.falcon.openinapp_assignment.api

import Data
import retrofit2.http.GET

interface ApiService {
    @GET("dashboardNew")
    suspend fun getDashboardData(): Data
}
