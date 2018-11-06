package com.sana.appinterview.di

import com.sana.appinterview.data.DataManager
import com.sana.appinterview.data.remote.AppInterviewService
import com.sana.appinterview.ui.list.AddressListAdapter
import com.sana.appinterview.ui.list.AddressListPresenter
import com.sana.appinterview.ui.map.MapPresenter
import com.sana.appinterview.util.SharedPrefsHelper
import com.sana.appinterview.util.rx.SchedulerProvider
import org.koin.dsl.module.module

val appModule = module {
    factory { SchedulerProvider() }
    single { DataManager(get() as SharedPrefsHelper, get() as AppInterviewService, get() as SchedulerProvider) }

    factory { MapPresenter(get() as DataManager) }
    factory { AddressListPresenter(get() as DataManager) }

    factory { AddressListAdapter() }
}