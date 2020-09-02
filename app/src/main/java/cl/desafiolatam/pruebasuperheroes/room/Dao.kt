package cl.desafiolatam.pruebasuperheroes.room

import androidx.room.Dao
import androidx.room.Query
@Dao
interface Dao {
    @Query("SELECT * FROM heroes_entity")
    suspend fun getAll(): List<HeroesEntity>


}