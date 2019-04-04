package com.example.rpc_ms10306.mini_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class index extends AppCompatActivity {

    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        Button btn1 = (Button)findViewById(R.id.btn1);
        username = (EditText)findViewById(R.id.editText);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(index.this,second.class);
                startActivity(intent);

                intent.putExtra("Username",username.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}
