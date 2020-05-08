package com.example.myapplication.session

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor


class Session(var context: Context) {
    var prefs: SharedPreferences
    var editor: Editor
    fun setLoggedIn(loggedIn: Boolean) {
        editor.putBoolean(loggedInMode, loggedIn)
        editor.commit()
    }

    fun loggedIn(): Boolean {
        return prefs.getBoolean(loggedInMode, false)
    }

    companion object {
        const val loggedInMode = "loggedInMode"
    }

    init {
        prefs = context.getSharedPreferences("myapp", Context.MODE_PRIVATE)
        editor = prefs.edit()
    }
}
