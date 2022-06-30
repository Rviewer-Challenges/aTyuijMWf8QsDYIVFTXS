package com.molidev8.molirss.data

import android.content.Context

private const val PREFS_KEY = "MOLIRRSS_PREFS"
private const val DARK_ENABLED = "DARK_ENABLED"

class Preferences(context: Context) {

    private val prefs = context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)

    fun setDarkModeEnabled() {
        prefs.edit().putBoolean(DARK_ENABLED, true).apply()
    }

    fun isDarkModeEnabled() = prefs.getBoolean(DARK_ENABLED, false)
}