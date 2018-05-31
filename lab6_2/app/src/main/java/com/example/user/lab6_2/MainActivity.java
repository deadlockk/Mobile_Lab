package com.example.user.lab6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText num, name;
    Button save, read, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        num = findViewById(R.id.sn);
        name = findViewById(R.id.name);

        read = findViewById(R.id.read);
        save = findViewById(R.id.save);
        reset = findViewById(R.id.reset);

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num.setText(sharedPreferences.getString("num", null));
                name.setText(sharedPreferences.getString("name",null));
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1, str2;
                str1 = num.getText().toString();
                str2 = name.getText().toString();
                editor = sharedPreferences.edit();
                if(TextUtils.isEmpty(str1) || TextUtils.isEmpty(str2)){
                    return;
                }
                editor.putString("num",str1);
                editor.putString("name", str2);
                editor.commit();

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num.setText("");
                name.setText("");
            }
        });
    }
}