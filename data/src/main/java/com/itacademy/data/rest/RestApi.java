package com.itacademy.data.rest;


import com.itacademy.data.entity.Gif;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RestApi {

    @GET("/v1/gifs/search")
    @Headers("api_key: " + Constansts.API_IMAGE_KEY)
    Observable<Gif> searchImages(@Query("q") String search);

    @Headers("api_key: " + Constansts.API_IMAGE_KEY)
    @GET("/v1/gifs/trending")
    Observable<Gif> trendingImages();
}
