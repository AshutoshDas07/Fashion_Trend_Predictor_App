package com.example.knowthetrend;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class LoadingSplashScreen extends AppCompatActivity {
    ImageView loadingView;
    ProgressBar progressBar;
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.predict_splashscreen);
        loadingView=findViewById(R.id.loading);
        progressBar=findViewById(R.id.progressbar);
        textView=findViewById(R.id.loadingtext);
        progressBar.setMax(100);
        progressBar.setScaleY(3f);
        Glide.with(this).load(R.raw.loading).into(loadingView);
        progressAnimation();
    }

    public void progressAnimation(){
        ProgressBarAnimation anim=new ProgressBarAnimation(this,progressBar,textView,0f,100f);
        anim.setDuration(8000);
        progressBar.setAnimation(anim);
    }
}
