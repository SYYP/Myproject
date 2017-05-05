package com.dalong.customviewstudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

/**
 * date : ${Data}
 * author:衣鹏宇(ypu)
 */

public class TwoActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two);
        TextView text_count= (TextView) findViewById(R.id.tv_count);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        text_count.setText(name);
    }
}
