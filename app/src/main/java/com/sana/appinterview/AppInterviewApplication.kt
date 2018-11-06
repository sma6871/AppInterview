package com.sana.appinterview

import android.app.Application
import com.sana.appinterview.di.appModule
import com.sana.appinterview.di.localModule
import com.sana.appinterview.di.remoteModule
import org.koin.android.ext.android.startKoin
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class AppInterviewApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(remoteModule, localModule, appModule))

        CalligraphyConfig.initDefault(
            CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/iransans.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )
    }
}