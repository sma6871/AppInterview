package com.ir.iseema.extensions

import android.text.SpannableString

/**
 * Created by Masoud Ashrafzadeh on 2018/03/01.
 */


fun String.fixNumberPrefix(): String {

    var result = this
    if (this.startsWith("989"))
        result = this.replaceFirst("989", "09")
    if (this.startsWith("+989"))
        result = this.replaceFirst("+989", "09")
    if (this.startsWith("00989"))
        result = this.replaceFirst("00989", "09")
    return result
}

fun String.bold(query: String) :SpannableString{
    val mySpannedText = SpannableString(this)
    return mySpannedText.bold(query)
}