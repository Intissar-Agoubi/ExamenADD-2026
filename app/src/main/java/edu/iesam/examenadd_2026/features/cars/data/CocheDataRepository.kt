package edu.iesam.examenadd_2026.features.cars.data

import edu.iesam.examenadd_2026.features.cars.data.local.xml.CocheLocalDataSourcXml
import edu.iesam.examenadd_2026.features.cars.data.remote.mock.CocheMockDataRemoteRepository
import edu.iesam.examenadd_2026.features.cars.domain.Coche
import edu.iesam.examenadd_2026.features.cars.domain.CocheRepository

class CocheDataRepository(private val cocheMockDataRemoteRepository: CocheMockDataRemoteRepository, private val cocheLocalDataSourcXml: CocheLocalDataSourcXml) : CocheRepository{
    override fun getAll(): List<Coche> {
        return cocheLocalDataSourcXml.findAll()
    }

    override fun update(coche: Coche) {
        cocheLocalDataSourcXml.saveAll(cocheMockDataRemoteRepository.obtain())
       // cocheLocalDataSourcXml.saveAll()
    }
}