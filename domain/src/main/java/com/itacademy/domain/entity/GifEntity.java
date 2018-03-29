package com.itacademy.domain.entity;

import java.util.List;

public class GifEntity {
    private List<ImagesEntity> data;

    public GifEntity(List<ImagesEntity> data) {
        this.data = data;
    }

    public List<ImagesEntity> getData() {
        return data;
    }

    public void setData(List<ImagesEntity> data) {
        this.data = data;
    }
}
