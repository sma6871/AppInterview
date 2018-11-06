package com.sana.appinterview.ui.list

import com.sana.appinterview.data.models.response.AddressResponse
import com.sana.appinterview.ui.base.MvpView

interface AddressListView : MvpView {
    fun showList(list: List<AddressResponse>)
}