package com.itacademy.domain.interactors;

import com.itacademy.domain.entity.ImagesEntity;
import com.itacademy.domain.executor.PostExecutionThread;
import com.itacademy.domain.repository.GifRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


public class TrendingGifUseCase extends BaseUseCase {
    private GifRepository gifRepository;

    @Inject

    public TrendingGifUseCase(PostExecutionThread postExecutionThread,
                              GifRepository gifRepository) {
        super(postExecutionThread);
        this.gifRepository = gifRepository;
    }

    public Observable<List<ImagesEntity>> getTrending(){
        return gifRepository.trending()
                //Schedulers реалицазия потоков. можно делать кастомные
                .subscribeOn(threadExecution) //в каком потоке запустить
                .observeOn(postExecutionThread);  // в каком потоке получить данные
    }
}
