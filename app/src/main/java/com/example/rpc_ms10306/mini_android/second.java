package com.example.rpc_ms10306.mini_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class second extends AppCompatActivity {

    TextView username;
    ImageView img1,img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ImageView img1 = (ImageView)findViewById(R.id.img1);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(second.this,temp.class);
                startActivity(intent);
                finish();
            }
        });

        ImageView img2 = (ImageView)findViewById(R.id.img2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(second.this,dis.class);
                startActivity(intent);
                finish();
            }
        });

        username = (TextView)findViewById(R.id.txt3);

        username.setText(getIntent().getStringExtra("Username"));

    }

}
