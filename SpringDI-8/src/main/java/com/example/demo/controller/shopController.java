package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.controller.entity.User;
import com.example.demo.controller.form.loginForm;
import com.example.demo.controller.service.UserServices;



@Controller
public class shopController {
	
	@Autowired
	HttpSession session;
	@Autowired
	private UserServices uss;

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
			session.setAttribute("Username", user.getName());
			session.setAttribute("Role", user.getRole());
			return "home";
		} else {
			model.addAttribute("msg", "IDまたはパスワードが不正です");
			return "index";
		}
	}
}