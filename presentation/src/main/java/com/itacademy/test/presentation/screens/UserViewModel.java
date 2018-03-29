package com.itacademy.test.presentation.screens;



import android.databinding.ObservableField;
import android.text.Editable;

import com.itacademy.domain.entity.ImagesEntity;
import com.itacademy.domain.interactors.SearchGifUseCase;
import com.itacademy.domain.interactors.TrendingGifUseCase;
import com.itacademy.test.app.App;
import com.itacademy.test.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class UserViewModel extends BaseViewModel {

    @Inject
    public TrendingGifUseCase getDataUseCase;
    @Inject
    public SearchGifUseCase getSearchUseCase;

    public final ObservableField<List<ImagesEntity>> gifs = new ObservableField<>();

    public UserViewModel() {
        App.getAppComponent().inject(this);
        getData();
    }

    public void searchGif(Editable s) {
        if (s == null || s.length() == 0){
            getData();
        }
        getSearchUseCase.getSearch(s.toString()).subscribe(new Observer<List<ImagesEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(List<ImagesEntity> gif) {
                gifs.set(gif);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void getData() {
        getDataUseCase.getTrending().subscribe(new Observer<List<ImagesEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(List<ImagesEntity> gif) {
                gifs.set(gif);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}