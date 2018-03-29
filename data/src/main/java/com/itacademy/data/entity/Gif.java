package com.itacademy.data.entity;


import java.util.List;

public class Gif {
    private List<Images> data;

    public Gif(List<Images> data) {
        this.data = data;
    }

    public void setData(List<Images> data) {
        this.data = data;
    }

    public List<Images> getData() {
        return data;
    }


}
