package com.example.demo.controller.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShopDao implements ShopDaos {

    @Autowired
    private NamedParameterJdbcTemplate  jdbcTemplate;

private static final SELECT_SQL ;
    
}
