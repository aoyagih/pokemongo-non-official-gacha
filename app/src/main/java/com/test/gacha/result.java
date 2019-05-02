package com.test.gacha;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class result extends AppCompatActivity {

    //ポケモンの名前
    String[] pokemon = {
            "フシギダネ",
            "フシギダネ",
            "ヒトカゲ",
            "ヒトカゲ",
            "ゼニガメ",
            "ゼニガメ",
            "ピカチュウ",
            "ピカチュウ",
            "フシギソウ",
            "リザード",
            "カメール",
            "フシギバナ",
            "リザードン",
            "カメックス",
            "ライチュウ"
    };

    //画像データ
    int[] pokemonimg = {
            R.drawable.n001,
            R.drawable.s001,
            R.drawable.n004,
            R.drawable.s004,
            R.drawable.n007,
            R.drawable.s007,
            R.drawable.n010,
            R.drawable.s010,
            R.drawable.n002,
            R.drawable.n005,
            R.drawable.n008,
            R.drawable.n003,
            R.drawable.n006,
            R.drawable.n009,
            R.drawable.n011,
    };

    static int[] data = {0,0,0,0,0,0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        int number = getIntent().getIntExtra("number", 0);
        ((TextView) findViewById(R.id.pokemon)).setText(pokemon[number]);
        ((ImageView)findViewById(R.id.picture)).setImageResource(pokemonimg[number]);
        switch(number){
            case 0:
            case 1:
                data[0]++;
                break;
            case 2:
            case 3:
                data[3]++;
                break;
            case 4:
            case 5:
                data[6]++;
                break;
            case 6:
            case 7:
                data[9]++;
                break;
            case 8:
                data[1]++;
                break;
            case 9:
                data[4]++;
                break;
            case 10:
                data[7]++;
                break;
            case 11:
                data[2]++;
                break;
            case 12:
                data[5]++;
                break;
            case 13:
                data[8]++;
                break;
            case 14:
                data[10]++;
                break;
        }
        /* データの保存
        SharedPreferences preferences = getSharedPreferences("data",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("data", data[]);
        editor.commit();*/
    }

    //図鑑画面へ
    public void topicturebook (View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    //もう一度ガチャを引く
    public void gachaagain (View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
