package com.farer.withpet.network

import com.farer.withpet.data.PlaceData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("/api/15111389/v1/uddi:41944402-8249-4e45-9e9d-a52d0a7db1cc?page=1" +
            "&perPage=10" +
            "&serviceKey=nTNr7pK9yaijM64I%2Filv9YhckDQONe53mIfzg%2BIe5uOSVOUP2XcJGILxbysi5m3u3wOHkWFZjIaGjBvVW4vbiw%3D%3D")
    fun searchPlaceToString(
        @Query("시설명") placeName: String,
        @Query("도로명주소") roadAddress: String) : Call<String>

    @GET("/api/15111389/v1/uddi:41944402-8249-4e45-9e9d-a52d0a7db1cc?page=1" +
            "&perPage=10" +
            "&serviceKey=nTNr7pK9yaijM64I%2Filv9YhckDQONe53mIfzg%2BIe5uOSVOUP2XcJGILxbysi5m3u3wOHkWFZjIaGjBvVW4vbiw%3D%3D")
    fun searchPlace(
        @Query("시설명") placeName:String,
        @Query("도로명주소") roadAddress:String) : Call<PlaceData>
}