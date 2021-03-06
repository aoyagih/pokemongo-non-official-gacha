package com.test.gacha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class picturebook extends AppCompatActivity {

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
        setContentView(R.layout.activity_picturebook);

        int count=0;
        for(int i=0; i<IMAGES.length; i++){
            if(result.data[i] >= 1) count++;
        }
        int get_rate = (int) (count * 100 / IMAGES.length);

        ((TextView) findViewById(R.id.textView2)).setText("集めた数 "+ count + "/11匹　コンプ率 " + get_rate + "%");

        ListView listView = (ListView)findViewById(R.id.Listview);

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

    }
    public void return_to_menu (View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    class CustomAdapter extends BaseAdapter{

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
}
