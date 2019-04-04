package com.example.rpc_ms10306.mini_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class temp extends AppCompatActivity {

    ImageView img3;
    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference temp,refer,refer1;
    public static final String TAG = "Temperature";
    public TextView tem,showtemp;
    public Integer value1,value0;
    public String data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        firebaseDatabase = FirebaseDatabase.getInstance();

        temp = firebaseDatabase.getReference("temp");



        refer = firebaseDatabase.getReference();
        refer1 = firebaseDatabase.getReference();

        tem = (TextView)findViewById(R.id.txt3);
        showtemp = (TextView)findViewById(R.id.txt4);

        refer.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map)dataSnapshot.getValue();
                data = String.valueOf(map.get("Txttemp"));
                showtemp.setText(data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refer1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map)dataSnapshot.getValue();
                data = String.valueOf(map.get("temp"));
                tem.setText(data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        showtemp = (TextView)findViewById(R.id.txt4);
        temp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                value1 = dataSnapshot.getValue(Integer.class);
                if(value1==1){
                    showtemp.setText("HOT");
                    value0=0;
                }
                else {
                    showtemp.setText("COOL");
                    value0=1;
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        showtemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp.setValue(value0);
            }
        });





        ImageView img3 = (ImageView)findViewById(R.id.img3);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(temp.this,second.class);
                startActivity(intent);
                finish();


            }
        });
    }

}
