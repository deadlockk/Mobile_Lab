package com.example.user.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    CheckBox checkBoxSms, checkBoxEmail;
    RadioButton[] sex = new RadioButton[2];
    RadioGroup radioGroupSex;
    Button register;
    String submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.name);
        sex[0] = findViewById(R.id.man);
        sex[1] = findViewById(R.id.woman);
        radioGroupSex = findViewById(R.id.sex);
        checkBoxSms = findViewById(R.id.sms);
        checkBoxEmail = findViewById(R.id.email);
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(editText.getText())) {
                    Toast.makeText(getApplicationContext(), "이름을 입력하세요", Toast.LENGTH_LONG).show();
                    return;
                }else if(!(sex[0].isChecked() || sex[1].isChecked()) || !(checkBoxEmail.isChecked() || checkBoxSms.isChecked())) {
                    return;
                }
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", editText.getText().toString());
                if(sex[0].isChecked())
                    bundle.putString("sex", "남");
                else
                    bundle.putString("sex", "여");
                if(checkBoxSms.isChecked() && checkBoxEmail.isChecked())
                    submit += "SMS & e-amil";
                else if(checkBoxEmail.isChecked())
                    submit += "e-mail";
                else
                    submit += "SMS";
                bundle.putString("submit", submit);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    void init(){
        editText.setText("");
        submit = "";
        radioGroupSex.clearCheck();
        checkBoxEmail.setChecked(false);
        checkBoxSms.setChecked(false);
    }
}