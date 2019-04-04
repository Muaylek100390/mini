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

public class dis extends AppCompatActivity {

    ImageView img4;

    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference dis,showdis,refer,refer1;
    public static final String TAG = "DISTANCE";
    public String Data;
    public Integer Value1,Value2;
    public TextView disT,showdis1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dis);

        firebaseDatabase = FirebaseDatabase.getInstance();

        dis = firebaseDatabase.getReference("Duration");
        showdis = firebaseDatabase.getReference("Txtdis");

        refer = firebaseDatabase.getReference();
        refer1 = firebaseDatabase.getReference();

        disT = (TextView)findViewById(R.id.txt6);
        showdis1 = (TextView)findViewById(R.id.txt);

        refer.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map)dataSnapshot.getValue();
                Data = String.valueOf(map.get("Txtdis"));
                showdis1.setText(Data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refer1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map)dataSnapshot.getValue();
                Data = String.valueOf(map.get("Duration"));
                disT.setText(Data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        showdis1 = (TextView)findViewById(R.id.txt);
        dis.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Value1 = dataSnapshot.getValue(Integer.class);
                if(Value1==1){
                    showdis1.setText("DANGER");
                    Value2=0;
                }
                else {
                    showdis1.setText("SAFE");
                    Value2=1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        showdis1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis.setValue(Value2);
            }
        });


        ImageView img4 = (ImageView)findViewById(R.id.img4);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dis.this,second.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
