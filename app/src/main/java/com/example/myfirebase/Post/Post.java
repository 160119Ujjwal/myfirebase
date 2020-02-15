package com.example.myfirebase.Post;

public class Post {
    String postId;
    String post;

    public Post(){

    }

    public Post(String postId, String post) {
        this.postId = postId;
        this.post = post;
    }

    public String getPostId() {
        return postId;
    }

    public String getPost() {
        return post;
    }
}
