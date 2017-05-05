package com.dalong.customviewstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获得资源id
     final TextView text_td= (TextView) findViewById(R.id.text_td);
        text_td.setText(DataString.StringData());
        text_td.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(MainActivity.this,TwoActivity.class);
                it.putExtra("name",DataString.StringData());
                startActivity(it);
            }
        });
    }
}
