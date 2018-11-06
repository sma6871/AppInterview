package com.sana.appinterview.data.remote

import com.sana.appinterview.data.models.request.AddAddressRequest
import com.sana.appinterview.data.models.response.AddressResponse
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AppInterviewService {

    @POST("address")
    fun addAddress(@Body request: AddAddressRequest): Completable

    @GET("address")
    fun getAddresses(): Single<List<AddressResponse>>


}