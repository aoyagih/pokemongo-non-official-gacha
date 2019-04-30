package com.test.gacha;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class gacha extends AppCompatActivity {

    int p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gacha);
        //データの読み込み
        SharedPreferences preferences = getSharedPreferences("point",MODE_PRIVATE);
        p = preferences.getInt("p" , 0);
        ((TextView) findViewById(R.id.point)).setText("" + p);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //データの読み込み
        SharedPreferences preferences = getSharedPreferences("point",MODE_PRIVATE);
        p = preferences.getInt("p" , 0);
        ((TextView) findViewById(R.id.point)).setText("" + p);
    }

    public void pointget (View v){
        p += 100;
        ((TextView) findViewById(R.id.point)).setText("" + p);
    }

    public void dogacha (View v) {
        if (p >= 100) {
            p -= 100;
            ((TextView) findViewById(R.id.point)).setText("" + p);
            // データの保存
            SharedPreferences preferences = getSharedPreferences("point",MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("p",p);
            editor.commit();
            Intent intent = new Intent(this, video.class);          //intentにSetting.javaを代入(指定)
            startActivity(intent);                                   //intentを開く
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("注意")
                    .setMessage("ポイントが足りません")
                    .setNegativeButton("戻る",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            }
                    )
                    .show();

          }
        }
    public void doraregacha (View v) {
        if (p >= 300) {
            p -= 300;
            ((TextView) findViewById(R.id.point)).setText("" + p);
            // データの保存
            SharedPreferences preferences = getSharedPreferences("point",MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("p",p);
            editor.commit();
            Intent intent = new Intent(this, rarevideo.class);          //intentにSetting.javaを代入(指定)
            startActivity(intent);                                   //intentを開く
        }else{
            new AlertDialog.Builder(this)     //ポイント不足の時の処理
                    .setTitle("注意")
                    .setMessage("ポイントが足りません")
                    .setNegativeButton("戻る",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            }
                    )
                    .show();

        }
    }
    @Override
    protected void onPause() {
        super.onPause();

        // データの保存
        SharedPreferences preferences = getSharedPreferences("point",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("p",p);
        editor.commit();
    }
    }
