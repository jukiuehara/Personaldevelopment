package com.example.demo.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.dao.ReserveDaos;
import com.example.demo.controller.entity.Reserve;

@Service
public class ReserveService implements ReserveServices{
	@Autowired
	private ReserveDaos dao;
	
	public void insert(String name,String rName,String number,String date,String times) {
		dao.insert(name, rName, number, date, times);
	}

	public List<Reserve> fintdByShopName(String name){
		return dao.fintdByShopName(name);
	}
	
}