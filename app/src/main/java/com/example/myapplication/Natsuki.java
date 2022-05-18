package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class Natsuki extends AppCompatActivity {

    private ImageSwitcher natsukisw;
    private Button next,prev;
    private int position = 0;
    private int[] images = {R.drawable.natsuki1,R.drawable.natsuki2,R.drawable.natsuki3,R.drawable.natsuki4,R.drawable.natsuki5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_natsuki);
        getSupportActionBar().setTitle("Natsuki");

        natsukisw = findViewById(R.id.imageSwitcher);
        next = findViewById(R.id.nextbtn);
        prev = findViewById(R.id.prevbtn);

        natsukisw.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(Natsuki.this);
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
                    natsukisw.setImageResource(images[position]);
                }if(position == 4){
                    next.setEnabled(false);
                    natsukisw.setImageResource(images[position]);
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
                    natsukisw.setImageResource(images[position]);
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
        inflater.inflate(R.menu.natsuki, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.natsukireddits:
                Intent intent = new Intent(this, NatsukiReddit.class);
                startActivity(intent);
                return true;

            case R.id.natsukigrids:
                Intent intent2 = new Intent(this, NatsukiGrid.class);
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