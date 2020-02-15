package com.example.myfirebase.Register;

public class Student {
    String studentid;
    String studentname;
    String studentemail;
    String studentaddress;
    String studentcontact;

    public Student(){

    }
    public Student(String studentid, String studentname,String studentemail, String studentaddress, String studentcontact) {
        this.studentid = studentid;
        this.studentname = studentname;
        this.studentemail=studentemail;
        this.studentaddress=studentaddress;
        this.studentcontact = studentcontact;
    }

    public String getStudentid() {
        return studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public String getStudentemail() {
        return studentemail;
    }

    public String getStudentaddress() {
        return studentaddress;
    }

    public String getStudentcontact() {
        return studentcontact;
    }
}
