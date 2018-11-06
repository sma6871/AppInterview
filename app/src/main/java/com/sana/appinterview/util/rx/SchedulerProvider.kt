package com.sana.appinterview.util.rx

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SchedulerProvider {
    fun io() = Schedulers.io()

    fun ui() = AndroidSchedulers.mainThread()

    fun computation() = Schedulers.computation()
}