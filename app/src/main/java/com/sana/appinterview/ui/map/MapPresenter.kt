package com.sana.appinterview.ui.map

import android.os.Handler
import com.sana.appinterview.R
import com.sana.appinterview.data.DataManager
import com.sana.appinterview.data.models.request.AddAddressRequest
import com.sana.appinterview.ui.base.BasePresenter

class MapPresenter(val dataManager: DataManager) : BasePresenter<MapView>() {

    fun saveAddress(addressRequest: AddAddressRequest) {

        mvpView.showLoading()
        compositeDisposable.add(
            dataManager.addAddress(addressRequest)
                .doOnTerminate { mvpView.hideLoading() }
                .subscribe(
                    {
                        mvpView.showMessageInfo(R.string.address_added_success)
                        mvpView.goHome()
                    },
                    {
                        mvpView.showError(it.localizedMessage)
                    }
                )
        )
    }


}