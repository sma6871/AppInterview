package com.sana.appinterview.data.models.response


import com.google.gson.annotations.SerializedName


data class AddressResponse(


    @field:SerializedName("first_name")
    val firstName: String? = null,

    @field:SerializedName("last_name")
    val lastName: String? = null,

    @field:SerializedName("coordinate_mobile")
    val coordinateMobile: String? = null,

    @field:SerializedName("address")
    val address: String? = null


)