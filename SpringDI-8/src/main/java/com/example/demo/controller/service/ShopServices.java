package com.example.demo.controller.service;

import java.util.List;

import com.example.demo.controller.entity.Shop;

public interface ShopServices {
	public List<Shop> fintdByProductKey(String name);
}
