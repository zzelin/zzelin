package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;


public class QDActivity extends AppCompatActivity {

    String namebuffer = "";
    Integer total=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qdactivity);

        Intent IQD=getIntent();
        Bundle bundle = IQD.getExtras();
        TextView sm = (TextView) findViewById(R.id.smqd);
        sm.setText(bundle.getString("sm"));
        TextView ry = (TextView) findViewById(R.id.ryqd);
        ry.setText(bundle.getString("ry"));
        TextView sp = (TextView) findViewById(R.id.spqd);
        sp.setText(bundle.getString("sp"));
        TextView zj = (TextView) findViewById(R.id.zj);
        total=bundle.getInt("smq")+bundle.getInt("ryq")+bundle.getInt("spq");
        zj.setText("总金额为---¥"+total.toString()+"元");

        Button btn=(Button)findViewById(R.id.back4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}