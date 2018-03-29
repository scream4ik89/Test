package com.itacademy.domain.repository;


import com.itacademy.domain.entity.ImagesEntity;

import java.util.List;

import io.reactivex.Observable;

public interface GifRepository {

    Observable<List<ImagesEntity>> search(String search);

    Observable<List<ImagesEntity>> trending();



}
