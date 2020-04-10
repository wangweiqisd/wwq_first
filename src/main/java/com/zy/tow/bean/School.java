package com.zy.tow.bean;

public class School {
    private int id;
    private String school_name;
    private String school_describe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getSchool_describe() {
        return school_describe;
    }

    public void setSchool_describe(String school_describe) {
        this.school_describe = school_describe;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", school_name='" + school_name + '\'' +
                ", school_describe='" + school_describe + '\'' +
                '}';
    }
}
