package com.example.demo.controller.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.entity.Shop;

@Repository
public class ShopDao implements ShopDaos {

    @Autowired
    private NamedParameterJdbcTemplate  jdbcTemplate;

private static final String SELECT_SQL ="select shop_name,telnumber,description,category,area from shop join category on shop.categoryid = category.categoryid join area on shop.areaid = area.areaid where shop_name LIKE :keyname or category like :cate or area like :areaarea";
    
public List<Shop> fintdByProductKey(String name) {
	List<Shop> shop = new ArrayList<>();
	String sql = SELECT_SQL;
	MapSqlParameterSource param = new MapSqlParameterSource();

    param.addValue("keyname", "%"+name+"%");
    param.addValue("cate", "%"+name+"%");
    param.addValue("areaarea", "%"+name+"%");

    shop =  jdbcTemplate.query(sql,param, new BeanPropertyRowMapper<Shop>(Shop.class));
    
    return shop;
}
}
