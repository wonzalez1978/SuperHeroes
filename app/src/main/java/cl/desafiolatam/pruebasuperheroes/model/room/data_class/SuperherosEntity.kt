package cl.desafiolatam.pruebasuperheroes.model.room.data_class

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heroes_table")
data class SuperherosEntity(
   /* @Embedded
    val appearance: Appearance,*/
//    @Embedded val connections: Connections,
    @PrimaryKey val id: Int,
    @Embedded val images: Images,
    val name: String,
    @Embedded val powerstats: Powerstats,
    val slug: String,
//    @Embedded val work: Work
)
