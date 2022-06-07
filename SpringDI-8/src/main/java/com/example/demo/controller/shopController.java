package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.controller.entity.Shop;
import com.example.demo.controller.entity.User;
import com.example.demo.controller.form.loginForm;
import com.example.demo.controller.form.shopForm;
import com.example.demo.controller.service.ShopServices;
import com.example.demo.controller.service.UserServices;



@Controller
public class shopController {
	
	@Autowired
	HttpSession session;
	@Autowired
	private UserServices uss;
	@Autowired
	private ShopServices sss;

	@RequestMapping("/index")
	public String index(@ModelAttribute("shop") loginForm from, Model model) {
		return "index";
	}
	@RequestMapping("/rogin")
	public String rogin(@Validated @ModelAttribute("shop") loginForm form, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "index";
		}
		User user = uss.login(form.getId(), form.getPass());

		if (user != null) {
			List<Shop> list = new ArrayList<>();
			list = sss.fintdByProductKey("");
			session.setAttribute("Username", user.getName());
			session.setAttribute("Role", user.getRole());
			session.setAttribute("list", list);
			
			return "home";
		} else {
			model.addAttribute("msg", "IDまたはパスワードが不正です");
			return "index";
		}
		
		}
	@RequestMapping("/search")
	public String serch(@RequestParam("key") String a,@RequestParam("category") String b,@RequestParam("area") String c,Model model) {

		List<Shop> list=new ArrayList<>();
		if(a.equals("")&&b.equals("ジャンル")) {
			list = sss.fintdByProductKey(c);
		}else if(c.equals("エリア")&&b.equals("ジャンル")) {
			list = sss.fintdByProductKey(a);
		}else if(a.equals("")&&c.equals("エリア")) { 
		list = sss.fintdByProductKey(b);
		}

		int count = 0;
		for (Shop i : list) {
			count++;
		}

		session.setAttribute("count", count);
		session.setAttribute("list", list);
		return "home";
	}
	@RequestMapping("/shop")
	public String shop(@RequestParam("name") String a, Model model) {
		Shop s = sss.fintdByname(a);
		session.setAttribute("shop", s);
		return "shop";
	}
	
	@RequestMapping("/edit")
	public String edit1(Model model) {
		Shop a = (Shop) session.getAttribute("shop");
		sss.delete(a.getTelnumber());
		String msg = "消去が完了しました";
		model.addAttribute("deletemsg", msg);
		
		List<Shop> list = new ArrayList<>();
		list = sss.fintdByProductKey("");
		session.setAttribute("list", list);
		return "home";
	}
	@RequestMapping("/back")
	public String back(Model model) {
		List<Shop> list = new ArrayList<>();
		list = sss.fintdByProductKey("");
		session.setAttribute("list", list);
		return "home";
	}
	@RequestMapping("/in")
	public String in(@ModelAttribute("insert") shopForm form, Model model) {
		
		return "insert";
	}
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute("insert") shopForm form, Model model) {
		try {
		String name= form.getShopName();
		int area = form.getAreaid();
		int cate = form.getCategoryid();
		String tel = form.getTelnumber();
		String des = form.getDescription();
		
		sss.insert(name,area,cate,tel,des);
		String msg = "登録が完了しました";
		model.addAttribute("msg", msg);
		return "insert";
	} catch (Exception e) {
		String msg = "店舗名が重複しました";
		model.addAttribute("msg", msg);
		return "insert";
	}

	}
	
}