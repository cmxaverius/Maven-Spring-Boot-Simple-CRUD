package com.example.web.SpringBootWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import  com.example.web.SpringBootWeb.model.*;
import  com.example.web.SpringBootWeb.controller.*;
import  com.example.web.SpringBootWeb.dao.*;
import  com.example.web.SpringBootWeb.service.*;

@SpringBootApplication
public class SpringBootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

}
