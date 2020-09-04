package cl.desafiolatam.pruebasuperheroes.model.room

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.desafiolatam.pruebasuperheroes.model.room.data_class.SuperherosEntity

//implementación de Room como una clase abstracta heredando desde RoomDatabase y los métodos
//correspondientes para inicializar un Singleton o instancia única en la base de datos.

@Database(entities = [SuperherosEntity::class], version = 1)

public abstract class HeroesDatabase : RoomDatabase(){

    abstract fun dao() : Dao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: HeroesDatabase? = null
//ESTA FUNSION CREA UNA INSTANCIA QUE CREA LA CONEXION A LA BASE DE DATOS, SINGLETON DE INSTANCIA UNICA
        fun getDatabase(context: Context): HeroesDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HeroesDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
    //archivo de Kotlin que será el punto de partida de nuestra aplicación,
    //en él se iniciará la Base de datos.
    class MisHeroesApp: Application() {

        companion object {
            lateinit var database: HeroesDatabase
        }

        override fun onCreate() {
            super.onCreate()
            MisHeroesApp.database =  Room.databaseBuilder(this, HeroesDatabase::class.java, "tasks-db").build()
        }
    }
}