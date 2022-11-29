package com.example.dwm;

public class comment {
    private String commentbody;
    private String commentedby;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommentedbyimg() {
        return commentedbyimg;
    }

    public void setCommentedbyimg(String commentedbyimg) {
        this.commentedbyimg = commentedbyimg;
    }

    private String commentedbyimg;
    private long commentedat;

    public comment() {
    }

    public String getCommentbody() {
        return commentbody;
    }

    public void setCommentbody(String commentbody) {
        this.commentbody = commentbody;
    }

    public String getCommentedby() {
        return commentedby;
    }

    public void setCommentedby(String commentedby) {
        this.commentedby = commentedby;
    }

    public long getCommentedat() {
        return commentedat;
    }

    public void setCommentedat(long commentedat) {
        this.commentedat = commentedat;
    }
}
