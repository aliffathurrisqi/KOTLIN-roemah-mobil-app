package com.alfari.roemahmobilapp

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiEndpoint {

    @GET("data_beli.php")
        fun data_beli() : Call <DataBeli>

    @GET("data_tukar.php")
    fun data_tukar() : Call <DataTukar>

    @FormUrlEncoded
    @POST("data_kendaraan.php")
    fun cari_kendaraan(
        @Field("nopol") nopol:String
    ) : Call<DataKendaraan>
//
//    @GET("data_kendaraan.php")
//    fun data_kendaraan(
//        @Field("nopol") nopol: String
//    ) : Call <DataKendaraan>

    @FormUrlEncoded
    @POST("input_beli.php")
    fun input_beli(
        @Field("nopol") nopol:String,
        @Field("nama_customer") nama_customer:String,
        @Field("jumlah") jumlah:String
    ) : Call<InputBeli>

    @FormUrlEncoded
    @POST("input_tukar.php")
    fun input_tukar(
        @Field("nopol") nopol:String,
        @Field("nopol_tukar") nopol_tukar:String,
        @Field("nama_tukar") nama_tukar:String,
        @Field("tahun_tukar") tahun_tukar:String,
        @Field("warna_tukar") warna_tukar:String,
        @Field("nama_customer") nama_customer:String,
        @Field("jumlah") jumlah:String
    ) : Call<InputTukar>

}