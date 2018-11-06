package com.sana.appinterview.di

import android.content.Context
import android.content.SharedPreferences
import com.sana.appinterview.constants.ApplicationConstants
import com.sana.appinterview.util.SharedPrefsHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val localModule = module {

    factory { androidContext().getSharedPreferences(ApplicationConstants.SHARED_PREFS_NAME, Context.MODE_PRIVATE) }
    factory { SharedPrefsHelper(get() as SharedPreferences) }
}
