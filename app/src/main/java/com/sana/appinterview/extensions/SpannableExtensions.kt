package com.ir.iseema.extensions

import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan

fun SpannableString.bold(target: String):SpannableString{

     this.spanWith(target){
        what = StyleSpan(Typeface.BOLD)
        flags = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    }
    return this
}

fun SpannableString.underline(target: String){

    this.spanWith(target){
        what = UnderlineSpan()
        flags = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    }
}

fun SpannableString.spanWith(target: String, apply: SpannableBuilder.() -> Unit) {
    val builder = SpannableBuilder()
    apply(builder)

    val start = this.lastIndexOf(target)
    val end =  start + target.length

    setSpan(builder.what, start, end, builder.flags)
}

class SpannableBuilder {
    lateinit var what: Any
    var flags: Int = 0
}