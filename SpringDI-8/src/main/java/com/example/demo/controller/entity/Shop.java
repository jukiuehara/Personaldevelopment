package com.example.demo.controller.entity;

public class Shop {
	private int id ;
	private String shopName;
	private String category;
	private String area;
	private String telnumber;
	private String description;
	
	public Shop() {
		
	}
	public Shop(int id , String shopName, String category,String area,String telnumber,String description) {
		this.id =id;
		this.shopName = shopName;
		this.category = category;
		this.area =area;
		this.telnumber = telnumber;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTelnumber() {
		return telnumber;
	}
	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}