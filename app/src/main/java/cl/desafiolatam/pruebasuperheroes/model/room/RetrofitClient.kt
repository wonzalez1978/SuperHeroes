package cl.desafiolatam.pruebasuperheroes.model.room

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient {
    companion object {

        private val BASE_URL = "https://cdn.jsdelivr.net/gh/akabab/"
        //generando el objeto de tipo Retrofit que voy a usar como Apiheroes
        fun getRetrofitInstance(): ApiHeroes {

                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit.create(ApiHeroes::class.java)
        }

    }
}