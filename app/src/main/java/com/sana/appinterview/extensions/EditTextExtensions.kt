package com.sana.appinterview.extensions

import android.widget.EditText
import com.sana.appinterview.R


/**
 * Created by Masoud Ashrafzadeh on 2018/02/14.
 */

public fun EditText.getString() = text.toString()

public fun EditText.isNotEmpty(): Boolean {
    if (text.isNullOrEmpty())
        error=context.getString(R.string.fill_this_field)
    return text.isNotEmpty()
}

