package com.superking.parchisi.stary.nvucids

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.appsflyer.AppsFlyerLib
import com.my.tracker.MyTracker
import com.superking.parchisi.stary.Grsixijzc.Companion.dijsajijidas
import com.superking.parchisi.stary.Grsixijzc.Companion.tiookdfo
import com.superking.parchisi.stary.R
import com.superking.parchisi.stary.kxizjsu.AviaWebAct
import com.superking.parchisi.stary.nbuvi.Fdeoicoxi
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named


class FilterAvia : Fragment() {
    val kosdkosdkokosda: SharedPreferences by inject(named("SharedPreferences"))
    private lateinit var ixcijzxc: Context


    override fun onAttach(context: Context) {
        super.onAttach(context)
        ixcijzxc = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.forkoe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val osdksdko = Intent(activity, Fdeoicoxi::class.java)
        val vocvcbjibv = "deviceID="
        val kxicokxz = "sub_id_6="
        val wiosdj = "sub_id_5="
        val gijf = "naming"
        val eoksdko = "deeporg"
        val wiojsdi = "com.superking.parchisi.stary"
        val icxvjvxc = Build.VERSION.RELEASE
        val sdsdjisdi = "sub_id_1="
        val oxckxckzoxc = "ad_id="
        val ijcxjiz = Intent(activity, AviaWebAct::class.java)
        val icvjvjijivc = "sub_id_4="

        val xcijvvic = kosdkosdkokosda.getString("country", null)

        val oasdsdajiasd = kosdkosdkokosda.getString("appCamp", null)
        val sdkosdisdji = kosdkosdkokosda.getString(tiookdfo, null)
        val ixjjicx = MyTracker.getTrackerParams()
        ixjjicx.setCustomUserId(sdkosdisdji)
        val xopckkoczkozxc = kosdkosdkokosda.getString("wv", null)
        val ibjbvjinjibjivb = kosdkosdkokosda.getString("mainId", null)
        val dosdksdjf = kosdkosdkokosda.getString("deepSt", null)
        val osdasdksd = kosdkosdkokosda.getString("countryDev", null)
        val apvocjicjics = kosdkosdkokosda.getString("apps", null)

        val vockcov = AppsFlyerLib.getInstance().getAppsFlyerUID(ixcijzxc)
        AppsFlyerLib.getInstance().setCollectAndroidID(true)

        kosdkosdkokosda.edit().putString(dijsajijidas, vockcov).apply()

        val sijd = "$xopckkoczkozxc$sdsdjisdi$oasdsdajiasd&$vocvcbjibv$vockcov&$oxckxckzoxc$ibjbvjinjibjivb&$icvjvjijivc$wiojsdi&$wiosdj$icxvjvxc&$kxicokxz$gijf"
        val icjv = "$xopckkoczkozxc$vocvcbjibv$sdkosdisdji&$oxckxckzoxc$sdkosdisdji&$icvjvjijivc$wiojsdi&$wiosdj$icxvjvxc&$kxicokxz$gijf"
        val woksd = "$xopckkoczkozxc$sdsdjisdi$dosdksdjf&$vocvcbjibv$vockcov&$oxckxckzoxc$ibjbvjinjibjivb&$icvjvjijivc$wiojsdi&$wiosdj$icxvjvxc&$kxicokxz$eoksdko"
        val xioczxokzxckzxc = "$xopckkoczkozxc$sdsdjisdi$dosdksdjf&$vocvcbjibv$sdkosdisdji&$oxckxckzoxc$sdkosdisdji&$icvjvjijivc$wiojsdi&$wiosdj$icxvjvxc&$kxicokxz$eoksdko"

        when(apvocjicjics) {
            "1" ->
                if(oasdsdajiasd!!.contains("tdb2")) {
                    kosdkosdkokosda.edit().putString("link", sijd).apply()
                    kosdkosdkokosda.edit().putString("WebInt", "campaign").apply()
                    startActivity(ijcxjiz)
                    activity?.finish()
                } else if (dosdksdjf!=null||osdasdksd!!.contains(xcijvvic.toString())) {

                    kosdkosdkokosda.edit().putString("link", woksd).apply()
                    kosdkosdkokosda.edit().putString("WebInt", "deepLink").apply()
                    startActivity(ijcxjiz)
                    activity?.finish()
                } else {
                    startActivity(osdksdko)
                    activity?.finish()
                }
            "0" ->
                if(dosdksdjf!=null) {
                    kosdkosdkokosda.edit().putString("link", xioczxokzxckzxc).apply()
                    kosdkosdkokosda.edit().putString("WebInt", "deepLinkNOApps").apply()
                    startActivity(ijcxjiz)
                    activity?.finish()
                } else if (osdasdksd!!.contains(xcijvvic.toString())) {
                    Log.d("WebTesting", icjv)
                    kosdkosdkokosda.edit().putString("link", icjv).apply()
                    kosdkosdkokosda.edit().putString("WebInt", "geo").apply()
                    startActivity(ijcxjiz)
                    activity?.finish()
                } else {
                    startActivity(osdksdko)
                    activity?.finish()
                }
        }
    }
}
