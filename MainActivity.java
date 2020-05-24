package com.example.firebase_database;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


  EditText sid,sname,suniversity;
  TextView tv;
    ContentValues cv;
    DatabaseReference myRef;
    SaveData i;
    String userenterid;
  Button save, read;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sid=findViewById(R.id.editText);
        sname=findViewById(R.id.editText3);
        suniversity=findViewById(R.id.editText4);
        save=findViewById(R.id.button);
        read=findViewById(R.id.button2);
        tv=findViewById(R.id.textView);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();

         myRef = database.getReference("Student");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            SaveData sd=new SaveData(sid.getText().toString(),sname.getText().toString(),suniversity.getText().toString());
            myRef.child(sid.getText().toString()).setValue(sd);
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userenterid=sid.getText().toString();
            Query result=myRef.orderByChild("sid").equalTo(userenterid);
            result.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String uname=dataSnapshot.child(userenterid).child("sid").getValue(String.class);
                    String id=dataSnapshot.child(userenterid).child("sname").getValue(String.class);
                    String uni=dataSnapshot.child(userenterid).child("suniversity").getValue(String.class);
                    StringBuilder sb=new StringBuilder();
                    sb.append("student id:"+id+"\n");
                    sb.append("student Name:"+uname+"\n");
                    sb.append("University:"+uni+"\n");
                    tv.setText(sb);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            }
        });





    }

}
