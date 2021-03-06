package com.example.user.lab5_2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;
    String list = "";

    int input = 0;
    int result = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.eT);
        button = findViewById(R.id.btn);
        textView = findViewById(R.id.tV2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CalculateTask().execute();
            }
        });
    }

    private class CalculateTask extends AsyncTask<Void, Integer, Void> {
        @Override
        protected void onPreExecute() {
            input = Integer.parseInt(editText.getText().toString());
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = input; i >= 0; --i) {
                try {
                    Thread.sleep(500);
                    if (i != 0) {
                        publishProgress(i);
                        result *= i;
                    }
                } catch (Exception e) {
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            list = list + Integer.toString(values[0].intValue()) + " ";
            textView.setText(list);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            textView.setText(list + "\n= " + result);
        }
    }
}