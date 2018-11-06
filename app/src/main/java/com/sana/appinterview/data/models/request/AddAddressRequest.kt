package com.sana.appinterview.data.models.request


import com.google.gson.annotations.SerializedName


data class AddAddressRequest(

    @field:SerializedName("coordinate_phone_number")
    val coordinatePhoneNumber: String? = null,

    @field:SerializedName("address")
    val address: String? = null,

    @field:SerializedName("lng")
    var lng: Double? = null,

    @field:SerializedName("gender")
    val gender: String? = null,

    @field:SerializedName("coordinate_mobile")
    val coordinateMobile: String? = null,

    @field:SerializedName("last_name")
    val lastName: String? = null,

    @field:SerializedName("region")
    val region: Int = 1,

    @field:SerializedName("first_name")
    val firstName: String? = null,

    @field:SerializedName("lat")
    var lat: Double? = null
)