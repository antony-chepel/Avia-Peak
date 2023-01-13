package com.superking.parchisi.stary

import android.app.Application
import android.content.Context
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import com.superking.parchisi.stary.nbuvi.ijxicj
import com.superking.parchisi.stary.nbuvi.oxkzkoxz
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level
import java.util.*

class Grsixijzc: Application() {

    companion object {
        var tiookdfo: String? = "instID"
        val vockbokcv: String = "myID"
        var dijsajijidas: String? = "main_id"
        const val idjsjsd = "4e175a17-2a17-4194-9577-d76e7f2d93f4"

    }

    override fun onCreate() {
        super.onCreate()
        OneSignal.initWithContext(this)
        OneSignal.setAppId(idjsjsd)




        val bovkvb = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val woksod = getSharedPreferences("PREFS_NAME", 0)

        val jcxicjcv = MyTracker.getTrackerParams()
        val qoqisjdjisjnxnc = MyTracker.getTrackerConfig()
        val biovkvbo = MyTracker.getInstanceId(this)
        qoqisjdjisjnxnc.isTrackingLaunchEnabled = true
        val IDIN = UUID.randomUUID().toString()

        if (woksod.getBoolean("my_first_time", true)) {
            jcxicjcv.setCustomUserId(IDIN)
            bovkvb.edit().putString(vockbokcv, IDIN).apply()
            bovkvb.edit().putString(tiookdfo, biovkvbo).apply()
            woksod.edit().putBoolean("my_first_time", false).apply()
        } else {
            val shIDIN = bovkvb.getString(vockbokcv, IDIN)
            jcxicjcv.setCustomUserId(shIDIN)
        }
        MyTracker.initTracker("81790531130368530582", this)

        GlobalContext.startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@Grsixijzc)
            modules(
                listOf(
                    oxkzkoxz, ijxicj
                )
            )
        }
    }
}