package com.sana.appinterview.data

import com.sana.appinterview.data.models.request.AddAddressRequest
import com.sana.appinterview.data.models.response.AddressResponse
import com.sana.appinterview.data.remote.AppInterviewService
import com.sana.appinterview.util.SharedPrefsHelper
import com.sana.appinterview.util.rx.SchedulerProvider
import com.sana.appinterview.util.rx.with
import io.reactivex.Completable
import io.reactivex.Single

class DataManager(
    val sharedPrefsHelper: SharedPrefsHelper, val appInterviewService: AppInterviewService,
    val schedulerProvider: SchedulerProvider
) {


    fun addAddress(addressRequest: AddAddressRequest): Completable {
        return appInterviewService.addAddress(addressRequest).with(schedulerProvider)
    }

    fun getAddresses(): Single<List<AddressResponse>> {
        return appInterviewService.getAddresses().with(schedulerProvider)
    }

}