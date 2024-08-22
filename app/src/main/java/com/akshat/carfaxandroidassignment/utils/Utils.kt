package com.akshat.carfaxandroidassignment.utils

import android.icu.text.DecimalFormat

fun formatAmount(amount: Int) : DecimalFormat{
    val dec = DecimalFormat("#,###")
    val result = DecimalFormat(amount.toString())

    return result
}