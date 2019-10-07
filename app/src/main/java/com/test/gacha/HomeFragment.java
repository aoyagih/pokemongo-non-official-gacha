package com.test.gacha;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;

public class HomeFragment extends Fragment {

    int p;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container);

        //データの読み込み
        SharedPreferences preferences = getActivity().getSharedPreferences("point", MODE_PRIVATE);
        p = preferences.getInt("p" , 0);
        ((TextView) v.findViewById(R.id.point)).setText("" + p);

        ((Button) v.findViewById(R.id.pointup)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        p += 100;
                        ((TextView) v.findViewById(R.id.point)).setText("" + p);
                    }
                }
        );

        ((Button) v.findViewById(R.id.doGacha)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (p >= 100) {
                            p -= 100;
                            ((TextView) v.findViewById(R.id.point)).setText("" + p);
                            // データの保存
                            SharedPreferences preferences = getActivity().getSharedPreferences("point", MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putInt("p", p);
                            editor.commit();
                            Intent intent = new Intent(getActivity(), video.class);          //intentにSetting.javaを代入(指定)
                            startActivity(intent);                                   //intentを開く
                        }else{
                            new AlertDialog.Builder(getContext())
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
                });

        ((Button) v.findViewById(R.id.doRareGacha)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (p >= 300) {
                            p -= 300;
                            ((TextView) v.findViewById(R.id.point)).setText("" + p);
                            // データの保存
                            SharedPreferences preferences = getActivity().getSharedPreferences("point", MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putInt("p",p);
                            editor.commit();
                            Intent intent = new Intent(getActivity(), rarevideo.class);          //intentにSetting.javaを代入(指定)
                            startActivity(intent);                                   //intentを開く
                        }else{
                            new AlertDialog.Builder(getContext())     //ポイント不足の時の処理
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
                });

        return v;
    }
}
