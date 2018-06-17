package com.yurbul.myapp;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;


public class MyLayout extends RelativeLayout {
    public MyLayout(Context context) {
        super(context);
        initComponent();
    }

    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initComponent();
    }

    public MyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initComponent();
    }

    public TextView textSettings;
    private TextView textAbout;
    private TextView textLang;
    private SeekBar seekBar;

    public void initComponent(){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.my_layout, this);
        textSettings = findViewById(R.id.textSettings);
        textSettings.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }


}
