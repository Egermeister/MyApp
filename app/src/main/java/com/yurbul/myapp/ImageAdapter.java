package com.yurbul.myapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context сontext;

    public ImageAdapter(Context c) {сontext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (view == null) {
            imageView = new ImageView(сontext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) view;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    public Integer[] mThumbIds = {
            R.drawable.ic_launcher_background, R.drawable.ic_settings,
            R.drawable.ic_launcher_background, R.drawable.ic_settings,
            R.drawable.ic_launcher_background, R.drawable.ic_settings,
            R.drawable.ic_launcher_background, R.drawable.ic_settings,

    };
}
