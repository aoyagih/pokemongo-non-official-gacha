package com.test.gacha;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.VideoView;

import java.util.Random;

public class rarevideo extends AppCompatActivity {

    static int n;  //各ポケモンに割り振られた番号

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Random rand = new Random();
        int r = rand.nextInt(10) + 1;     //乱数生成

        if(r <= 2){
            n = 8;
        }else if(r <= 4){
            n = 9;
        }else if(r <= 6){
            n = 10;
        }else if(r == 7){
            n = 11;
        }else if(r == 8){
            n = 12;
        }else if(r == 9){
            n = 13;
        }else{
            n = 14;
        }

        // ID取得
        VideoView v = findViewById(R.id.videoView);

        // 動画の指定（動画の読込み）
        if(n <= 10) {
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
