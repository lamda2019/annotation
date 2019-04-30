package com.wsc.dao;

import org.springframework.stereotype.Repository;

@Repository("personDao")
public class PersonDao {
    private String lable = "1";

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "PersonDao [lable=" + lable + "]";
    }

}