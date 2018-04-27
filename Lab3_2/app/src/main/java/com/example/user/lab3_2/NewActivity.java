package com.example.user.lab3_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by user on 2018-04-26.
 */

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        TextView name, sex, submit;
        String r_name, r_sex, r_submit;
        Button btn = findViewById(R.id.back);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        name = findViewById(R.id.r_name);
        sex = findViewById(R.id.r_sex);
        submit = findViewById(R.id.r_receive);

        r_name = bundle.getString("name");
        r_sex = bundle.getString("sex");
        r_submit = bundle.getString("submit");

        name.setText(r_name);
        sex.setText(r_sex);
        submit.setText(r_submit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
