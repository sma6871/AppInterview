package com.ir.iseema.ui.base

import androidx.fragment.app.Fragment
import com.sana.appinterview.ui.base.BaseActivity

/**
 * Created by Masoud Ashrafzadeh on 2018/02/08.
 */
open class BaseFragment : Fragment() {

    val baseActivity: BaseActivity
        get() {
            return activity as BaseActivity
        }

    fun showError(message: String) {
        baseActivity.showError(message)
    }

    fun showMessageInfo(message: String) {
        baseActivity.showMessageInfo(message)
    }

    fun showMessageSuccess(message: String) {
        baseActivity.showMessageSuccess(message)
    }

    fun showLoading() {
        baseActivity.showLoading()
    }


    fun hideLoading() {
        baseActivity.hideLoading()
    }


    fun showError(messageId: Int) {
        baseActivity.showError(messageId)
    }

    fun showMessageInfo(messageId: Int) {
        baseActivity.showMessageInfo(messageId)
    }

    fun showMessageSuccess(messageId: Int) {
        baseActivity.showMessageSuccess(messageId)
    }

}