package com.itacademy.test.presentation.screens;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.itacademy.test.R;
import com.itacademy.test.base.BaseMvvmActivity;
import com.itacademy.test.presentation.utils.AdapterRV;


public class UserActivity extends BaseMvvmActivity {
    @Override
    public int provideLayoutId() {
        return R.layout.activity_gif;
    }

    @Override
    public UserViewModel provideViewModel() {
        return ViewModelProviders.of(this).
                get(UserViewModel.class);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView recyclerView = binding.getRoot().findViewById(R.id.recycle);
        recyclerView.setAdapter(new AdapterRV());
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}
