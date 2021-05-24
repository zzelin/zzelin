package com.example.shoppingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class RYActivity extends Activity {
    ListView listView;
    int size = 4;
    String[] namelist = new String[size];
    Integer[] pricelist = new Integer[size];
    Integer[] numberlist = new Integer[size];
    String buffer = "";
    Integer total=0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ryactivity);
        initView();

        Button btn = findViewById(R.id.back3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button btn1 = findViewById(R.id.save3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IRY= new Intent();
                Bundle bundle = new Bundle();
                bundle.putCharSequence("name", buffer);
                bundle.putInt("total",total);
                IRY.putExtra("bundle",bundle);
                setResult(RESULT_OK,IRY);
                finish();
            }
        });

    }

    private void initView() {
        ListView listview = (ListView) findViewById(R.id.rylistview); // 获取列表视图
        // 创建一个list集合
        listview.setAdapter(new RYAdapter(this));
    }

    public void saveEditData(int position, String str, String name,String price1) {
        Toast.makeText(this, name + "----" + position, Toast.LENGTH_LONG).show();
        buffer = "";
        int number = Integer.parseInt(str);
        int price = Integer.parseInt(price1);
        namelist[position] = name;
        pricelist[position]=price;
        numberlist[position]=number;
        for (int i = 0; i < size; i++) {
            if (numberlist[i] != null && numberlist[i]!=0) {
                buffer += namelist[i]+"---"
                        +pricelist[i]+"---"
                        +numberlist[i]+"\n";
                total+=(pricelist[i]*numberlist[i]);
            }
        }
    }
}