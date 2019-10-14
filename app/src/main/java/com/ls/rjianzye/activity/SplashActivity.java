package com.ls.rjianzye.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.ls.rjianzye.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        View loadingView = findViewById(R.id.iv_loading);

        Animation animation = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.splash_loading);
        animation.setFillAfter(true);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(SplashActivity.this, AdymActivity.class);
                startActivity(intent);
                finish();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        loadingView.startAnimation(animation);

    }
}
