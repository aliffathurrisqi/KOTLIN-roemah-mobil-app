package com.alfari.roemahmobilapp

data class InputBeli(

    val result:List<Data>) {

    data class Data(
        val nopol: String?,
        val nama_customer: String?,
        val jumlah: String?
    )
}

