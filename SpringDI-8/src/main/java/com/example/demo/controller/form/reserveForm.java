package com.example.demo.controller.form;
import javax.validation.constraints.NotBlank;

public class reserveForm{
	
	@NotBlank(message="お名前の入力をお願い致します。")
	private String rName;
	
	@NotBlank(message="予約人数の入力をお願い致します。")
	private String number;
	
	@NotBlank(message="予約日の入力をお願い致します。")
	private String date;
	
	@NotBlank(message="予約時間の入力をお願い致します。")
	private String times;
	
	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}


}