package com.hung.tsm.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductType {
	private Integer id;				// 流水號
	private String name;			// 產品名稱
	private String createEmpId;		// 建立人員工號
	private String createEmpName;	// 建立人員姓名
	private Date createTime;		// 建立時間
	private String lastEditEmpId;	// 上次編輯人員工號
	private String lastEditEmpName;	// 上次編輯人員姓名
	private Date lastEditTime;		// 上次編輯時間
}
