package com.example.administrator.xrefreshviewdemo.mvp.entity.api;

/**
 * Description:
 * Date：2017/04/28 16:56
 * Author: wangyong
 */

public class CommonData {

    /**
     * phone : 15876587110
     * userName :
     * userRole : paint
     * deviceToken :
     * systemtype : android6.0.1
     * model : Xiaomi Redmi 4X
     * packageVesion : 1.0
     * session :
     */

    private String phone;
    private String userName;
    private String userRole;
    private String deviceToken;
    private String systemtype;


    public CommonData() {
    }

    public CommonData(String phone, String userName, String userRole, String deviceToken, String systemtype, String model, String packageVesion, String session) {
        this.phone = phone;
        this.userName = userName;
        this.userRole = userRole;
        this.deviceToken = deviceToken;
        this.systemtype = systemtype;
        this.model = model;
        this.packageVesion = packageVesion;
        this.session = session;
    }

    private String model;
    private String packageVesion;
    private String session;


    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public void setSystemtype(String systemtype) {
        this.systemtype = systemtype;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPackageVesion(String packageVesion) {
        this.packageVesion = packageVesion;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getPhone() {
        return phone;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public String getSystemtype() {
        return systemtype;
    }

    public String getModel() {
        return model;
    }

    public String getPackageVesion() {
        return packageVesion;
    }

    public String getSession() {
        return session;
    }
}
