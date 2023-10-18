package com.hung.tsm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hung.tsm.dao.ProductInfoDao;
import com.hung.tsm.dao.ProductLevelDao;
import com.hung.tsm.dao.ProductTypeDao;
import com.hung.tsm.dao.SecurityLevelDao;
import com.hung.tsm.model.User;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/tsm")
@Controller
public class RegisterController {
	@Autowired
	private SecurityLevelDao securityDao;
	@Autowired
	private ProductTypeDao productTypeDao;
	@Autowired
	private ProductLevelDao productLevelDao;
	@Autowired
	private ProductInfoDao productInfoDao;
	
	@GetMapping("register")
	public String register(HttpSession session, Model model) {
		if(session.getAttribute("user") == null) {
			return "redirect:./login";
		} else {
			User user = (User) session.getAttribute("user");
			model.addAttribute("empId", user.getEmpId());
			model.addAttribute("empName", user.getEmpName());
			model.addAttribute("empDept", user.getDepartment());
			model.addAttribute("securityList", securityDao.getAllSecurity());
			model.addAttribute("productTypeList", productTypeDao.getAllProductType());
			model.addAttribute("productLevelList", productLevelDao.getAllProductLevel());
			model.addAttribute("productInfoList", productInfoDao.getAllProductInfo());
		}
		return "TradeSecret/register";
	}
}
