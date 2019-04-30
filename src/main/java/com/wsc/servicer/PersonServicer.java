package com.wsc.servicer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wsc.dao.PersonDao;

@Service
public class PersonServicer {
    @Qualifier("personDao2")
    @Autowired
    private PersonDao personDao;

    public void print(){
        System.out.println(personDao);
    }

    @Override
    public String toString() {
        return "PersonServicer [personDao=" + personDao + "]";
    }



}