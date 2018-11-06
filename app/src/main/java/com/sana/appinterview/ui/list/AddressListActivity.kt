package com.sana.appinterview.ui.list

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sana.appinterview.R
import com.sana.appinterview.data.models.response.AddressResponse
import com.sana.appinterview.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_list.*
import org.koin.android.ext.android.inject

class AddressListActivity : BaseActivity(), AddressListView {

    val presenter: AddressListPresenter by inject()
    val adapter: AddressListAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        presenter.attachView(this)

        presenter.getAddresses()
    }

    override fun showList(list: List<AddressResponse>) {
        adapter.addItems(list)
        addressList.layoutManager = LinearLayoutManager(this)
        addressList.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

}
