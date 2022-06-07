package com.example.demo.controller.form;

import javax.validation.constraints.NotBlank;

public class shopForm{
	
	private int id ;
	
	@NotBlank(message="店舗名が未入力です")
	private String shopName;
	
	private Integer categoryid;
	
	private Integer areaid;
	
	@NotBlank(message="電話番号が未入力です")
	private String telnumber;
	
	@NotBlank(message="店舗紹介文が未入力です")
	private String description;
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

	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public Integer getAreaid() {
		return areaid;
	}
	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
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