package com.superking.parchisi.stary.kxizjsu

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.facebook.applinks.AppLinkData
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.superking.parchisi.stary.nbuvi.Joxkxzij
import com.superking.parchisi.stary.nbuvi.Juxoxizcjxc
import com.superking.parchisi.stary.nbuvi.Bixijcijzxcxcz
import com.superking.parchisi.stary.nbuvi.Noxixcjxc
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class Hoxiizxjs(
    private val fidjidjf: Juxoxizcjxc,
    private val cov: Bixijcijzxcxcz,
    private val sodkdsoaskoadsdj: SharedPreferences,
    val okskdoosd: Application
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            fodokddkfo()
        }
        viewModelScope.launch(Dispatchers.Main) {
            ijcjixjzi()
        }
    }


    private val sdjisdji = MutableLiveData<Joxkxzij>()
    val xicj: LiveData<Joxkxzij>
        get() = sdjisdji


    private val siajdjasi = MutableLiveData<Joxkxzij>()
    val xcjnc: LiveData<Joxkxzij>
        get() = siajdjasi

    private val sdopdslpsd = MutableLiveData<Noxixcjxc>()
    val xicjx: LiveData<Noxixcjxc>
        get() = sdopdslpsd


    private val sdosdok = MutableLiveData<String>()
    val dsijsd: LiveData<String>
        get() = sdosdok

    private val fokgokf = MutableLiveData<String>()
    val xock: LiveData<String>
        get() = fokgokf


    private val sdijs = MutableLiveData<String?>()
    val xkccxzji: LiveData<String?>
        get() = sdijs

    suspend fun ijcjixjzi() {
        siajdjasi.postValue(fidjidjf.oxkcoxck().body())
        eokdkodso()
    }

    fun fodokddkfo() {
        val sdoksodsodk = AdvertisingIdClient(okskdoosd)
        sdoksodsodk.start()
        val ixcjvjicv = sdoksodsodk.info.id.toString()
        sdijs.postValue(ixcjvjicv)
    }


    fun ioggjfjijif(eoks: Context) {
        AppsFlyerLib.getInstance()
            .init("yXpu8aPNepGrHct9jpuCWg", fodkdijdjif, okskdoosd)
        AppsFlyerLib.getInstance().start(eoks)
    }



    private val fodkdijdjif = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val oksdjisdbxch = data?.get("campaign").toString()
            sdosdok.postValue(oksdjisdbxch)
        }

        override fun onConversionDataFail(error: String?) {
        }

        override fun onAppOpenAttribution(data: MutableMap<String, String>?) {

        }

        override fun onAttributionFailure(error: String?) {
        }
    }

    fun vockcvkobk(cont: Context) {
        AppLinkData.fetchDeferredAppLinkData(
            cont
        ) { data: AppLinkData? ->
            data?.let {
                val okxckokoxczji = data.targetUri?.host.toString()
                sodkdsoaskoadsdj.edit().putString("deepSt", okxckokoxczji).apply()
            }
        }
    }


    suspend fun eokdkodso() {
        sdopdslpsd.postValue(cov.getDataDev().body())
    }


}