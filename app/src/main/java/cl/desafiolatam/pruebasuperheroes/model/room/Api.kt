package cl.desafiolatam.pruebasuperheroes.model.room

import android.widget.ImageView
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("superhero-api@0.3.0/api/all")
    fun listaHeroes(): Call<HeroesEntity?>?

    @GET("superhero-api/api/#images-1")
    fun listaImagenes(@Path("images") imageView: ImageView?): Call<HeroesEntity?>?
}