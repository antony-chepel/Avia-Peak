package com.superking.parchisi.stary.nbuvi

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.superking.parchisi.stary.kxizjsu.AviaPeekModel
import com.superking.parchisi.stary.kxizjsu.Hoxiizxjs
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val ijxicj = module {

    single  <HostInterface> (named("HostInter")){
        get<Retrofit>(named("RetroDev"))
            .create(HostInterface::class.java)
    }

    single <Bgxiixzhuxhucs> (named("ApiInter")) {
        get<Retrofit>(named("RetroCountry"))
            .create(Bgxiixzhuxhucs::class.java)
    }
    single<Retrofit>(named("RetroCountry")) {
        Retrofit.Builder()
            .baseUrl("http://pro.ip-api.com/")
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }
    single <Retrofit>(named("RetroDev")){
        Retrofit.Builder()
            .baseUrl("http://powerofdragon.live/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory (named("CountryRep")) {
        Juxoxizcjxc(get(named("ApiInter")))
    }

    factory  (named("DevRep")){
        Bixijcijzxcxcz(get(named("HostInter")))
    }
    single{
        odsfjifdji()
    }
    single (named("SharedPreferences")) {
        okvbkov(androidApplication())
    }
}

fun okvbkov(oxkz: Application): SharedPreferences {
    return oxkz.applicationContext.getSharedPreferences(
        "SHARED_PREF",
        Context.MODE_PRIVATE
    )
}

fun odsfjifdji(): Gson {
    return GsonBuilder().create()
}

val oxkzkoxz = module {
    viewModel (named("MainModel")){
        Hoxiizxjs((get(named("CountryRep"))), get(named("DevRep")), get(named("SharedPreferences")), get())
    }
    viewModel(named("BeamModel")) {
        AviaPeekModel(get())
    }
}
