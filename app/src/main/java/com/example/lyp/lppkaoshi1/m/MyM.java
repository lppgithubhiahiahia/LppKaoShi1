package com.example.lyp.lppkaoshi1.m;

import com.example.lyp.lppkaoshi1.api.MySerive;
import com.example.lyp.lppkaoshi1.beans.MyBeans;
import com.example.lyp.lppkaoshi1.c.MyCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyM implements Min {
    @Override
    public void getData(final MyCallBack callBack) {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(MySerive.url)
                .build();

        MySerive mySerive = retrofit.create(MySerive.class);

        Observable<MyBeans> observable = mySerive.getData();

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyBeans>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyBeans myBeans) {
                        if (myBeans!=null){

                            callBack.success(myBeans);

                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                        callBack.fail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
