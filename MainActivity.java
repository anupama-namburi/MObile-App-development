package com.example.firebase_database;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


  EditText sid,sname,suniversity;
    ContentValues cv;
    DatabaseReference myRef;
    SaveData i;
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
        final FirebaseDatabase database = FirebaseDatabase.getInstance();

         myRef = database.getReference("Student");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            SaveData sd=new SaveData(sid.getText().toString(),sname.getText().toString(),suniversity.getText().toString());
            myRef.child("sid").setValue(sd);
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Query result=myRef.orderByChild("sid");
            result.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String uname=dataSnapshot.child("sid").child("sname").getValue(String.class);
                    Toast.makeText(getApplicationContext(),uname.toString(),Toast.LENGTH_LONG).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            }
        });





    }

}
