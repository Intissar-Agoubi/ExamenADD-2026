package edu.iesam.examenadd_2026.core.cache

import android.content.Context
import android.content.SharedPreferences
import edu.iesam.examenadd_2026.R
import edu.iesam.examenadd_2026.core.time.AppTime

class AppCacheTTL(private val context: Context , private val appTime: AppTime): AppCache {
    val sharedPref: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_cache), Context.MODE_PRIVATE)
    override fun updateTime(key: String) {
            val editor = sharedPref.edit()
            editor.putLong(key,appTime.currentTimeToLong()).apply()
        }



    override fun isExpired(key: String, ttl: Long): Boolean {
        val timeSaved = sharedPref.getLong(key,-1)
        return appTime.currentTimeToLong()-timeSaved >= ttl


    }
}


