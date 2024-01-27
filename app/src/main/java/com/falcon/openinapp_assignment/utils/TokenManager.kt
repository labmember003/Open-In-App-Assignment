package com.falcon.openinapp_assignment.utils

import android.content.Context
import com.falcon.openinapp_assignment.utils.Constants.SHARED_PREF
import com.falcon.openinapp_assignment.utils.Constants.USER_TOKEN
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TokenManager @Inject constructor (@ApplicationContext context: Context) {
    private val prefs = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
    fun saveToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun getToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }

    fun deleteToken() {
        val editor = prefs.edit()
        editor.remove(USER_TOKEN)
        editor.apply()
    }
}