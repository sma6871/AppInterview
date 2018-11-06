package com.sana.appinterview.helpers

import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import com.sana.appinterview.R
import com.sana.appinterview.extensions.getString


public fun EditText.validatePhone(textInputLayout: TextInputLayout? = null): Boolean {
    if (text.length != 11 || text.toString().toLongOrNull() == null) {
        textInputLayout?.error = getString(R.string.phone_error)
        requestFocus()
        return false
    }
    textInputLayout?.error = null
    return true
}

public fun EditText.validateEmpty(textInputLayout: TextInputLayout? = null): Boolean {
    if (text.isEmpty()) {
        textInputLayout?.error = getString(R.string.fill_this_field)
        requestFocus()
        return false
    }
    textInputLayout?.error = null
    return true
}

