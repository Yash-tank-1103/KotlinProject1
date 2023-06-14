package com.example.grocerry.Model

import com.google.gson.annotations.SerializedName
import retrofit2.Response

class LoginModel {

    @SerializedName("response" ) var response : Responses? = Responses()


}
data class User (

    @SerializedName("id"           ) var id          : Int?    = null,
    @SerializedName("name"         ) var name        : String? = null,
    @SerializedName("email"        ) var email       : String? = null,
    @SerializedName("contact_no"   ) var contactNo   : String? = null,
    @SerializedName("lastname"     ) var lastname    : String? = null,
    @SerializedName("gender"       ) var gender      : String? = null,
    @SerializedName("role"         ) var role        : String? = null,
    @SerializedName("user_image"   ) var userImage   : String? = null,
    @SerializedName("status"       ) var status      : String? = null,
    @SerializedName("bod"          ) var bod         : String? = null,
    @SerializedName("device_token" ) var deviceToken : String? = null,
    @SerializedName("created_at"   ) var createdAt   : String? = null,
    @SerializedName("updated_at"   ) var updatedAt   : String? = null

)


data class Responses (

    @SerializedName("status"  ) var status  : String? = null,
    @SerializedName("message" ) var message : String? = null,
    @SerializedName("token"   ) var token   : String? = null,
    @SerializedName("user"    ) var user    : User?   = User()

)