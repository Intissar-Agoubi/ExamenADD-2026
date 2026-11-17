package edu.iesam.examenadd_2026.core.serialization

interface JsonSerialiser<T> {
    fun toJson(obj: T): String
    fun fromJson(json: String):T
}