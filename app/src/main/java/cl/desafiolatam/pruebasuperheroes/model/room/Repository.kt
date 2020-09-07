package cl.desafiolatam.pruebasuperheroes.model.room

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import cl.desafiolatam.pruebasuperheroes.model.room.data_class.Images
import cl.desafiolatam.pruebasuperheroes.model.room.data_class.SuperherosEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// Declares the DAO as a private property in the constructor. Pass in the Dao
// instead of the whole database, because you only need access to the Dao
// Room executes all queries on a separate thread.
// Observed LiveData will notify the observer when the data has changed.

class Repository(context: Context) {
    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed
    var heroesDao: Dao = HeroesDatabase.getDatabase(context).dao()
    val getAll: LiveData<List<SuperherosEntity>> = heroesDao.getAll()
    private var lista_heroes = ArrayList<SuperherosEntity>()




    /*Estamos pasando el objeto Dao a nuestra clase repositorio. De esta forma solo
    accederemos a los métodos que escriben o leen la base de datos, sin tener que exponer la
    base de datos completa al repositorio.
    El listado de elementos viene inicializado al obtener el objeto LiveData que proviene desde
    Room, más específicamente del método getAll. Room ejecutará esta petición en
    un hilo diferente al de UI y nos traerá los datos que han cambiado al main Thread.*/

    fun loadApi() {
        //crear servicio (crear el objeto RetrofitClient)
        val service = RetrofitClient.getRetrofitInstance()
        //hacer la llamada qe esta en ApiHeroes
        val call = service.listaHeroes()
        call.enqueue(object : Callback<ArrayList<SuperherosEntity>> {
                override fun onResponse(
                        call: Call<ArrayList<SuperherosEntity>>,
                        response: Response<ArrayList<SuperherosEntity>>
                ) {
                        saveHero(response.body()!!)
                        Log.d("Main", "${response.body()}")
                        Log.d("Main", "${response.raw().request().url()}")
                        //response.body()?.let { heroesAdapter.updateAdapter(it) }
                }

                override fun onFailure(call: Call<ArrayList<SuperherosEntity>>, t: Throwable) {
                        Log.d("Main", "falló")
                }

        })
    }

    fun saveHero(listaHero: ArrayList<SuperherosEntity>) {
        listaHero.map {
            lista_heroes.add(SuperherosEntity(it.id, it.images, it.name, it.powerstats, it.slug))

        }
        //corrutina
        //pasamos el heroe a la base de datos
        CoroutineScope(Dispatchers.IO).launch {
            for(heroe in lista_heroes){
                heroesDao.insertHeroe(heroe)
            }
        }


    }

}