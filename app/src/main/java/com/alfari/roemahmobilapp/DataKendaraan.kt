package com.alfari.roemahmobilapp

data class DataKendaraan(

    val result:List<Data>) {

    data class Data(
        val nopol: String?,
        val nama_kendaraan: String?,
        val tahun_pembuatan: String?,
        val warna: String?,
        val status: String?,
        val harga: String?
    )
}

