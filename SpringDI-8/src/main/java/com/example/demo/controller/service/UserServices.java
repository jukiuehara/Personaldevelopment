package com.example.demo.controller.service;

import com.example.demo.controller.entity.User;

public interface UserServices {
	 public User login(String id,String pass);
	 public void insert(String id,String pass,String name);
	 
}
