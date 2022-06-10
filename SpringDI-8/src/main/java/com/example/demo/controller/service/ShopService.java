package com.example.demo.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.dao.ShopDaos;
import com.example.demo.controller.entity.Shop;

@Service
public class ShopService implements ShopServices{
	@Autowired
	private ShopDaos dao;
	
	public  List<Shop> fintdByProductKey(String name){
        try {
    		return dao.fintdByProductKey(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
	public Shop fintdByname(String name) {
		return dao.fintdByname(name);
	}
	public void delete(String tel) {
		dao.delete(tel);
	}
	public void insert(String name,int area,int cate,String tel,String pass,String des) {
		dao.insert(name,area,cate,tel,pass,des);
	}
	public Shop shoplogin(String pass,String name) {
		return dao.shoplogin(pass,name);
	}
	public void update(String name,int area,int cate,String tel,String pass,String des,String shopname) {
		dao.update(name,area,cate,tel,pass,des,shopname);
	}
	
}