package edu.iesam.examenadd_2026.features.cars.domain

interface CocheRepository {
    fun getAll(): List<Coche>
    fun update(coche: Coche)
}