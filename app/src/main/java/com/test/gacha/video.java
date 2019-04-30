package com.test.gacha;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.Random;

public class video extends AppCompatActivity {

    static int n;  //各ポケモンに割り振られた番号

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Random rand = new Random();
        int r = rand.nextInt(1000) + 1;     //乱数生成

        if(r <= 200){
            n = 0;
        }else if(r <= 203){
            n = 1;
        }else if(r <= 403){
            n = 2;
        }else if(r <= 406){
            n = 3;
        }else if(r <= 606){
            n = 4;
        }else if(r <= 609){
            n = 5;
        }else if(r <= 689){
            n = 6;
        }else if(690 == r){
            n = 7;
        }else if(r <= 770){
            n = 8;
        }else if(r <= 850){
            n = 9;
        }else if(r <= 930){
            n = 10;
        }else if(r <= 950){
            n = 11;
        }else if(r <= 970){
            n = 12;
        }else if(r <= 990){
            n = 13;
        }else{
            n = 14;
        }

        // ID取得
        VideoView v = findViewById(R.id.videoView);

        // 動画の指定（動画の読込み）
        if(n <= 7) {
            v.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.common));
        }else if(n <= 10) {
            v.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.rare));
        }else{
            v.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.superrare));
        }

        // 再生スタート
        v.start();

    }

    //　画面タッチ時の動作
    public boolean onTouchEvent(MotionEvent event) {
        Intent intent = new Intent(this, result.class);
        intent.putExtra("number" , n);     //nを移動させる
        startActivity(intent);
        finish();   //結果画面へ遷移
        return super.onTouchEvent(event);
    }

}
