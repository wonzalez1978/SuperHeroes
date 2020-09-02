package cl.desafiolatam.pruebasuperheroes.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import cl.desafiolatam.pruebasuperheroes.data_class.Images

@Entity (tableName = "heroes_entity")

data class HeroesEntity(@PrimaryKey(autoGenerate = true)
                        var id : Int = 0,
                        @ColumnInfo(name = "Nombre") var name : String
)