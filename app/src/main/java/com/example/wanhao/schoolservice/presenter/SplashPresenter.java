package com.example.wanhao.schoolservice.presenter;

import android.content.Context;
import android.util.Log;

import com.example.wanhao.schoolservice.view.ISplashView;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;

public class SplashPresenter {
    private static final String TAG = "SplashPresenter";

    private Context context;
    private ISplashView view;

    public SplashPresenter(Context context, ISplashView view){
        this.context = context;
        this.view = view;
    }

    public void initData(){
        Observable obserInitSDK = Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter e) throws Exception {
                initSDK();
            }
        });

        Observable obserInitDB = Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter e) throws Exception {
                initSDK();
            }
        });

        Observable obserLogin = Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter e) throws Exception {
                initDB();
            }
        });

        Observable observable = Observable.merge(obserInitSDK,obserInitDB,obserLogin);

        observable.subscribe(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                Log.i(TAG, "accept: 初始化完成");
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.i(TAG, "accept: 初始化失败");
            }
        });
    }

    void initSDK(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "initSDK: over");
    }

    void initDB(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "initDB: over");
    }

    void initLoding(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "initLoding: over");
    }
}
