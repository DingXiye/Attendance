package com.dy.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 指纹采集
 * @author dingye
 *
 */
public class Regedit extends HttpServlet {

	public Regedit() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("have succes");
		String sid = request.getParameter("sid");
		String fingertemplate = request.getParameter("fingertemplate");
		//System.out.println(fingertemplate);
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 设置数据库连接字符串
			String sql = "update tb_student set stu_fingerprint ='" + fingertemplate + "' where stu_id ='" + sid+"'";
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendancedb", "root", "1234");
			Statement sqlStmt = conn.createStatement(); // 执行sql语句的集合
			sqlStmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
