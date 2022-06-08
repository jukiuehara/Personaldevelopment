package com.example.demo.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.dao.ReserveDaos;

@Service
public class ReserveService implements ReserveServices{
	@Autowired
	private ReserveDaos dao;
	
	public void insert(String name,String rName,String number,String date,String times) {
		dao.insert(name, rName, number, date, times);
	}
	
}