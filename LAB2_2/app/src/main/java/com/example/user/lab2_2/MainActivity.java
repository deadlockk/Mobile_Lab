package com.example.user.lab2_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Url;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Url = (EditText)findViewById(R.id.editText1);
        nextBtn = (Button)findViewById(R.id.next);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myUrl = Url.getText().toString();
                Intent intent = new Intent(getApplicationContext(),NewActivity.class);
                intent.putExtra("Url",myUrl);
                startActivity(intent);
            }
        });

    }
}
