package com.ls.rjianzye.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ls.rjianzye.R;

public class AdymActivity extends AppCompatActivity {
    TextView tv_ad;

    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adym);
        tv_ad = findViewById(R.id.tv_ad);


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=5;i>=0;i--){
                    SystemClock.sleep(1000);
                    final int count=i;

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            tv_ad.setText("点击转跳 "+count);
                        }
                    }) ;
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(AdymActivity.this,MainActivity.class);
                        startActivity(intent);

                        finish();
                    }
                });
            }
        }).start();
    }
}
