package com.example.lyp.lppkaoshi1.p;

import android.view.View;

import com.example.lyp.lppkaoshi1.beans.MyBeans;
import com.example.lyp.lppkaoshi1.c.MyCallBack;
import com.example.lyp.lppkaoshi1.m.MyM;
import com.example.lyp.lppkaoshi1.v.MyView;

public class MyP implements Pin, MyCallBack {

    private MyM m;

    private MyView view;

    public MyP(MyM m, MyView view) {
        this.m = m;
        this.view = view;
    }

    @Override
    public void getData() {

        if (m!=null){

            m.getData(this);
        }
    }

    @Override
    public void success(MyBeans myBeans) {
        if (view!=null){

            view.success(myBeans);
        }
    }

    @Override
    public void fail(String msg) {
        if (view!=null){

            view.fail(msg);
        }
    }
}
