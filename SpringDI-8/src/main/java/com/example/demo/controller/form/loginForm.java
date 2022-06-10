package com.example.demo.controller.form;
import javax.validation.constraints.NotBlank;

public class loginForm{
	
	@NotBlank(message="idが未入力です")
	private String id;
	
	@NotBlank(message="パスワードが未入力です")
	private String pass;
	@NotBlank(message="名前が未入力です")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}



}