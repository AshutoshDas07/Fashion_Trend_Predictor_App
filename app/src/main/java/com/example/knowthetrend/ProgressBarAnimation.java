package com.example.knowthetrend;

import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarAnimation extends Animation {
    private Context context;
    private ProgressBar progressBar;
    private TextView textView,loadingmatter;
    private float from;
    private float to;
    private Intent intent;

    public ProgressBarAnimation(Context context, ProgressBar progressBar, TextView textView, float from, float to,Intent intent,TextView loadingmatter ){
        this.context=context;
        this.progressBar=progressBar;
        this.textView=textView;
        this.from=from;
        this.to=to;
        this.intent=intent;
        this.loadingmatter=loadingmatter;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value=from+(to-from)*interpolatedTime;
        progressBar.setProgress((int)value);
        textView.setText((int)value+"%");
        if((int)value==25){
            loadingmatter.setText("Fetching Data");
        }
        if((int)value==50){
            loadingmatter.setText("Analyzing Data");
        }
        if((int)value==75){
            loadingmatter.setText("Getting Completed");
        }
        String catType=intent.getStringExtra("catType");
        Intent i=new Intent(context,MainActivity.class);
        if(value==to){
            if(catType.equals("Men")) {
                i.putExtra("catType", 0);
            }
            if(catType.equals("Women")) {
                i.putExtra("catType", 1);
            }
            if(catType.equals("TTT")) {
                i.putExtra("catType", 2);
            }
            loadingmatter.setText("Completed");
            context.startActivity(i);
        }

    }
}
