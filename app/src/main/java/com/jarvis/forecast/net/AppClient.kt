package com.jarvis.forecast.net


import com.jarvis.forecast.BuildConfig
import com.jarvis.forecast.util.LiveDataCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object AppClient {

    val mRetrofit: Retrofit by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {

        val logInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            logInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            logInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }

        val okHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(logInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)//Api is too slow to extend request time
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()

        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.weather.gov/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
    }

}

