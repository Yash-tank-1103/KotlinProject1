package com.example.grocerry.Model

import com.google.gson.annotations.SerializedName

class SimilarProductModel {
    @SerializedName("response" ) var response : Responsess = Responsess()
}

data class Imagesmore (

    @SerializedName("id"         ) var id        : Int?    = null,
    @SerializedName("p_id"       ) var pId       : String? = null,
    @SerializedName("images"     ) var images    : String? = null,
    @SerializedName("created_at" ) var createdAt : String? = null,
    @SerializedName("updated_at" ) var updatedAt : String? = null

)

data class Productlist1 (

    @SerializedName("id"             ) var id             : Int?                  = null,
    @SerializedName("c_id"           ) var cId            : String?               = null,
    @SerializedName("producttype"    ) var producttype    : String?               = null,
    @SerializedName("productname"    ) var productname    : String?               = null,
    @SerializedName("productdetails" ) var productdetails : String?               = null,
    @SerializedName("images"         ) var images         : String?               = null,
    @SerializedName("prices"         ) var prices         : String?               = null,
    @SerializedName("status"         ) var status         : String?               = null,
    @SerializedName("updated_at"     ) var updatedAt      : String?               = null,
    @SerializedName("created_at"     ) var createdAt      : String?               = null,
    @SerializedName("imagesmore"     ) var imagesmore     : ArrayList<Imagesmore> = arrayListOf(),
    @SerializedName("categorys"      ) var categorys      : ArrayList<String>     = arrayListOf()

)


data class Responsess (

    @SerializedName("status"      ) var status      : String?                = null,
    @SerializedName("message"     ) var message     : String?                = null,
    @SerializedName("Productlist" ) var Productlist : ArrayList<Productlist1> = arrayListOf()

)