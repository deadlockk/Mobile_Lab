package com.example.user.lab1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText edit_name;
    public Button btn_print;
    public Button btn_clear;
    public TextView view_print;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    //View 객체 참조
    public void init() {
        edit_name = (EditText) findViewById(R.id.editText);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_print = (Button) findViewById(R.id.btn_print);
        view_print = (TextView) findViewById(R.id.textView);
    }
    //clear 클릭 시 EditText 부분을 초기화시키고 TextView 부분에 contents를 다시 띄워준다
    public void clearClicked(View v) {
        edit_name.setText("");
        view_print.setText("contents");
    }
    //print 클릭 시 EditText 객체에 입력된 text를 얻어와서 String 형태로 저장하여 TextView 부분에 띄워준다
    public void printClicked(View v) {
        String text = edit_name.getText().toString();
        view_print.setText(text);
    }
}
