package edu.iesam.examenadd_2026.core.time

class AppLocalTime(): AppTime {
    override fun currentTimeToLong(): Long {
       return System.currentTimeMillis()
    }

}