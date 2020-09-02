package cl.desafiolatam.pruebasuperheroes.model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "heroes_entity")

data class HeroesEntity(@PrimaryKey(autoGenerate = true)
                        var id : Int = 0,
                        @ColumnInfo(name = "Nombre") var name : String
)