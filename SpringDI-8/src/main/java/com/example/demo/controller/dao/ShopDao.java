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
private static final String SQL_SELECT_PASS ="select * from shop where shop_name =:name and password = :pass";
private static final String SELECT_NAME_SQL ="select shop_name,telnumber,description,category,area from shop join category on shop.categoryid = category.categoryid join area on shop.areaid = area.areaid where shop_name LIKE :keyname";
private static final String SQL_DELETE ="delete from shop where telnumber = :tel;";
private static final String SQL_INSERT ="insert into shop(shop_name,areaid,categoryid,telnumber,password,description)values(:name,:area,:cate,:tel,:pass,:des)";
private static final String SQL_UPDATE ="UPDATE SHOP SET shop_name = :name,areaid = :area,categoryid =:cate,telnumber = :tel,password = pass,description = :des where shop_name = :shopname";

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

public Shop fintdByname(String name) {
	List<Shop> shop = new ArrayList<>();
	String sql = SELECT_NAME_SQL;
	MapSqlParameterSource param = new MapSqlParameterSource();
    param.addValue("keyname", "%"+name+"%");
    shop =  jdbcTemplate.query(sql,param, new BeanPropertyRowMapper<Shop>(Shop.class));
    
    return shop.isEmpty() ? null : shop.get(0);
}

public void delete(String tel) {
	String sql = SQL_DELETE;
	MapSqlParameterSource param = new MapSqlParameterSource();
	param.addValue("tel", tel);
	jdbcTemplate.update(sql, param);
}

public void insert(String name,int area,int cate,String tel,String pass,String des) {
	String sql = SQL_INSERT;
	MapSqlParameterSource param = new MapSqlParameterSource();
	param.addValue("name",name);
	param.addValue("area",area);
	param.addValue("cate",cate);
	param.addValue("tel",tel);
	param.addValue("pass",pass);	
	param.addValue("des",des);
	jdbcTemplate.update(sql, param);
}

public void update(String name,int area,int cate,String tel,String pass,String des,String shopname){
	String sql = SQL_UPDATE;
	MapSqlParameterSource param = new MapSqlParameterSource();
	param.addValue("name",name);
	param.addValue("area",area);
	param.addValue("cate",cate);
	param.addValue("tel",tel);
	param.addValue("pass",pass);	
	param.addValue("des",des);
	param.addValue("shopname",shopname);
	jdbcTemplate.update(sql, param);
}

public Shop shoplogin(String pass,String name) {
	String sql = SQL_SELECT_PASS;
    MapSqlParameterSource param = new MapSqlParameterSource();
    param.addValue("name", name);
    param.addValue("pass", pass);
    List<Shop> list =  jdbcTemplate.query(sql,param, new BeanPropertyRowMapper<Shop>(Shop.class));
    return list.isEmpty() ? null : list.get(0);

}


}
