package cl.desafiolatam.pruebasuperheroes.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.desafiolatam.pruebasuperheroes.model.room.data_class.SuperherosEntity

@Dao
interface Dao {
    @Query("SELECT * FROM heroes_table")
   fun getAll(): LiveData<List<SuperherosEntity>>


     @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertHeroe (hero: SuperherosEntity )


}