package com.sana.appinterview.ui

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import com.sana.appinterview.R
import com.sana.appinterview.ui.base.BaseActivity
import com.sana.appinterview.ui.list.AddressListActivity
import com.sana.appinterview.ui.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        btnAddNew.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        btnAllAddresses.setOnClickListener {
            startActivity(Intent(this, AddressListActivity::class.java))
        }
    }
}
