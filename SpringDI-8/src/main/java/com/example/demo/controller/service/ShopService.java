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
}