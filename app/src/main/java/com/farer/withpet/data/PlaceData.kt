package com.farer.withpet.data

import com.google.gson.annotations.SerializedName

data class PlaceData(var data: List<Place>)

data class Place(
    @SerializedName("시설명") var placeName:String,
    @SerializedName("카테고리1") var category1:String,
    @SerializedName("카테고리2") var category2:String,
    @SerializedName("카테고리3") var category3:String,
    @SerializedName("위도") var latitude:String,
    @SerializedName("경도") var longitude:String,
    @SerializedName("도로명주소") var roadAddress:String,
    @SerializedName("지번주소") var address:String,
    @SerializedName("전화번호") var phoneNumber:String,
    @SerializedName("홈페이지") var homepage:String,
    @SerializedName("휴무일") var closedDays:String,
    @SerializedName("운영시간") var openTime:String,
    @SerializedName("주차 가능여부") var parking:String,
)
