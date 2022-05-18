package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Monika extends AppCompatActivity {

    private OutputStream outputStream;
    private ImageView imageView;
    private ImageSwitcher monikasw;
    private Button next,prev;
    private int position = 0;
    private int[] images = {R.drawable.monika1,R.drawable.monika2,R.drawable.monika3,R.drawable.monika4,R.drawable.monika5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monika);
        getSupportActionBar().setTitle("Monika");

        monikasw = findViewById(R.id.imageSwitcher);
        next = findViewById(R.id.nextbtn);
        prev = findViewById(R.id.prevbtn);

        monikasw.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                imageView = new ImageView(Monika.this);
                imageView.setImageResource(images[position]);
                registerForContextMenu(imageView);
                return imageView;

            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position>=0 && position<4){
                    position++;
                    monikasw.setImageResource(images[position]);
                }if(position == 4){
                    next.setEnabled(false);
                    monikasw.setImageResource(images[position]);
                }
                prev.setEnabled(true);

            }
        });
        prev.setEnabled(false);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(position>=1 && position<5){
                    prev.setEnabled(true);
                    position--;
                    monikasw.setImageResource(images[position]);
                }if(position==0){
                    prev.setEnabled(false);
                }
                next.setEnabled(true);


            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.monika, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.monikareddits:
                Intent intent = new Intent(this, MonikaReddit.class);
                startActivity(intent);
                return true;

            case R.id.monikagrids:
                Intent intent2 = new Intent(this, MonikaGrid.class);
                startActivity(intent2);
                return true;

            default:
                return super.onContextItemSelected(item);
        }

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
        super.onBackPressed();
    }
}