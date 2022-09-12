package com.alfari.roemahmobilapp

data class InputTukar(

    val result:List<Data>) {

    data class Data(
        val nopol: String?,
        val nopol_tukar: String?,
        val nama_tukar: String?,
        val tahun_tukar: String?,
        val warna_tukar: String?,
        val nama_customer: String?,
        val jumlah: String?
    )
}

