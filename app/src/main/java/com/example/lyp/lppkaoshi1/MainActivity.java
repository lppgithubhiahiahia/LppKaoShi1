package com.example.lyp.lppkaoshi1;

import android.content.ContentUris;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

//李亚鹏 h1810b
public class MainActivity extends AppCompatActivity {
    private Timer timer;
    private int a=2;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what==15){
                if (a==0){
                    timer.cancel();
                    startActivity(new Intent(MainActivity.this,Two.class));
                }else {
                    a--;
                    handler.sendEmptyMessageDelayed(15,1000);
                }
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(15);
            }
        },1000,1000);
    }

}
