package com.dy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dy.bean.Admin;
import com.dy.dao.AdminMapper;

@Service("adminService")
public class AdminService {
	@Autowired
	private AdminMapper adminmapper;

	/**
	 * 验证管理员登陆
	 * @param adminName
	 * @param adminpassword
	 * @return
	 */
	public Admin confirm(String adminName, String adminpassword) {

		Admin admin = adminmapper.selectByPrimaryKey(adminName);
		if (admin != null && admin.getAdminPassword().equals(adminpassword)) {
			return admin;
		}
		return null;
	}
}
