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
			
			return "home";
		} else {
			model.addAttribute("msg", "IDまたはパスワードが不正です");
			return "index";
		}
		
		}
	@RequestMapping("/search")
	public String serch(@RequestParam("key") String a,@RequestParam("category") String b,@RequestParam("area") String c,Model model) {
System.out.println(a);
System.out.println(b);
System.out.println(c);
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
}