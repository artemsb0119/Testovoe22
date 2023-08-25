package com.example.testovoe22

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CoursesItem(
    @SerializedName("id") val id: Int,
    @SerializedName("kolvo") val kolvo: String,
    @SerializedName("title") val title: String
): Serializable