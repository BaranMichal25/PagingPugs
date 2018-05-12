package io.spacecowboyapps.pugs.data.network

import io.reactivex.Single
import io.spacecowboyapps.pugs.data.db.Pug
import retrofit2.http.GET

interface AppClient{

    @GET("pugs")
    fun getPugs(): Single<List<Pug>>
}