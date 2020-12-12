package com.example.knowthetrend;

import android.content.Intent;
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
    TextView textView,loadingmatter;
    Intent receviedIntent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.predict_splashscreen);
        loadingView=findViewById(R.id.loading);
        progressBar=findViewById(R.id.progressbar);
        loadingmatter=findViewById(R.id.loadmatter);
        receviedIntent=getIntent();
        textView=findViewById(R.id.loadingtext);
        progressBar.setMax(100);
        progressBar.setScaleY(3f);
        Glide.with(this).load(R.raw.loading).into(loadingView);
        progressAnimation(receviedIntent);
    }

    public void progressAnimation(Intent receviedIntent){
        ProgressBarAnimation anim=new ProgressBarAnimation(this,progressBar,textView,0f,100f,receviedIntent,loadingmatter);
        anim.setDuration(8000);
        progressBar.setAnimation(anim);
    }
}
