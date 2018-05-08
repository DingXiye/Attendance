package com.dy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dy.utils.Verify;

public class verifyfinger extends HttpServlet {
	String sid;
	String check;
	String reg;
	

	public verifyfinger() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		sid = request.getParameter("sid");
		check = request.getParameter("fingertemplate");
		String week = request.getParameter("week");
		int weeki=Integer.parseInt(week);
		System.out.println(weeki);
		String weekid = request.getParameter("weekid");
		String classid= request.getParameter("classid");
		String courseid = request.getParameter("courseid");
		System.out.println("所有信息"+check + weekid + classid+ courseid);
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 设置数据库连接字符串
			String sql = "select * from tb_student where stu_id ='" + sid + "'";
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendancedb", "root", "1234");
			String classname=getclass(conn, classid);
			String coursename=getcourse(conn, courseid);
			String weekday=getweek(weekid);
			//System.out.println(classname+coursename+weekid+weekday);
			Statement sqlStmt = conn.createStatement(); // 执行sql语句的集合
			ResultSet rs = sqlStmt.executeQuery(sql);
			while (rs.next()) {
				reg = rs.getString("stu_fingerprint");
				Verify verify = new Verify();
				boolean flag = verify.test(reg, check);
				System.out.println("对比信息"+flag);
				if(flag){
					String sqlupdate="update tb_studentinfo set stu_attendance='出勤' where stuinfo_id='"+sid+"' and stu_week="+weeki+" and stu_weekday='"+weekday+"' and stu_coursename='"+coursename+"'";
					System.out.println(sqlupdate);
					sqlStmt.executeUpdate(sqlupdate);
					out.print("<script type='text/javascript'>");
					out.print("alert('签到成功');");
					out.print("window.location='verify.jsp';");
					out.print("</script>");
				}else{
					out.print("<script type='text/javascript'>");
					out.print("alert('签到失败');");
					out.print("window.location='verify.jsp';");
					out.print("</script>");
				}
				request.getSession().setAttribute("flag", flag);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}
	
	public String getclass(Connection conn,String classid) throws SQLException{
		String classname="";
		Statement sqlStmt1 = conn.createStatement(); // 执行sql语句的集合
		String sql="select * from tb_class where classid="+Integer.parseInt(classid);
		ResultSet rs1 = sqlStmt1.executeQuery(sql);
		while (rs1.next()) {
			classname = rs1.getString("classname");
		}
		return classname;
	}
	public String getcourse(Connection conn,String courseid) throws SQLException{
		String coursename="";
		Statement sqlStmt2 = conn.createStatement(); // 执行sql语句的集合
		String sql="select * from tb_course where course_id="+Integer.parseInt(courseid);
		ResultSet rs2 = sqlStmt2.executeQuery(sql);
		while (rs2.next()) {
			coursename = rs2.getString("coursename");
		}
		return coursename;
	}
	
	public String getweek(String weekid){
		String weekday = null;
		if(weekid.equals("1")){
			weekday="一";
		}
		if(weekid.equals("2")){
			weekday="二";
		}
		if(weekid.equals("3")){
			weekday="三";
		}
		if(weekid.equals("4")){
			weekday="四";
		}
		if(weekid.equals("5")){
			weekday="五";
		}
		if(weekid.equals("6")){
			weekday="六";
		}
		if(weekid.equals("7")){
			weekday="日";
		}
		return weekday;

	}
}
