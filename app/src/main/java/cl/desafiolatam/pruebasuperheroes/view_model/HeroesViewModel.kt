package cl.desafiolatam.pruebasuperheroes.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cl.desafiolatam.pruebasuperheroes.model.room.HeroesDatabase
import cl.desafiolatam.pruebasuperheroes.model.room.Repository
import cl.desafiolatam.pruebasuperheroes.model.room.data_class.SuperherosEntity

// Class extends AndroidViewModel and requires application as a parameter.
//Esta clase se encargara de pasar la data a la vista y sobrevivir a cualquier cambio de configuración
class HeroesViewModel(application: Application) : AndroidViewModel(application){
    // The ViewModel maintains a reference to the repository to get data.
    val selected = MutableLiveData<SuperherosEntity>()
    fun select(heroe: SuperherosEntity){
        selected.value = heroe

    }
    //variable privada que referencia el repositorio, inicializamos repository
    private val repository : Repository = Repository(application)
    // LiveData gives us updated AllcheckItem when they change.
    //variable de LiveData para mantener un caché del listado de Ítems de la cuenta.

    val getAll : LiveData<List<SuperherosEntity>> = repository.getAll

    // Gets reference to Dao from RoomDatabase to construct the correct Repository.
    val respuesta = repository.loadApi()

}
