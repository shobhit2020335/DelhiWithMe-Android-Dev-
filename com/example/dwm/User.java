package com.example.dwm;

public class User {

    private String name,email,password;
    private String profilephoto;

    public String getLiveindelhi() {
        return liveindelhi;
    }

    public void setLiveindelhi(String liveindelhi) {
        this.liveindelhi = liveindelhi;
    }

    private String liveindelhi;

    public User() {
    }

    public String getProfilephoto() {
        return profilephoto;
    }

    public void setProfilephoto(String profilephoto) {
        this.profilephoto = profilephoto;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
