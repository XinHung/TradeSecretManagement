package com.hung.tsm.controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hung.tsm.dao.UserDao;
import com.hung.tsm.model.User;
import com.hung.tsm.utils.MD5;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/tsm")
@Controller
public class LoginController {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Autowired
	private UserDao userDao;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String doLogin(HttpServletRequest request, HttpSession session, Model model) {
		String empId  = request.getParameter("empId");	// 工號
		String empPwd = request.getParameter("empPwd");	// 密碼
		if(empId == null || empId.trim().equals("") ||
				empPwd == null || empPwd.trim().equals("")) {
			model.addAttribute("errorMsg", "請輸入工號與密碼!!");
			return "login";
		} else {
			try {
				User user = userDao.getUserByEmpIdAndPwd(empId, empPwd);
				if(user == null) {
					model.addAttribute("errorMsg", "工號或密碼錯誤!!");
					return "login";
				} else {
					// 驗證通過，設定 session
					session.setAttribute("user", user);
					// 更新登入時間與IP
					String sql = "update user set LAST_LOGIN_TIME=now(), LAST_LOGIN_IP=? where EMP_ID= ?";
				    jdbcTemplate.update(sql, (PreparedStatement ps) -> {
			            ps.setString(1, request.getRemoteAddr());
			            ps.setString(2, empId);
			        });
					return "redirect:./home";
				}
			} catch(DataAccessException e) {
				model.addAttribute("errorMsg", "工號或密碼錯誤!!");
				return "login";
			}
		}
	}
	
	
}
