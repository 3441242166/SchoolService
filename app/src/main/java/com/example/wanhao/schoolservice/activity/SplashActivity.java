package com.example.wanhao.schoolservice.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.presenter.SplashPresenter;
import com.example.wanhao.schoolservice.view.ISplashView;

public class SplashActivity extends AppCompatActivity implements ISplashView {



    private SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        presenter = new SplashPresenter(this,this);
        presenter.initData();

    }


    @Override
    public void error() {

    }

    @Override
    public void goMainActivity() {

    }

    @Override
    public void goLodingActivity() {

    }
}
