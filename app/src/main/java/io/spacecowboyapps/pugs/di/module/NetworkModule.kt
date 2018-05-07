package io.spacecowboyapps.pugs.di.module

import android.content.Context
import com.google.gson.Gson
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.spacecowboyapps.pugs.di.ApplicationContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    @Reusable
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient()

    @Provides
    @Reusable
    fun provideGson(): Gson = Gson()

    @Provides
    @Reusable
    fun providePicasso(@ApplicationContext context: Context, httpClient: OkHttpClient): Picasso =
        Picasso.Builder(context)
            .downloader(OkHttp3Downloader(httpClient))
            .build()
            .apply { Picasso.setSingletonInstance(this) }

    @Provides
    @Reusable
    fun provideRetrofit(gson: Gson, httpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("")    // TODO
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
}