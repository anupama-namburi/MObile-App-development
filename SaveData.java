package com.example.firebase_database;

class SaveData {
    String sid,sname,suniversity;
    SaveData(String sid,String sname,String suniversity)
    {
        this.sid=sid;
        this.sname=sname;
        this.suniversity=suniversity;
    }
    SaveData()
    {

    }

    public String getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public String getSuniversity() {
        return suniversity;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setSuniversity(String suniversity) {
        this.suniversity = suniversity;
    }
}
