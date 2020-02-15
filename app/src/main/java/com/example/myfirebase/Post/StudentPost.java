package com.example.myfirebase.Post;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfirebase.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentPost extends AppCompatActivity {
    EditText txtPostNotice;
    Button btnAddNotice;
    DatabaseReference postRefrence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_post);
        postRefrence= FirebaseDatabase.getInstance().getReference("posts");

        txtPostNotice=findViewById(R.id.txtPostNotice);
        btnAddNotice=findViewById(R.id.btnAddNotice);


        btnAddNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotice();
            }
        });

    }

    private void addNotice() {
        String post=txtPostNotice.getText().toString().trim();
        if (!TextUtils.isEmpty(post)){
            String postid= postRefrence.push().getKey();
            Post postnotice=new Post(postid, post);
            postRefrence.child(postid).setValue(postnotice);
            Toast.makeText(this,"post added",Toast.LENGTH_LONG).show();

        }
        else {
            Toast.makeText(this,"Write Notice", Toast.LENGTH_LONG).show();
            return;
        }
    }
}
