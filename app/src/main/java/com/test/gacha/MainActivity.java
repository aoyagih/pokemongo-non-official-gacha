package com.test.gacha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //ガチャを引く
    public void gacha (View v){
        Intent intent = new Intent(this,gacha.class);
        startActivity(intent);
    }
    //図鑑画面へ移動
    public void picturebook (View v){
        Intent intent = new Intent(this,picturebook.class);
        startActivity(intent);
    }

}
