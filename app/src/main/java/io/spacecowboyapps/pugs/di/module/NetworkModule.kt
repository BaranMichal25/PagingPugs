package io.spacecowboyapps.pugs.di.module

import android.content.Context
import com.google.gson.Gson
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.spacecowboyapps.pugs.data.network.AppClient
import io.spacecowboyapps.pugs.di.ApplicationContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
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
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Provides
    @Reusable
    fun provideAppRestClient(retrofit: Retrofit): AppClient = retrofit.create(AppClient::class.java)

    companion object {
        const val BASE_URL = "https://raw.githubusercontent.com/BaranMichal25/PugComponents/master/api/"
    }
}