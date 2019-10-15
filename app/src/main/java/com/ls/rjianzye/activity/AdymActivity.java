package com.ls.rjianzye.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ls.rjianzye.R;

public class AdymActivity extends AppCompatActivity {
    TextView tv_ad;

    Handler handler = new Handler();
    boolean isStop;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adym);

        tv_ad=findViewById(R.id.tv_ad);

        tv_ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isStop=true;
                Intent intent3 = new Intent(AdymActivity.this,MainActivity.class);
                startActivity(intent3);
                finish();

            }
        });

        isStop=false;
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i;
                for (i = 5; i >= 0; i--) {

                    if(isStop){
                        return;
                    }
                    SystemClock.sleep(1000);

                    final int count = i;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            tv_ad.setText("点击转跳 " + count);

                        }
                    });

                }
               runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       Intent intent1 = new Intent(AdymActivity.this, MainActivity.class);
                       startActivity(intent1);

                       finish();
                   }
               });
            }
        }).start();
    }
}
