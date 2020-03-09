package com.example.tarkovfleas

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

interface TarkovApiService {

    @GET("api.php")
    fun itemCheck(@Query("api_key") api_key: String): Observable<Model.Result>


    companion object {
        fun create(): TarkovApiService {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://tarkov-market.com/")
                .build()

            return retrofit.create(TarkovApiService::class.java)
        }
    }

}