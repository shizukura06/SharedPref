package com.shizukura.sharedpref;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button plus, minus;
    int i = 0;
    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("sp",0);
        textView = findViewById(R.id.textView);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        i = sp.getInt("number",0);

        textView.setText(String.valueOf(i));
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = i - 7;
                textView.setText(String.valueOf(i));
                spEditor = getSharedPreferences("sp",0).edit();
                spEditor.putInt("number",i);
                spEditor.apply();
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = i + 7;
                textView.setText(String.valueOf(i));
                spEditor = getSharedPreferences("sp",0).edit();
                spEditor.putInt("number",i);
                spEditor.apply();
            }
        });
    }
}