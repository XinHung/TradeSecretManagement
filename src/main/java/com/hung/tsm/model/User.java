package com.hung.tsm.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private Integer id;			// 流水號
	private String empId;		// 工號
	private String empName;		// 姓名
	private String password;	// 密碼
	private String department;	// 部門
	private Boolean sex;		// 性別
	private Boolean isAdmin;	// 是否為系統管理員(IT)
	private Boolean isUserAdmin;// 使否為系統管理員(user)
	private String email;		// email
	private Date regDate;		// 註冊日期
    private Date lastLoginDate;	// 上次登入日期
    private String registerIp;	// 註冊IP
    private String lastLoginIp;	// 上次登入IP
}
