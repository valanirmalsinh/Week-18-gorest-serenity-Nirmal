package com.gorest.model;

public class PostsPojo {
    private String user_Id;
    private String title;
    private String body;

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static PostsPojo getPostPojo(String user_Id, String title, String body) {
        PostsPojo postsPojo = new PostsPojo();
        postsPojo.setUser_Id(user_Id);
        postsPojo.setTitle(title);
        postsPojo.setBody(body);
        return postsPojo;
    }
}