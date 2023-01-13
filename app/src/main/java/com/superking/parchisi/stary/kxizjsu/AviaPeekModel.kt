package com.superking.parchisi.stary.kxizjsu

import android.app.Application
import android.content.pm.PackageManager
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.lifecycle.ViewModel
import com.onesignal.OneSignal
import org.json.JSONException
import org.json.JSONObject

class AviaPeekModel(application: Application): ViewModel() {

    val novcijcv = application.packageManager



    fun oieijdkofkdo(civj: String): Boolean {
        try {
            novcijcv.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)
            return true
        } catch (_: PackageManager.NameNotFoundException) {

        }
        return false
    }

    fun fovijc(zoxk: String) {
        OneSignal.setExternalUserId(
            zoxk,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(ockvijvc: JSONObject) {
                    try {
                        if (ockvijvc.has("push") && ockvijvc.getJSONObject("push").has("success")) {
                            val ockvijxcvji = ockvijvc.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $ockvijxcvji"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (ockvijvc.has("email") && ockvijvc.getJSONObject("email").has("success")) {
                            val dijfisdfj =
                                ockvijvc.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $dijfisdfj"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (ockvijvc.has("sms") && ockvijvc.getJSONObject("sms").has("success")) {
                            val ixjcjicx = ockvijvc.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $ixjcjicx"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: OneSignal.ExternalIdError) {
                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }


    fun docicxcxhcxu(dijfdji: WebView): WebSettings{
        val coxvicjx = dijfdji.settings
        coxvicjx.javaScriptEnabled = true
        coxvicjx.allowFileAccess = true
        coxvicjx.allowContentAccess = true
        coxvicjx.useWideViewPort = true
        coxvicjx.allowContentAccess = true
        coxvicjx.mediaPlaybackRequiresUserGesture = false
        coxvicjx.loadWithOverviewMode = true
        coxvicjx.displayZoomControls = false
        coxvicjx.builtInZoomControls = true
        coxvicjx.allowFileAccess = true
        coxvicjx.setSupportZoom(true)
        coxvicjx.pluginState = WebSettings.PluginState.ON
        coxvicjx.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        coxvicjx.setAppCacheEnabled(true)
        coxvicjx.domStorageEnabled = true
        coxvicjx.userAgentString = coxvicjx.userAgentString.replace("; wv", "")
        coxvicjx.javaScriptCanOpenWindowsAutomatically = true
        coxvicjx.setSupportMultipleWindows(false)

        return coxvicjx
    }

}