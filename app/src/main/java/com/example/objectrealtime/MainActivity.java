package com.example.objectrealtime;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btnpushdata);
        Button btngetdata = findViewById(R.id.btngetdata);
        textView = findViewById(R.id.txtketqua);
        Button button2 = findViewById(R.id.btnxoadata);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = database.getReference("massage");
                databaseReference.removeValue(new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        Toast.makeText(MainActivity.this, "delete thành công", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = database.getReference("object_users");
                user user = new user(1 , "tien" , new job(1 , "job1"));


                //food
                DatabaseReference databaseReference1 = database.getReference("object_food");
                Food food = new Food(R.drawable.burger , "burger " , 13.0 , R.drawable.plus_circle);


                databaseReference.setValue(user, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        Toast.makeText(MainActivity.this, "push thanh công", Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });
        btngetdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readdatabase();
            }
        });
    }
    private void readdatabase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference("object_users");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                user user =  snapshot.getValue(user.class);
                textView.setText(user.toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}