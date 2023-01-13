package com.superking.parchisi.stary.kxizjsu

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.util.Log
import android.webkit.*
import android.widget.Toast
import com.superking.parchisi.stary.Grsixijzc.Companion.dijsajijidas
import com.superking.parchisi.stary.Grsixijzc.Companion.tiookdfo
import com.superking.parchisi.stary.databinding.ActivityWebBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class AviaWebAct : AppCompatActivity() {
    private lateinit var kvovckvbijbv: ActivityWebBinding
    lateinit var ockxkoxc: WebView
    var cokxoxzo = ""

    private var lxocij: ValueCallback<Array<Uri>>? = null
    private var wijsjid: String? = null
    private val pcokxvicj = 1
    private var exitexitexitexit = false
    private val okxzxijxchgygyscgsyc by viewModel<AviaPeekModel>(
        named("BeamModel")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kvovckvbijbv = ActivityWebBinding.inflate(layoutInflater)
        setContentView(kvovckvbijbv.root)
        ockxkoxc = kvovckvbijbv.webst
        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setAcceptThirdPartyCookies(ockxkoxc, true)
        okxzxijxchgygyscgsyc.docicxcxhcxu(ockxkoxc)


        ockxkoxc.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(url)) {
                        return false
                    }
                    if (okxzxijxchgygyscgsyc.oieijdkofkdo(url)) {

                        val obvjibvij = Intent(Intent.ACTION_VIEW)
                        obvjibvij.data = Uri.parse(url)
                        startActivity(obvjibvij)
                    } else {

                        Toast.makeText(
                            applicationContext,
                            "Application is not installed",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                            )
                        )
                    }
                    return true
                } catch (e: Exception) {
                    return false
                }
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                mcixoxc(url)
            }


            override fun onReceivedError(
                view: WebView?,
                errorCode: Int,
                description: String?,
                failingUrl: String?
            ) {
                Toast.makeText(this@AviaWebAct, description, Toast.LENGTH_SHORT).show()
            }
        }

        ockxkoxc.webChromeClient = Frixixjzxjz()
        ockxkoxc.loadUrl(xcoxciocpoxccjcv())
    }

    override fun onActivityResult(rpdokd: Int, bovkvb: Int, spasasl: Intent?) {

        if (rpdokd != pcokxvicj || lxocij == null) {
            super.onActivityResult(rpdokd, bovkvb, spasasl)
            return
        }
        var pvlccovkcvo: Array<Uri>? = null

        if (bovkvb == RESULT_OK) {
            if (spasasl == null) {
                if (wijsjid != null) {
                    pvlccovkcvo = arrayOf(Uri.parse(wijsjid))
                }
            } else {
                val tixjzhuxzhzx = spasasl.dataString
                if (tixjzhuxzhzx != null) {
                    pvlccovkcvo = arrayOf(Uri.parse(tixjzhuxzhzx))
                }
            }
        }
        lxocij!!.onReceiveValue(pvlccovkcvo)
        lxocij = null
        return
    }
    override fun onBackPressed() {

        if (ockxkoxc.canGoBack()) {
            if (exitexitexitexit) {
                ockxkoxc.stopLoading()
                ockxkoxc.loadUrl(cokxoxzo)
            }
            this.exitexitexitexit = true
            ockxkoxc.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                exitexitexitexit = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }



    private fun xcoxciocpoxccjcv(): String {

        val ivjicvb = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)


        val oskdkdosa = getSharedPreferences(
            "SHARED_PREF",
            Context.MODE_PRIVATE
        )


        val ninbijbni = oskdkdosa.getString(dijsajijidas, null)
        val bjvjivb = oskdkdosa.getString("link", null)
        val firrjds = oskdkdosa.getString(tiookdfo, null)

        val woksdjisd = oskdkdosa.getString("WebInt", null)


        when (woksdjisd) {
            "campaign" -> {
                okxzxijxchgygyscgsyc.fovijc(ninbijbni.toString())
            }
            "deepLink" -> {
                okxzxijxchgygyscgsyc.fovijc(ninbijbni.toString())
            }
            "deepLinkNOApps" -> {
                okxzxijxchgygyscgsyc.fovijc(firrjds.toString())
            }
            "geo" -> {
                okxzxijxchgygyscgsyc.fovijc(firrjds.toString())
            }

        }
        Log.d("lolo", "link is ${bjvjivb}")
        return ivjicvb.getString("SAVED_URL", bjvjivb).toString()
    }


    fun mcixoxc(oqisjd: String?) {
        if (!oqisjd!!.contains("t.me")) {

            if (cokxoxzo == "") {
                cokxoxzo = getSharedPreferences(
                    "SP_WEBVIEW_PREFS",
                    AppCompatActivity.MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    oqisjd
                ).toString()

                val covcvk =
                    getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)
                val ucxhvhucx = covcvk.edit()
                ucxhvhucx.putString("SAVED_URL", oqisjd)
                ucxhvhucx.apply()
            }
        }
    }

    inner class Frixixjzxjz : WebChromeClient() {

        override fun onShowFileChooser(
            view: WebView?,
            ijxcxji: ValueCallback<Array<Uri>>?,
            xxozckxz: FileChooserParams?
        ): Boolean {
            lxocij?.onReceiveValue(null)
            lxocij = ijxcxji
            var okijcxjvijxciuhcxygxc: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (okijcxjvijxciuhcxygxc!!.resolveActivity(packageManager) != null) {
                var orodksfji: File? = null
                try {
                    orodksfji = ocixjchuxchu()
                    okijcxjvijxciuhcxygxc.putExtra("PhotoPath", wijsjid)
                } catch (ex: IOException) {
                    Log.e("ErrorOccurred", "Unable to create Image File", ex)
                }

                if (orodksfji != null) {
                    wijsjid = "file:" + orodksfji.absolutePath
                    okijcxjvijxciuhcxygxc.putExtra(
                        MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(orodksfji)
                    )
                } else {
                    okijcxjvijxciuhcxygxc = null
                }
            }
            val qpsokdsko = Intent(Intent.ACTION_GET_CONTENT)
            qpsokdsko.addCategory(Intent.CATEGORY_OPENABLE)
            qpsokdsko.type = "image/*"
            val ovkcb: Array<Intent?> =
                okijcxjvijxciuhcxygxc?.let { arrayOf(it) } ?: arrayOfNulls(0)
            val loxckzxjijzxci = Intent(Intent.ACTION_CHOOSER)
            loxckzxjijzxci.putExtra(Intent.EXTRA_INTENT, qpsokdsko)
            loxckzxjijzxci.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
            loxckzxjijzxci.putExtra(Intent.EXTRA_INITIAL_INTENTS, ovkcb)
            startActivityForResult(loxckzxjijzxci, pcokxvicj)
            return true
        }

        fun ocixjchuxchu(): File? {
            val dofjidfsjd = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val ckxxcmkxc = "JPEG_" + dofjidfsjd + "_"
            val oksoiijddjsijdsi = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES
            )
            return File.createTempFile(
                ckxxcmkxc,
                ".jpg",
                oksoiijddjsijdsi
            )
        }
    }

}

