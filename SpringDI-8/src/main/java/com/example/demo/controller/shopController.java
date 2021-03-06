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

import com.example.demo.controller.entity.Reserve;
import com.example.demo.controller.entity.Shop;
import com.example.demo.controller.entity.Time;
import com.example.demo.controller.entity.User;
import com.example.demo.controller.form.loginForm;
import com.example.demo.controller.form.reserveForm;
import com.example.demo.controller.form.shopForm;
import com.example.demo.controller.service.ReserveServices;
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
	@Autowired
	private ReserveServices rss;

	@RequestMapping("/index")
	public String index(@ModelAttribute("shop") loginForm from, Model model) {
		return "index";
	}
	@RequestMapping("/logout")
	public String logout(@ModelAttribute("shop") loginForm from, Model model) {
		return "logout";
	}
	@RequestMapping("/rogin")
	public String rogin(@Validated @ModelAttribute("shop") loginForm form, BindingResult bindingResult,
			Model model) {
//		if (bindingResult.hasErrors()) {
//			return "index";
//		}

		User user = uss.login(form.getId(), form.getPass());

		if (user != null) {
			List<Shop> list = new ArrayList<>();
			list = sss.fintdByProductKey("");
			session.setAttribute("Username", user.getName());
			session.setAttribute("Role", user.getRole());
			session.setAttribute("list", list);
			
			return "home";
		} else {
			model.addAttribute("msg", "ID???????????????????????????????????????");
			return "index";
		}
	}
	@RequestMapping("/new")
	public String newin(@ModelAttribute("new") loginForm from, Model model) {
		return "new";
	}
		@RequestMapping("/news")
		public String news(@Validated @ModelAttribute("new") loginForm form, BindingResult bindingResult,
				Model model) {
			if (bindingResult.hasErrors()) {
				return "new";
			}
			try {			
				uss.insert(form.getId(), form.getPass(),form.getName());
				return "start";
			} catch (Exception e) {
				String msg = "id?????????????????????";
				model.addAttribute("usermsg", msg);
				return "new";
			}
		
		}
		
	@RequestMapping("/search")
	public String serch(@RequestParam("key") String a,@RequestParam("category") String b,@RequestParam("area") String c,Model model) {

		List<Shop> list=new ArrayList<>();
		if(a.equals("")&&b.equals("????????????")) {
			list = sss.fintdByProductKey(c);
		}else if(c.equals("?????????")&&b.equals("????????????")) {
			list = sss.fintdByProductKey(a);
		}else if(a.equals("")&&c.equals("?????????")) { 
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
		List<Time> timelist = new ArrayList<>();
		timelist = rss.timeGet(a);
		
		session.setAttribute("time", timelist);
		session.setAttribute("shop", s);
		return "shop";
	}
	@RequestMapping("/shop2")
	public String shop(Model model) {

		return "shop";
	}
	@RequestMapping("/reservationtable")
	public String table( Model model) {
		Shop shop = (Shop) session.getAttribute("shop");
		
		List<Reserve> list = new ArrayList<>();
	list = rss.fintdByShopName(shop.getShopName());
		session.setAttribute("table", list);
		return "reservationtable";
	}
	
	@RequestMapping("/edit")
	public String edit1(Model model) {
		Shop a = (Shop) session.getAttribute("shop");
		sss.delete(a.getTelnumber());
		String msg = "???????????????????????????";
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
	@RequestMapping("/up")
	public String up(@ModelAttribute("update") shopForm form, Model model) {
		
		return "update";
	}
	@RequestMapping("/reserve")
	public String reserve(@RequestParam("pass") String a,Model model) {
		Shop shopname = (Shop) session.getAttribute("shop");
		Shop shoplogin = sss.shoplogin(a,shopname.getShopName());
		if (shoplogin != null) {
			return "reserve";
		} else {

			return "shop";
		}
	}
		@RequestMapping("/reserveback")
		public String reserve2(Model model) {
				return "reserve";
	}
	@RequestMapping("/insert")
	public String insert(@Validated @ModelAttribute("insert") shopForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "insert";
		}
		try {
		String name= form.getShopName();
		int area = form.getAreaid();
		int cate = form.getCategoryid();
		String tel = form.getTelnumber();
		String pass = form.getPass();
		String des = form.getDescription();
		
		sss.insert(name,area,cate,tel,pass,des);
		String msg = "???????????????????????????";
		model.addAttribute("msg", msg);
		return "insert";
	} catch (Exception e) {
		String msg = "??????????????????????????????";
		model.addAttribute("msg", msg);
		return "insert";
	}
	}
	@RequestMapping("/update")
	public String update(@Validated @ModelAttribute("update") shopForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "insert";
			}

			String name= form.getShopName();
			int area = form.getAreaid();
			int cate = form.getCategoryid();
			String tel = form.getTelnumber();
			String pass = form.getPass();
			String des = form.getDescription();
			Shop shop = (Shop) session.getAttribute("shop");
			sss.update(name,area,cate,tel,pass,des,shop.getShopName());
			String msg = "???????????????????????????";
			model.addAttribute("msg", msg);
			return "update";

	}
	
	@RequestMapping("/yoyaku")
	public String calendar(@Validated @ModelAttribute("yoyaku") reserveForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "yoyaku";
		}
		
		Shop shop = (Shop) session.getAttribute("shop");
	
		System.out.println(shop.getShopName()+form.getrName()+form.getNumber()+form.getDate()+form.getTimes());

		String rName = form.getrName();
		String number = form.getNumber();
		String date = form.getDate();
		String times = form.getTimes();
		rss.insert(shop.getShopName(), rName, number, date, times);
		return "end";
	}
	@RequestMapping("/yoyakuin")
	public String yoyaku(@ModelAttribute("yoyaku") reserveForm form, Model model) {
			return "yoyaku";

	}
}