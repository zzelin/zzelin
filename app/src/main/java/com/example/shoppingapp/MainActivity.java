package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    String sm="",ry="",sp="";
    Integer smq=0,ryq=0,spq=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button SM = (Button) findViewById(R.id.SM);
        SM.setOnClickListener(this::onClick);
        Button RY = (Button) findViewById(R.id.RY);
        RY.setOnClickListener(this::onClick);
        Button SP = (Button) findViewById(R.id.SP);
        SP.setOnClickListener(this::onClick);
        Button QD = (Button) findViewById(R.id.QD);
        QD.setOnClickListener(this::onClick);
    }

//    Intent intent=getIntent();
//    Bundle bundle = intent.getExtras();

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.SM:
                Intent ISM =new Intent(MainActivity.this,SMActivity.class);
                startActivityForResult(ISM,1);
                break;
            case R.id.RY:
                Intent IRY =new Intent(MainActivity.this,RYActivity.class);
                startActivityForResult(IRY,2);
                break;
            case R.id.SP:
                Intent ISP =new Intent(MainActivity.this,SPActivity.class);
                startActivityForResult(ISP,3);
                break;
            case R.id.QD:
                Intent IQD =new Intent(MainActivity.this,QDActivity.class);
                Bundle IQDB = new Bundle();
                IQDB.putCharSequence("sm",sm);
                IQDB.putCharSequence("ry",ry);
                IQDB.putCharSequence("sp",sp);
                IQDB.putInt("smq",smq);
                IQDB.putInt("ryq",ryq);
                IQDB.putInt("spq",spq);
                IQD.putExtras(IQDB);
                startActivity(IQD);
                break;
        }
    }

    //读取返回信息
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case  1:
                if (resultCode==RESULT_OK){
                         sm=data.getBundleExtra("bundle").getString("name");
                         smq=data.getBundleExtra("bundle").getInt("total");
//                    Toast.makeText(MainActivity.this, sm, Toast.LENGTH_SHORT).show();
//                    Log.i("FirstActivity",s);
                }
                break;
            case  2:
                if (resultCode==RESULT_OK){
                    ry=data.getBundleExtra("bundle").getString("name");
                    ryq=data.getBundleExtra("bundle").getInt("total");
//                    Toast.makeText(MainActivity.this, ry, Toast.LENGTH_SHORT).show();
//                    Log.i("FirstActivity",s);
                }
                break;
            case  3:
                if (resultCode==RESULT_OK){
                    sp=data.getBundleExtra("bundle").getString("name");
                    spq=data.getBundleExtra("bundle").getInt("total");
//                    Toast.makeText(MainActivity.this, sp, Toast.LENGTH_SHORT).show();
//                    Log.i("FirstActivity",s);
                }
                break;
        }
    }


}
