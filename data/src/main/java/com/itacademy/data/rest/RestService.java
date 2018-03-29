package com.itacademy.data.rest;


import com.itacademy.data.entity.Gif;
import com.itacademy.data.entity.Images;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

@Singleton
public class RestService {

    private RestApi restApi;

    @Inject
    public RestService(RestApi restApi) {
        this.restApi = restApi;
    }

    public Observable<List<Images>> searchImages(String search){
        return restApi.searchImages(search)
                .map(new Function<Gif, List<Images>>() {
                    @Override
                    public List<Images> apply(Gif gif) throws Exception {
                        return gif.getData();
                    }
                });
    }

    public Observable<List<Images>> trendingImages(){
        return restApi
                .trendingImages()
                .map(new Function<Gif, List<Images>>() {
                    @Override
                    public List<Images> apply(Gif gif) throws Exception {
                        return gif.getData();
                    }
                });
    }
}
