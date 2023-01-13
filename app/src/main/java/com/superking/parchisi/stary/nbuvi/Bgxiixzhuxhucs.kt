package com.superking.parchisi.stary.nbuvi

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET

interface Bgxiixzhuxhucs {
    @GET("json/?key=mFBNVQSnCdDASI9")
    suspend fun ovkcvcjib(): Response<Joxkxzij>
}


class Juxoxizcjxc(private val ofkfgokf: Bgxiixzhuxhucs) {
    suspend fun oxkcoxck() = ofkfgokf.ovkcvcjib()
}

@Keep
data class Noxixcjxc(
    @SerializedName("geo")
    val ofkokovc: String,
    @SerializedName("view")
    val qosjijid: String,
    @SerializedName("appsChecker")
    val ibjvvbokvb: String,
)

interface HostInterface {
    @GET("file.json")
    suspend fun icjxci(): Response<Noxixcjxc>
}


class Bixijcijzxcxcz(private val obkvbibn: HostInterface) {
    suspend fun getDataDev() = obkvbibn.icjxci()
}

@Keep
data class Joxkxzij(
    @SerializedName("countryCode")
    val okcvkocv: String,
)


