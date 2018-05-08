package com.dy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.bean.Admin;
import com.dy.bean.Msg;
import com.dy.service.AdminService;

/**
 * 处理和管理员有关的操作
 * 
 * @author dingye
 *
 */
@Controller
public class AdminController {
	@Autowired
	private AdminService adminservice;
	
	/**
	 * 管理员登陆验证
	 * 
	 * @param request
	 * @param response
	 * @param username
	 * @param password
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, String username, String password,
			Model model) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String piccode = (String) request.getSession().getAttribute("piccode");
		String checkcode = request.getParameter("checkcode");// 从文本框获取的字符串
		checkcode = checkcode.toUpperCase();// 消除大小写的问题
		Admin admin = adminservice.confirm(username, password);
		if (admin != null && piccode.equals(checkcode)) {
			model.addAttribute("admin",admin);
			return "admin";
		} else {
			if (!piccode.equals(checkcode)) {
				response.getWriter().print("<script type='text/javascript'>");
				response.getWriter().print("alert('验证码错误');");
				response.getWriter().print("window.location='index.jsp';");
				response.getWriter().print("</script>");
				return null;

			} else {
				response.getWriter().print("<script type='text/javascript'>");
				response.getWriter().print("alert('用户名密码错误');");
				response.getWriter().print("window.location='index.jsp';");
				response.getWriter().print("</script>");
				return null;
			}
		}
	}
}
