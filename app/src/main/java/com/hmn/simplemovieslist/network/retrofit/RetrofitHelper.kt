package com.hmn.simplemovieslist.network.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {

    companion object{
        inline fun <reified T>getRetrofit():T{
            val gson = GsonBuilder().setLenient().create()
            val okCli = OkHttpClient.Builder()
            val inteceptor = HttpLoggingInterceptor()
            inteceptor.level = HttpLoggingInterceptor.Level.BODY
            okCli.interceptors().add(inteceptor)
            val okclient =okCli.build()

            val ret = Retrofit.Builder().client(okclient)
                .baseUrl("https://newshealthtracker.com/playstore/assets/json/TollywoodVideoSongs/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(T::class.java)
            return ret
        }
    }
}