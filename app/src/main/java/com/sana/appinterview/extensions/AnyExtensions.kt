package com.sana.appinterview.extensions

import com.google.gson.Gson

/**
 * Created by Masoud Ashrafzadeh on 2018/07/09.
 */
public fun Any.toJson(): String {
    return Gson().toJson(this)
}