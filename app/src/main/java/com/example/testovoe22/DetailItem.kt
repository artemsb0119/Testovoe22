package com.example.testovoe22

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DetailItem(
    @SerializedName("id") val id: Int,
    @SerializedName("text") val text: String
)
