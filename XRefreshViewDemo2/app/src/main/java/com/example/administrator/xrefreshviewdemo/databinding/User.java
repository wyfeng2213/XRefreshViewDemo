package com.example.administrator.xrefreshviewdemo.databinding;

/**
 * Description:
 * Date：2017/07/14 17:38
 * Author: wangyong
 */

public class User {
    private String userName;
    private String like;

    public User(String userName, String like) {
        this.userName = userName;
        this.like = like;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}
