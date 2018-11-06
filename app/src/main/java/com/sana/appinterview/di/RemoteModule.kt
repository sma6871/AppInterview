package com.sana.appinterview.di

import com.sana.appinterview.data.remote.AppInterviewService
import com.google.gson.Gson
import com.sana.appinterview.constants.ApplicationConstants
import com.sana.appinterview.data.remote.BasicAuthInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Remote Web Service datasource
 */
val remoteModule = module(createOnStart = true) {
    // provided web components
    single { createOkHttpClient() }


    single { Gson() }

    single { GsonConverterFactory.create(get()) }

    single { createWebService<AppInterviewService>(get() as OkHttpClient, get() as GsonConverterFactory) }


}


fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(BasicAuthInterceptor(ApplicationConstants.Username, ApplicationConstants.Password))
        .build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(ApplicationConstants.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
    return retrofit.create(T::class.java)
}

