package com.jarvis.forecast.net


import com.jarvis.forecast.util.LiveDataCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppClient {

    val mRetrofit: Retrofit by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {

        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(logInterceptor)
            .build()

        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.weather.gov/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
    }

}

