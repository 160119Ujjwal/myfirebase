package com.example.myfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myfirebase.Post.AdminPost;
import com.example.myfirebase.Register.StudentRegister;
import com.example.myfirebase.Student.StudentDashboard;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAdmin, btnRegisterStudent, btnStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdmin=findViewById(R.id.btnAdmin);
        btnRegisterStudent=findViewById(R.id.btnRegisterStudent);
        btnStudent=findViewById(R.id.btnStudent);

        btnAdmin.setOnClickListener(this);
        btnRegisterStudent.setOnClickListener(this);
        btnStudent.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v==btnAdmin){
            Intent intent = new Intent(this, AdminPost.class);
            startActivity(intent);
        }
        if (v==btnRegisterStudent){
            Intent intent = new Intent(this, StudentRegister.class);
            startActivity(intent);
        }
        if (v==btnStudent){
            Intent intent = new Intent(this, StudentDashboard.class);
            startActivity(intent);
        }
    }
}