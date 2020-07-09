package com.example.listuser.data


import com.google.gson.annotations.SerializedName

data class DataUser(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Result>
)