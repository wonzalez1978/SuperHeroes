package cl.desafiolatam.pruebasuperheroes.model.room

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    private var retrofit: Retrofit? = null
    private val BASE_URL = "https://cdn.jsdelivr.net/gh/akabab/"

    fun getRetrofitInstance(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}