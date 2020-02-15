package com.example.myfirebase.Register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myfirebase.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentRegister extends AppCompatActivity {
    EditText editTextName, editTextEmail, editTextPassword, editTextAddress ,editTextContact;
    Button btnRegister;
    DatabaseReference databasestudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_register);

        databasestudent= FirebaseDatabase.getInstance().getReference("students");

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextContact = findViewById(R.id.editTextContact);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudent();
            }
        });

    }

     private void addStudent() {
                String name = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String address = editTextAddress.getText().toString().trim();
                String contact = editTextContact.getText().toString().trim();

                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(StudentRegister.this, "Enter Your Name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(StudentRegister.this, "Enter Your Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(StudentRegister.this, "Enter Your Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    editTextPassword.setError(getString(R.string.input_error_password_length));
                    editTextPassword.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(address)) {
                    Toast.makeText(StudentRegister.this, "Enter Your address", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(contact)) {
                    Toast.makeText(StudentRegister.this, "Enter Your Contact Number", Toast.LENGTH_SHORT).show();
                }

                if (contact.length() != 10) {
                    editTextContact.setError(getString(R.string.input_error_phone_invalid));
                    editTextContact.requestFocus();
                    return;
                }

                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(address) && !TextUtils.isEmpty(contact)) {
                    String studentid = databasestudent.push().getKey();
                    Student postnotice = new Student(studentid, name, email, address, contact);
                    databasestudent.child(studentid).setValue(postnotice);
                    Toast.makeText(StudentRegister.this, "Added", Toast.LENGTH_SHORT).show();
                }
            }
}
