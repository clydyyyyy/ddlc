package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {
    ImageButton imageButton1,imageButton2,imageButton3,imageButton4;
    private MediaPlayer mplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("Doki Doki Literature Club");

        mplayer = MediaPlayer.create(Home.this,R.raw.open);
        mplayer.setLooping(true);
        mplayer.start();

        imageButton1 = (ImageButton) findViewById(R.id.sayoribtn);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Opensayori();
            }
        });

        imageButton2 = (ImageButton) findViewById(R.id.yuribtn);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Openyuri();
            }
        });

        imageButton3 = (ImageButton) findViewById(R.id.natsukibtn);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Opennatsuki();
            }
        });

        imageButton4 = (ImageButton) findViewById(R.id.monikabtn);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Openmonika();
            }
        });
    }

    public void Opensayori(){
        Intent intent = new Intent(this, Sayori.class);
        startActivity(intent);
    }

    public void Openyuri(){
        Intent intent = new Intent(this, Yuri.class);
        startActivity(intent);
    }

    public void Opennatsuki(){
        Intent intent = new Intent(this, Natsuki.class);
        startActivity(intent);
    }

    public void Openmonika(){
        Intent intent = new Intent(this, Monika.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.web, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.toWeb:
                Intent intent = new Intent(this, Web.class);
                startActivity(intent);
                return true;

            case R.id.toVideo:
                Intent intent2 = new Intent(this, DDLC_Plus.class);
                startActivity(intent2);
                return true;

            case R.id.exit:
                finish();
                System.exit(0);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onPause() {
        mplayer.pause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        mplayer.start();
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        mplayer.stop();
        mplayer.release();
        super.onDestroy();

    }
}