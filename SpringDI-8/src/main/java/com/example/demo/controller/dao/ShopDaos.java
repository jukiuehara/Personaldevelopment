package com.example.demo.controller.dao;

import java.util.List;

import com.example.demo.controller.entity.Shop;

public interface ShopDaos {
	public List<Shop> fintdByProductKey(String name);
}
