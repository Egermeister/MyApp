package com.yurbul.myapp;

import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyLayout myLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myLayout = findViewById(R.id.MyLayout);
        myLayout.setVisibility(View.INVISIBLE);
        myLayout.textSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // myLayout.textSettings.setStateListAnimator();
                Intent intent = new Intent(MainActivity.this, SignsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton buttonSigns = findViewById(R.id.image_signs);
        buttonSigns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton buttonTerms = findViewById(R.id.image_terms);
        buttonTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, TermsActivity.class);
                startActivity(intent);
            }
        });

       /* ExpandableListView expandableListView = findViewById(R.id.expandableList);
        ArrayList<ArrayList<String>> groups = new ArrayList<>();
        ArrayList<String> child1 = new ArrayList<>();
        ArrayList<String> child2 = new ArrayList<>();
        ArrayList<String> child3 = new ArrayList<>();
        child3.add("Содержание");
        child3.add("Содержание1");
        child3.add("Содержание2");
        child1.add("Содержание");
        child1.add("Содержание1");
        child1.add("Содержание2");
        child2.add("Содержание");
        child2.add("Содержание1");
        groups.add(child1);
        groups.add(child2);
        groups.add(child3);
        ExpandableListAdapter expandableListAdapter = new ListExpAdapter(getApplicationContext(), groups);
        expandableListView.setAdapter(expandableListAdapter);*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.search_button);
        final SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint("Поиск");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i("mine", String.valueOf(searchView.getQuery()));
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.more_button){
            myLayout.setVisibility(View.VISIBLE);
            onStartAnimation();
        }

        return super.onOptionsItemSelected(item);
    }

    public void onStartAnimation(){
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(800, 200);
        myLayout.setBackgroundColor(Color.WHITE);
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.dimAmount = 0;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                myLayout.setTranslationX(value);
            }
        });

        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setDuration(2000);
        valueAnimator.start();
    }
}
