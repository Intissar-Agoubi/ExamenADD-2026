package edu.iesam.examenadd_2026.core.cache

interface AppCache {
    fun updateTime(key: String)
    fun isExpired(Key: String,ttl:Long): Boolean

}