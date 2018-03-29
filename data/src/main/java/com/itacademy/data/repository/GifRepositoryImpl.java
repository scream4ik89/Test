package com.itacademy.data.repository;


import com.itacademy.data.entity.Images;
import com.itacademy.data.rest.RestService;
import com.itacademy.domain.entity.ImagesEntity;
import com.itacademy.domain.repository.GifRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class GifRepositoryImpl implements GifRepository {


    private RestService restService;

    public GifRepositoryImpl(RestService restService) {
        this.restService = restService;
    }

    @Override
    public Observable<List<ImagesEntity>> search(String search) {
        return restService.searchImages(search)
                .map(new Function<List<Images>, List<ImagesEntity>>() {
                    @Override
                    public List<ImagesEntity> apply(List<Images> images) throws Exception {
                        List<ImagesEntity> list = new ArrayList<>();
                        for (Images image: images){
                            list.add(new ImagesEntity(image.getImages().getFixed_width_small().getUrl()));
                        }
                        return list;
                    }
                });
    }

    @Override
    public Observable<List<ImagesEntity>> trending() {
        return restService.trendingImages()
                .map(new Function<List<Images>, List<ImagesEntity>>() {
                    @Override
                    public List<ImagesEntity> apply(List<Images> images) throws Exception {
                        List<ImagesEntity> list = new ArrayList<>();
                        for (Images image: images){
                            list.add(new ImagesEntity(image.getImages().getFixed_width_small().getUrl()));
                        }
                        return list;
                    }
                });
    }

}
