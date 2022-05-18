package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class SayoriGrid extends AppCompatActivity {

    private GridView gridView;
    int[] images = {R.drawable.sayori1,R.drawable.sayori2,R.drawable.sayori3,R.drawable.sayori4,R.drawable.sayori5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayori_grid);

        gridView = findViewById(R.id.grid);
        gridView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public Object getItem(int i) {
                return images[i];
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ImageView imageView = new ImageView( SayoriGrid.this);
                imageView.setImageResource(images[i]);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(540,1230));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

                return imageView;
            }


        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sayori, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.sayorireddits:
                Intent intent = new Intent(this, SayoriReddit.class);
                startActivity(intent);
                return true;

            case R.id.sayorigrid:
                Intent intent2 = new Intent(this, Sayori.class);
                startActivity(intent2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
        super.onBackPressed();
    }
}