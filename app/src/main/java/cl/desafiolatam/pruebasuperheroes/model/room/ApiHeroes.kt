package cl.desafiolatam.pruebasuperheroes.model.room

import cl.desafiolatam.pruebasuperheroes.model.room.data_class.SuperherosEntity
import retrofit2.Call
import retrofit2.http.GET

interface ApiHeroes {
    @GET("superhero-api@0.3.0/api/all.json")
    fun listaHeroes(): Call<ArrayList<SuperherosEntity>>


}