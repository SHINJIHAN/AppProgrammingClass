package com.example.seoultour

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Place(val title: String,
                 val address: String,
                 val desc: String, val photo: Int) : Parcelable