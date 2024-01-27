package com.falcon.openinapp_assignment.utils

import android.content.Context
import com.falcon.openinapp_assignment.utils.Constants.SHARED_PREF
import com.falcon.openinapp_assignment.utils.Constants.USER_TOKEN
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TokenManager @Inject constructor (@ApplicationContext context: Context) {
    private val prefs = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)

    fun saveToken() {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjU5MjcsImlhdCI6MTY3NDU1MDQ1MH0.dCkW0ox8tbjJA2GgUx2UEwNlbTZ7Rr38PVFJevYcXFI")
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