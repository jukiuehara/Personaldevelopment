package com.example.demo.controller.service;

import java.util.List;

import com.example.demo.controller.entity.Reserve;
import com.example.demo.controller.entity.Time;

public interface ReserveServices {
	public void insert(String name,String rName,String number,String date,String times);
	public List<Reserve> fintdByShopName(String name);
	public List<Time> timeGet(String name);
}
