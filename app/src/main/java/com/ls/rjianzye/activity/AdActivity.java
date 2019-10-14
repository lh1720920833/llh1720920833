package com.ls.rjianzye.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import com.ls.rjianzye.R;

import org.w3c.dom.Text;

public class AdActivity extends AppCompatActivity {
    TextView tv_ad;

    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
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
                         Intent intent = new Intent(AdActivity.this,MainActivity.class);
                         startActivity(intent);

                         finish();
                     }
                 });
             }
         }).start();
    }
}
