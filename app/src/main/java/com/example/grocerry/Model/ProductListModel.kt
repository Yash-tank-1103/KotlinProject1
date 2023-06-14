package com.example.grocerry.Model

import com.google.gson.annotations.SerializedName

class ProductListModel (
    @SerializedName("response" ) var response : Response? = Response()


)

data class Categorys (

    @SerializedName("id"         ) var id        : Int?    = null,
    @SerializedName("name"       ) var name      : String? = null,
    @SerializedName("image"      ) var image     : String? = null,
    @SerializedName("status"     ) var status    : String? = null,
    @SerializedName("created_at" ) var createdAt : String? = null,
    @SerializedName("updated_at" ) var updatedAt : String? = null

)

data class Futureproduct (

    @SerializedName("id"             ) var id             : Int?                 = null,
    @SerializedName("productname"    ) var productname    : String?              = null,
    @SerializedName("productdetails" ) var productdetails : String?              = null,
    @SerializedName("producttype"    ) var producttype    : String?              = null,
    @SerializedName("status"         ) var status         : String?              = null,
    @SerializedName("prices"         ) var prices         : String?              = null,
    @SerializedName("c_id"           ) var cId            : String?              = null,
    @SerializedName("images"         ) var images         : ArrayList<Images>    = arrayListOf(),
    @SerializedName("categorys"      ) var categorys      : ArrayList<Categorys> = arrayListOf()

)

data class Images (

    @SerializedName("id"         ) var id        : Int?    = null,
    @SerializedName("p_id"       ) var pId       : String? = null,
    @SerializedName("images"     ) var images    : String? = null,
    @SerializedName("created_at" ) var createdAt : String? = null,
    @SerializedName("updated_at" ) var updatedAt : String? = null

)

data class Otherproduct (

    @SerializedName("id"             ) var id             : Int?                 = null,
    @SerializedName("productname"    ) var productname    : String?              = null,
    @SerializedName("productdetails" ) var productdetails : String?              = null,
    @SerializedName("producttype"    ) var producttype    : String?              = null,
    @SerializedName("status"         ) var status         : String?              = null,
    @SerializedName("prices"         ) var prices         : String?              = null,
    @SerializedName("c_id"           ) var cId            : String?              = null,
    @SerializedName("images"         ) var images         : ArrayList<Images>    = arrayListOf(),
    @SerializedName("categorys"      ) var categorys      : ArrayList<Categorys> = arrayListOf()

)

data class Sliderlist (

    @SerializedName("id"           ) var id          : Int?    = null,
    @SerializedName("slider_image" ) var sliderImage : String? = null,
    @SerializedName("status"       ) var status      : String? = null,
    @SerializedName("created_at"   ) var createdAt   : String? = null,
    @SerializedName("updated_at"   ) var updatedAt   : String? = null

)
            data class Categorylist (

    @SerializedName("id"         ) var id        : Int?    = null,
    @SerializedName("name"       ) var name      : String? = null,
    @SerializedName("image"      ) var image     : String? = null,
    @SerializedName("status"     ) var status    : String? = null,
    @SerializedName("created_at" ) var createdAt : String? = null,
    @SerializedName("updated_at" ) var updatedAt : String? = null

)
data class Response (

@SerializedName("status"        ) var status        : String?                  = null,
@SerializedName("message"       ) var message       : String?                  = null,
@SerializedName("futureproduct" ) var futureproduct : ArrayList<Futureproduct> = arrayListOf(),
@SerializedName("otherproduct"  ) var otherproduct  : ArrayList<Otherproduct>  = arrayListOf(),
@SerializedName("sliderlist"    ) var sliderlist    : ArrayList<Sliderlist>    = arrayListOf(),
@SerializedName("categorylist"  ) var categorylist  : ArrayList<Categorylist>  = arrayListOf()

)