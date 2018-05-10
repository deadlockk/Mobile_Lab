package com.example.user.lab4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private Button openSlide;
    private Button closeSlide;
    LinearLayout sliding;
    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openSlide = findViewById(R.id.btn_open);
        closeSlide = findViewById(R.id.btn_close);
        sliding = findViewById(R.id.sliding);
        openSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sliding.setVisibility(View.VISIBLE);
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate1);
                sliding.startAnimation(anim);
            }
        });
        closeSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate2);
                sliding.startAnimation(anim);
                sliding.setVisibility(View.GONE);
            }
        });
    }
}