package com.sana.appinterview.ui.map

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.gson.Gson
import com.sana.appinterview.extensions.show
import com.sana.appinterview.R
import com.sana.appinterview.constants.BundleExtraKeys
import com.sana.appinterview.data.models.request.AddAddressRequest
import com.sana.appinterview.extensions.visibleGone
import com.sana.appinterview.ui.MainActivity
import com.sana.appinterview.ui.base.BaseActivity
import com.sana.appinterview.ui.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_map.*
import org.koin.android.ext.android.inject
import androidx.core.content.IntentCompat
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK



class MapActivity : BaseActivity(), OnMapReadyCallback, MapView {

    private lateinit var mMap: GoogleMap

    private lateinit var addressRequest: AddAddressRequest

    val presenter: MapPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        presenter.attachView(this)

        setAddress()

        configMap()

        setListener()
    }

    override fun showHideLoading(isLoading: Boolean) {
        super.showHideLoading(isLoading)

        progress.visibleGone(isLoading)
        btnRegister.visibleGone(!isLoading)
    }

    private fun setAddress() {
        addressRequest =
                Gson().fromJson(intent.getStringExtra(BundleExtraKeys.AddressModel), AddAddressRequest::class.java)
    }

    private fun setListener() {
        btnRegister.setOnClickListener {
            val target = mMap.cameraPosition.target
            addressRequest.lat = target.latitude
            addressRequest.lng = target.longitude

            presenter.saveAddress(addressRequest)

        }
    }

    private fun configMap() {
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        btnRegister.show()

        val tehran = LatLng(35.6892, 51.3890)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tehran))
        mMap.moveCamera(CameraUpdateFactory.zoomTo(10F))
    }

    override fun goHome() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
        finish()
    }
    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
