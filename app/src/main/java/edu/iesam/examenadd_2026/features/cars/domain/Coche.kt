package edu.iesam.examenadd_2026.features.cars.domain

data class Coche(val marca: String , val modelo : String, val matricula: String, val propietario: Propietario) {
    data class Propietario(val dni: String , val nombre: String , val apellido: String)
}