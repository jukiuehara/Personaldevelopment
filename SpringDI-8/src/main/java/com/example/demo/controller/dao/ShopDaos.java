package com.example.demo.controller.dao;

import java.util.List;

import com.example.demo.controller.entity.Shop;

public interface ShopDaos {
	public List<Shop> fintdByProductKey(String name);
	public Shop fintdByname(String name);
	public void delete(String tel);
	public void insert(String name,int area,int cate,String tel,String des);
}
