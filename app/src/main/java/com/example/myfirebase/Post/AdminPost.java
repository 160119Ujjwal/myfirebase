package com.example.myfirebase.Post;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myfirebase.R;
import com.example.myfirebase.adapter.Noticelist;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdminPost extends AppCompatActivity {

    EditText txtPostNotice;
    Button btnAddNotice;
    ListView listViewNotice;
    List<Post> postList;

    DatabaseReference postRefrence;
    private Object noticeSnapshot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_post);
        postRefrence= FirebaseDatabase.getInstance().getReference("posts");

        txtPostNotice=findViewById(R.id.txtPostNotice);
        btnAddNotice=findViewById(R.id.btnAddNotice);
        listViewNotice=findViewById(R.id.listViewNotice);

        postList = new ArrayList<>();

        btnAddNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotice();
            }
        });
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
                Noticelist adapter= new Noticelist(AdminPost.this, postList);
                listViewNotice.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
