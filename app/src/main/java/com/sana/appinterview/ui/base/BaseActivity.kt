package com.sana.appinterview.ui.base

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.sana.appinterview.R
import es.dmoral.toasty.Toasty
import timber.log.Timber
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

abstract class BaseActivity : AppCompatActivity() {


    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            finish()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }


    // optional method for implementing inside children for loading content
    open fun showHideLoading(isLoading: Boolean) {

    }

    fun showLoading() {
        showHideLoading(true)
    }

    fun hideLoading() {
        showHideLoading(false)
    }

    fun showError(message: String) {
        Toasty.error(this, message, Toast.LENGTH_LONG, true).show();

    }

    fun showMessageInfo(message: String) {
        Toasty.info(this, message, Toast.LENGTH_LONG, true).show();

    }

    fun showMessageSuccess(message: String) {
        Toasty.success(this, message, Toast.LENGTH_LONG, true).show();

    }

    fun showError(messageId: Int) {
        showError(getString(messageId))
    }

    fun showMessageInfo(messageId: Int) {
        showMessageInfo(getString(messageId))
    }

    fun showMessageSuccess(messageId: Int) {
        showMessageSuccess(getString(messageId))
    }

    companion object {

        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }
}
