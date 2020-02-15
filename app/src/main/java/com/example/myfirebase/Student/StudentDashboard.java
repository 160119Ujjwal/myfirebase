package com.example.myfirebase.Student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.myfirebase.Post.AdminPost;
import com.example.myfirebase.Post.Post;
import com.example.myfirebase.Post.StudentPost;
import com.example.myfirebase.R;
import com.example.myfirebase.adapter.Noticelist;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StudentDashboard extends AppCompatActivity implements View.OnClickListener {
    Button btnStudentAddNotice;
    ListView listViewNotice;
    List<Post> postList;

    DatabaseReference postRefrence;
    private Object noticeSnapshot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);
        postRefrence= FirebaseDatabase.getInstance().getReference("posts");

        listViewNotice=findViewById(R.id.listViewNotice);

        postList = new ArrayList<>();

        btnStudentAddNotice=findViewById(R.id.btnStudentAddNotice);

        btnStudentAddNotice.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        postRefrence.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                postList.clear();

                for (DataSnapshot noticeSnapshot : dataSnapshot.getChildren()){
                    Post post= noticeSnapshot.getValue(Post.class);

                    postList.add(post);
                }
                Noticelist adapter= new Noticelist(StudentDashboard.this, postList);
                listViewNotice.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v==btnStudentAddNotice){
            Intent intent = new Intent(this, StudentPost.class);
            startActivity(intent);
        }
    }
}
