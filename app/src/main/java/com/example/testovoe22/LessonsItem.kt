package com.example.testovoe22

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LessonsItem(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("read") var read: Boolean
): Serializable
