package com.example.administrator.xrefreshviewdemo.mvp.entity.result;

/**
 * Description:
 * Date：2017/04/21 11:47
 * Author: wangyong
 */

public class FindPatientResult {


    /**
     * patientUser : {"id":14,"loginId":"patient_15876587133","password":"mingyizaixian123456789","phone":"15876587133","name":"lolOK哦","sex":"","birthday":631123200000,"headUrl":null,"visitState":"住院治疗","hospital":"","remarks":"好了","createtime":1493024918000,"updatetime":null,"easemobUUid":"97221750-28cd-11e7-8afd-43fabb58a443"}
     */

    private PatientUserEntity patientUser;

    public void setPatientUser(PatientUserEntity patientUser) {
        this.patientUser = patientUser;
    }

    public PatientUserEntity getPatientUser() {
        return patientUser;
    }

    public static class PatientUserEntity {
        /**
         * id : 14
         * loginId : patient_15876587133
         * password : mingyizaixian123456789
         * phone : 15876587133
         * name : lolOK哦
         * sex :
         * birthday : 631123200000
         * headUrl : null
         * visitState : 住院治疗
         * hospital :
         * remarks : 好了
         * createtime : 1493024918000
         * updatetime : null
         * easemobUUid : 97221750-28cd-11e7-8afd-43fabb58a443
         */

        private int id;
        private String loginId;
        private String password;
        private String phone;
        private String name;
        private String sex;
        private long birthday;
        private Object headUrl;
        private String visitState;
        private String hospital;
        private String remarks;
        private long createtime;
        private Object updatetime;
        private String easemobUUid;

        public void setId(int id) {
            this.id = id;
        }

        public void setLoginId(String loginId) {
            this.loginId = loginId;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public void setHeadUrl(Object headUrl) {
            this.headUrl = headUrl;
        }

        public void setVisitState(String visitState) {
            this.visitState = visitState;
        }

        public void setHospital(String hospital) {
            this.hospital = hospital;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public void setCreatetime(long createtime) {
            this.createtime = createtime;
        }

        public void setUpdatetime(Object updatetime) {
            this.updatetime = updatetime;
        }

        public void setEasemobUUid(String easemobUUid) {
            this.easemobUUid = easemobUUid;
        }

        public int getId() {
            return id;
        }

        public String getLoginId() {
            return loginId;
        }

        public String getPassword() {
            return password;
        }

        public String getPhone() {
            return phone;
        }

        public String getName() {
            return name;
        }

        public String getSex() {
            return sex;
        }

        public long getBirthday() {
            return birthday;
        }

        public Object getHeadUrl() {
            return headUrl;
        }

        public String getVisitState() {
            return visitState;
        }

        public String getHospital() {
            return hospital;
        }

        public String getRemarks() {
            return remarks;
        }

        public long getCreatetime() {
            return createtime;
        }

        public Object getUpdatetime() {
            return updatetime;
        }

        public String getEasemobUUid() {
            return easemobUUid;
        }
    }
}
