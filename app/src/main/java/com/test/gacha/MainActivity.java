package com.test.gacha;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int p;
    int[] IMAGES = {
            R.drawable.n001,
            R.drawable.n002,
            R.drawable.n003,
            R.drawable.n004,
            R.drawable.n005,
            R.drawable.n006,
            R.drawable.n007,
            R.drawable.n008,
            R.drawable.n009,
            R.drawable.n010,
            R.drawable.n011,
    };
    int UNKNOWN_IMAGE = R.drawable.unknown;

    String[] NAMES = {
            "フシギダネ",
            "フシギソウ",
            "フシギバナ",
            "ヒトカゲ",
            "リザード",
            "リザードン",
            "ゼニガメ",
            "カメール",
            "カメックス",
            "ピカチュウ",
            "ライチュウ"
    };
    String UNKNOWN_NAMES = "???";

    String[] NUMBERS = {
            "001",
            "002",
            "003",
            "004",
            "005",
            "006",
            "007",
            "008",
            "009",
            "010",
            "011"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListViewの作成
        int count=0;
        for(int i=0; i<IMAGES.length; i++){
            if(result.data[i] >= 1) count++;
        }
        int get_rate = (int) (count * 100 / IMAGES.length);
        //((TextView) findViewById(R.id.textView2)).setText("集めた数 "+ count + "/11匹　コンプ率 " + get_rate + "%");
        ListView listView = (ListView)findViewById(R.id.Listview);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        //BottomNavigationViewの作成
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        //最初の画面はHomeFragmentから表示する
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        /*//データの読み込み
        SharedPreferences preferences = getSharedPreferences("point",MODE_PRIVATE);
        p = preferences.getInt("p" , 0);
        ((TextView) findViewById(R.id.point)).setText("" + p);*/
    }
    /*@Override
    public void onStart() {
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
    }*/
    @Override
    protected void onPause() {
        super.onPause();

        // データの保存
        SharedPreferences preferences = getSharedPreferences("point",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("p",p);
        editor.commit();
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount(){
            return IMAGES.length;
        }

        @Override
        public Object getItem(int i){
            return null;
        }

        @Override
        public long getItemId(int i){
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup){
            view = getLayoutInflater().inflate(R.layout.customlayout, null);
            ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
            TextView textView_number = (TextView)view.findViewById(R.id.textView_number);
            TextView textView_name = (TextView)view.findViewById(R.id.textView_name);

            if(result.data[i] >= 1){
                imageView.setImageResource(IMAGES[i]);
                textView_name.setText(NAMES[i]);
            } else {
                imageView.setImageResource(UNKNOWN_IMAGE);
                textView_name.setText(UNKNOWN_NAMES);
            }
            textView_number.setText(NUMBERS[i]);

            return view;
        }
    }

    private  BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_description:
                            selectedFragment = new RateFragment();
                            break;
                        case R.id.nav_search:
                            selectedFragment = new PokedexFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }

            };

}
