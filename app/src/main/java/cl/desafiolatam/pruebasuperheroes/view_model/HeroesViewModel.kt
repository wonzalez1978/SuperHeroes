package cl.desafiolatam.pruebasuperheroes.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.RoomDatabase
import cl.desafiolatam.pruebasuperheroes.model.room.Dao
import cl.desafiolatam.pruebasuperheroes.model.room.HeroesDatabase
import cl.desafiolatam.pruebasuperheroes.model.room.HeroesEntity
import cl.desafiolatam.pruebasuperheroes.model.room.Repository

// Class extends AndroidViewModel and requires application as a parameter.
class HeroesViewModel(application: Application) : AndroidViewModel(application){
    // The ViewModel maintains a reference to the repository to get data.
    private val repository: Repository = TODO()
    // LiveData gives us updated AllcheckItem when they change.
    val allCheckItems : LiveData<List<HeroesEntity>>
    // Gets reference to Dao from RoomDatabase to construct the correct CheckRepository.
    init {
        val dao = HeroesDatabase.getDatabase(application).dao()
        repository = Repository(dao)
       // allCheckItems = repository.allCheckItems
    }


}


    //Create a LiveData with a String??
    val currentName: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
// Rest of the ViewModel...
