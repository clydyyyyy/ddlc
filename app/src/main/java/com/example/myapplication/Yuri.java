package com.example.myapplication;

import androidx.annotation.ColorInt;
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

public class Yuri extends AppCompatActivity {

    private ImageSwitcher yurisw;
    private Button next,prev;
    private int position = 0;
    private int[] images = {R.drawable.yuri1,R.drawable.yuri2,R.drawable.yuri3,R.drawable.yuri4,R.drawable.yuri5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuri);
        getSupportActionBar().setTitle("Yuri");
        yurisw = findViewById(R.id.imageSwitcher);
        next = findViewById(R.id.nextbtn);
        prev = findViewById(R.id.prevbtn);

        yurisw.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(Yuri.this);
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
                    yurisw.setImageResource(images[position]);
                }if(position == 4){
                    next.setEnabled(false);
                    yurisw.setImageResource(images[position]);
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
                    yurisw.setImageResource(images[position]);
                }if(position==0){
                    prev.setEnabled(false);
                }
                next.setEnabled(false);


            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.yuri, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.yurireddits:
                Intent intent = new Intent(this, YuriReddit.class);
                startActivity(intent);
                return true;

            case R.id.yurigrids:
                Intent intent2 = new Intent(this, YuriGrid.class);
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