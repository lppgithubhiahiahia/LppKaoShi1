package com.example.lyp.lppkaoshi1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.lyp.lppkaoshi1.adapter.ReAdapter;
import com.example.lyp.lppkaoshi1.beans.MyBeans;
import com.example.lyp.lppkaoshi1.m.MyM;
import com.example.lyp.lppkaoshi1.p.MyP;
import com.example.lyp.lppkaoshi1.p.Pin;
import com.example.lyp.lppkaoshi1.v.MyView;

import java.util.ArrayList;

public class Two extends AppCompatActivity implements MyView {

    private static final String TAG = Two.class.getName();
    private RecyclerView rv;
    private Toolbar toolbar;
    private ArrayList<MyBeans.ResultBean> list;
    private ArrayList<Integer> banners;
    private ReAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        initView();
        initData();
    }

    private void initData() {

        Pin pin=new MyP(new MyM(),this);

        pin.getData();
    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("");

        setSupportActionBar(toolbar);


        list = new ArrayList<>();

        banners = new ArrayList<>();

        banners.add(R.drawable.a);
        banners.add(R.drawable.b);
        banners.add(R.drawable.c);
        banners.add(R.drawable.d);


        rv.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ReAdapter(this, list, banners);

        rv.setAdapter(adapter);
    }

    @Override
    public void success(MyBeans myBeans) {

        Log.i(TAG, "success: "+myBeans);

        list.addAll(myBeans.getResult());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void fail(String msg) {

    }
}
