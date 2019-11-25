package com.ls.rjianzye.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ls.rjianzye.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdymActivity extends AppCompatActivity {
    @BindView(R.id.tv_ad)
    TextView tv_ad;
    @BindView(R.id.iv_image)
    ImageView imageView;

    Handler handler = new Handler();
    boolean isStop;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adym);
        ButterKnife.bind(this);

        Glide.with(AdymActivity.this)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574701032688&di=8ab8c1ef0d3300441bfc805b50d55cb7&imgtype=0&src=http%3A%2F%2Fpic69.nipic.com%2Ffile%2F20150604%2F20892559_094412969472_2.jpg")
                .placeholder(R.mipmap.zhanweitu)
                .error(R.mipmap.error)
                .into(imageView);


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
