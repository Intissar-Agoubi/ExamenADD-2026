package edu.iesam.examenadd_2026.features.cars.domain

class GetCocheUseCase(private val cocheRepository: CocheRepository) {
    operator fun invoke(): List<Coche>{
        return cocheRepository.getAll()
    }
}