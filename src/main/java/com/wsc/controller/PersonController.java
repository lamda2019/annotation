package com.wsc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wsc.servicer.PersonServicer;

@Controller
public class PersonController {
    @Autowired
    private PersonServicer personServicer;
}