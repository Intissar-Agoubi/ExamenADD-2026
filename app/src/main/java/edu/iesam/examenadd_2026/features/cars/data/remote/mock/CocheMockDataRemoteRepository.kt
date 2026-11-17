package edu.iesam.examenadd_2026.features.cars.data.remote.mock

import edu.iesam.examenadd_2026.features.cars.domain.Coche

class CocheMockDataRemoteRepository {
    fun obtain(): List<Coche>{
        return listOf(Coche("mercedes","class A","FFRRTTTDF", Coche.Propietario("XW45525623","Intissar","Agoubii")))
    }
}