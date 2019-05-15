package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

import static com.example.myapplication.util.FileCache.getTimeCache;
import static com.example.myapplication.util.FileCache.writeTimeCache;
import static com.example.myapplication.util.TimeUtils.Date2String;
import static com.example.myapplication.util.TimeUtils.getnext;
import static com.example.myapplication.util.TimeUtils.isDateOneBigger;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView tv_hello;
    private Date today=new Date();
    private String before3day,latestTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniView();
        iniDate();
    }

    private void iniDate() {
        tv_hello.setText(Date2String(today,""));
        getDate();
        setDate();
    }

    private void setDate() {
        writeTimeCache(this,Date2String(today,""));
    }

    private void getDate() {
        latestTime = getTimeCache(this);
        before3day =  getnext(-4);
    }

    private void iniView() {
        String a = "aqwertyui";
        a = a.substring(0,(a.length()-2));
        System.out.println(a);
        btn = findViewById(R.id.btn);
        tv_hello = findViewById(R.id.tv_hello);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(latestTime==null){
                    tv_hello.setText("欢迎初次使用");
                }else{
                    if(isDateOneBigger(before3day,latestTime)){
                        tv_hello.setText("欢迎经常使用");
                    }else{
                        tv_hello.setText("好久不见，欢迎再次使用");
                    }
                }

            }
        });
    }
}
