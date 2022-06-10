package com.example.demo.controller.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.entity.Reserve;
import com.example.demo.controller.entity.Time;

@Repository
public class ReserveDao implements ReserveDaos{
	
    @Autowired
    private NamedParameterJdbcTemplate  jdbcTemplate;

	
	private static final String SQL_INSERT = "insert into reserve(shop_name,r_time,number,r_name,r_date)values(:name,:times,:number,:rName,:date)";
	private static final String SQL_SELECT = "select * from reserve where shop_name = :name";
	private static final String SQL_TIME = "select dummy.t, coalesce(cnt, 0) \r\n"
			+ "from \r\n"
			+ "(\r\n"
			+ "select '9' t\r\n"
			+ "union\r\n"
			+ "select '10'\r\n"
			+ "union\r\n"
			+ "select '11'\r\n"
			+ "union\r\n"
			+ "select '12'\r\n"
			+ "union\r\n"
			+ "select '13'\r\n"
			+ "union\r\n"
			+ "select '14'\r\n"
			+ "union\r\n"
			+ "select '15'\r\n"
			+ "union\r\n"
			+ "select '16'\r\n"
			+ "union\r\n"
			+ "select '17'\r\n"
			+ "union\r\n"
			+ "select '18'\r\n"
			+ "union\r\n"
			+ "select '19'\r\n"
			+ "union\r\n"
			+ "select '20'\r\n"
			+ "union\r\n"
			+ "select '21'\r\n"
			+ "union\r\n"
			+ "select '22'\r\n"
			+ ") dummy\r\n"
			+ "left join\r\n"
			+ "(\r\n"
			+ "select SUBSTRING(r_time , 1, 2) sub ,count(r_time) cnt\r\n"
			+ "from reserve r2\r\n"
			+ "where shop_name =:name\r\n"
			+ "group by SUBSTRING(r_time , 1, 2)\r\n"
			+ ") r\r\n"
			+ "on dummy.t = left(r.sub, 2)\r\n"
			+ "order by cast(dummy.t as integer);";

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
	public List<Time> timeGet(String name) {
		List<Time> shop = new ArrayList<>();
		String sql = SQL_TIME;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("name", name);
		shop =  jdbcTemplate.query(sql,param, new BeanPropertyRowMapper<Time>(Time.class));
		
		return shop;
	}

}