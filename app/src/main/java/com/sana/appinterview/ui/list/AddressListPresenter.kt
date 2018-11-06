package com.sana.appinterview.ui.list

import android.os.Handler
import com.sana.appinterview.R
import com.sana.appinterview.data.DataManager
import com.sana.appinterview.data.models.request.AddAddressRequest
import com.sana.appinterview.ui.base.BasePresenter

class AddressListPresenter(val dataManager: DataManager) : BasePresenter<AddressListView>() {

    fun getAddresses() {

        mvpView.showLoading()
        compositeDisposable.add(
            dataManager.getAddresses()
                .subscribe(
                    {
                        mvpView.showList(it)
                    },
                    {
                        mvpView.showError(it.localizedMessage)
                    }
                )
        )
    }


}