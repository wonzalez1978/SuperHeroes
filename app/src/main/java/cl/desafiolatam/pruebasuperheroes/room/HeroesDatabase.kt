package cl.desafiolatam.pruebasuperheroes.room

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HeroesEntity::class], version = 1)
public abstract class HeroesDatabase : RoomDatabase(){

    abstract fun usersDao() : Dao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: HeroesDatabase? = null

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
    //
    /*class MisHeroesApp: Application() {

        companion object {
            lateinit var database: HeroesDatabase
        }

        override fun onCreate() {
            super.onCreate()
            MisHeroesApp.database =  Room.databaseBuilder(this, HeroesDatabase::class.java, "tasks-db").build()
        }
    }*/
}