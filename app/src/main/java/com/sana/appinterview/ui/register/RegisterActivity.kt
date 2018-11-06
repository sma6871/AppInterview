package com.sana.appinterview.ui.register

import android.content.Intent
import android.os.Bundle
import com.sana.appinterview.R
import com.sana.appinterview.constants.BundleExtraKeys
import com.sana.appinterview.constants.Gender
import com.sana.appinterview.data.models.request.AddAddressRequest
import com.sana.appinterview.extensions.getString
import com.sana.appinterview.extensions.isNotEmpty
import com.sana.appinterview.extensions.toJson
import com.sana.appinterview.helpers.validateEmpty
import com.sana.appinterview.helpers.validatePhone
import com.sana.appinterview.ui.base.BaseActivity
import com.sana.appinterview.ui.map.MapActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity() {

    var gender = Gender.MALE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setToolbar()
        setGenderSwitchListener()
        setButtonListener()
    }

    private fun setToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setButtonListener() {
        btnNext.setOnClickListener {
            if (validateForm()) {
                val intent = Intent(this, MapActivity::class.java)
                val addressRequest = AddAddressRequest(
                    txtPhone.getString(),
                    txtAddress.getString(),
                    null,
                    gender.value,
                    txtMobile.getString(),
                    txtLastName.getString(),
                    1,
                    txtName.getString(),
                    null
                )
                intent.putExtra(BundleExtraKeys.AddressModel, addressRequest.toJson())
                startActivity(intent)
            }
        }
    }

    private fun setGenderSwitchListener() {
        switchGender.setOnSwitchListener { _, tabTitle ->
            gender = if (tabTitle == getString(R.string.male))
                Gender.MALE
            else
                Gender.FEMALE
        }
    }

    private fun validateForm(): Boolean {

        if (txtName.validateEmpty(inputName) &&
            txtLastName.validateEmpty(inputLastName) &&
            txtMobile.validatePhone(inputMobile) &&
            txtPhone.validatePhone(inputPhone) &&
            txtAddress.validateEmpty(inputAddress)
        )
            return true
        return false
    }
}
