package com.itacademy.test.presentation.utils;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;

import com.itacademy.domain.entity.ImagesEntity;

import java.util.List;

public class SetEntriesRVAdapter {
    @BindingAdapter("android:entries")
    public static void setAdaptRW(RecyclerView recyclerView, ObservableField<List<ImagesEntity>> gifs) {
        AdapterRV adapterRV = (AdapterRV) recyclerView.getAdapter();
        if (gifs.get() != null)
            adapterRV.setGifs(gifs.get());
    }
}
