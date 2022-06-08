package com.example.demo.controller.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.entity.Reserve;

@Repository
public class ReserveDao implements ReserveDaos{
	
    @Autowired
    private NamedParameterJdbcTemplate  jdbcTemplate;

	
	private static final String SQL_INSERT = "insert into reserve(shop_name,r_time,number,r_name,r_date)values(:name,:times,:number,:rName,:date)";
	private static final String SQL_SELECT = "select * from reserve where shop_name = :name";

	public void insert(String name,String rName,String number,String date,String times) {
		String sql = SQL_INSERT;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("name",name);
		param.addValue("rName",rName);
		param.addValue("number",number);
		param.addValue("date",date);
		param.addValue("times",times);
		
		System.out.println(name+rName+number+date+times);
		jdbcTemplate.update(sql, param);
	}
	public List<Reserve> fintdByShopName(String name) {
		List<Reserve> shop = new ArrayList<>();
		String sql = SQL_SELECT;
		MapSqlParameterSource param = new MapSqlParameterSource();
	    param.addValue("name", name);
	    shop =  jdbcTemplate.query(sql,param, new BeanPropertyRowMapper<Reserve>(Reserve.class));
	    
	    return shop;
	}

}