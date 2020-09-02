package cl.desafiolatam.pruebasuperheroes.model.room

import androidx.lifecycle.LiveData
import java.io.DataOutput

// Declares the DAO as a private property in the constructor. Pass in the Dao
// instead of the whole database, because you only need access to the Dao
// Room executes all queries on a separate thread.
// Observed LiveData will notify the observer when the data has changed.

class Repository(private val dao: Dao) {

        val allCheckItems: List<HeroesEntity> = dao.getAll()

    /*Estamos pasando el objeto Dao a nuestra clase repositorio. De esta forma solo
    accederemos a los métodos que escriben o leen la base de datos, sin tener que exponer la
    base de datos completa al repositorio.
    El listado de elementos viene inicializado al obtener el objeto LiveData que proviene desde
    Room, más específicamente del método getAllCheckItems. Room ejecutará esta petición en
    un hilo diferente al de UI y nos traerá los datos que han cambiado al main Thread.*/





}