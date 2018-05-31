package com.example.user.lab6_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button add, delete;
    EditText name, sn;
    SQLiteDatabase db;
    MyDBHelper helper;
    String[] str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        sn = findViewById(R.id.sn);

        add = findViewById(R.id.add);
        delete = findViewById(R.id.delete);
        listView = findViewById(R.id.list);
        helper = new MyDBHelper(this, "stdt.db", null, 1);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1, str2;
                str1 = name.getText().toString();
                str2 = sn.getText().toString();
                if (TextUtils.isEmpty(str1) && TextUtils.isEmpty(str2)) {
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(str2)) {
                    Toast.makeText(getApplicationContext(), "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                insert(str1, str2);
                invalidate();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = name.getText().toString();
                if (TextUtils.isEmpty(str1)) {
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                delete(str1);
                invalidate();
            }
        });
    }

    public void insert(String name, String sn) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("sn", sn);
        db.insert("student", null, values);
    }

    public void delete(String name) {
        db = helper.getWritableDatabase();
        db.delete("student", "name=?", new String[]{name});
    }

    public class MyDBHelper extends SQLiteOpenHelper {
        public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int v) {
            super(context, name, factory, v);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = "create table student (" +
                    "name text," +
                    "sn text);";
            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String sql = "drop table if exists student";
            db.execSQL(sql);
            onCreate(db);
        }
    }

    public void select() {
        db = helper.getReadableDatabase();
        Cursor c = db.query("student", null, null, null, null, null, null);
        str = new String[c.getCount()];
        int count = 0;
        while (c.moveToNext()) {
            str[count] = c.getString(c.getColumnIndex("name"))
                    + " " + c.getString(c.getColumnIndex("sn"));
            count++;
        }
        c.close();
    }

    private void invalidate() {
        select();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
        listView.setAdapter(adapter);
    }

}