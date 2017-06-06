package com.homechart.app.tablayoutdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.homechart.app.tablayoutdemo.onestyle.OneStyleActivity;
import com.homechart.app.tablayoutdemo.twostyle.TwoStyleActivity;

/**
 * Created by gumenghao on 17/6/6.
 */

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        findViewById(R.id.bt_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, OneStyleActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.bt_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, TwoStyleActivity.class);
                startActivity(intent);
            }
        });

    }

}
