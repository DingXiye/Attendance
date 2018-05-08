package com.dy.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dy.bean.Msg;
import com.dy.bean.Teacher;
import com.dy.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 有关于老师的控制类
 * 
 * @author dingye
 *
 */
@Controller
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	
	
	List<Teacher> list=new ArrayList<>();//记录所有需要导出的老师信息
	
	/**
	 * 老师的登录验证
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/teacher", method = RequestMethod.POST)
	public String tealog(HttpServletRequest request, HttpServletResponse response, String username, String password,
			Model model) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String piccode = (String) request.getSession().getAttribute("piccode");
		String checkcode = request.getParameter("checkcode");// 从文本框获取的字符串
		checkcode = checkcode.toUpperCase();// 消除大小写的问题
		Teacher teacher = teacherService.confirm(username, password);
		if (teacher != null && piccode.equals(checkcode)) {
			model.addAttribute(teacher);
			return "teacher";
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

	/**
	 * 获取所有老师的信息
	 * @return
	 */
	@RequestMapping("/tea")
	@ResponseBody
	public Msg gettea(@RequestParam(value="pn",defaultValue="1")Integer pn){
		PageHelper.startPage(pn,8);
		List<Teacher> teachers =teacherService.getall();
		// 将信息使用pageinfo封装，5表示连续显示的5页
		PageInfo pageinfo = new PageInfo(teachers, 5);
		list=teachers;
		return Msg.success().add("pageinfo", pageinfo);
	}
	
	/**
	 * 根据条件查询
	 * @return
	 */
	@RequestMapping("/tselect/{pn}")
	@ResponseBody
	public Msg select(Teacher tea,@PathVariable(value = "pn") Integer pn){
		System.out.println("id"+tea.getTecId()+" "+"coursename"+tea.getCoursename());
		if (tea.getTecId()==null &&tea.getCoursename().equals("")) {
			return Msg.fail().add("error", "不能全为空");
		} else if (!tea.getCoursename().equals("") && tea.getTecId().equals("")) {// 根据课程名查询
			PageHelper.startPage(pn, 8);
			List<Teacher> teas = teacherService.selectbyCoursename(tea.getCoursename());
			PageInfo pageinfo = new PageInfo(teas, 5);
			list=teas;
			return Msg.success().add("pageinfo", pageinfo);
		} else if (tea.getCoursename().equals("") && !tea.getTecId().equals("")) {// 根据工号查询
			PageHelper.startPage(1, 8);
			List<Teacher> teachers = teacherService.selectbyteaid(tea.getTecId());
			PageInfo pageinfo = new PageInfo(teachers, 5);
			list=teachers;
			return Msg.success().add("pageinfo", pageinfo);
		} else {
			return Msg.fail().add("error", "不能同时查询");
		}
		
	}
	
	/**
	 * 添加老师信息，因为一个老师可以教多个班，而每个班都是一条信息，所以不需要查重验证
	 * @param tea
	 * @return Msg
	 */
	@RequestMapping("/teaadd")
	@ResponseBody
	public Msg Add(Teacher tea){
		teacherService.add(tea);
		return Msg.success();
		
	}
	
	/**
	 * 删除老师
	 * @return
	 */
	@RequestMapping(value="/tea/{teaid}",method=RequestMethod.DELETE)
	@ResponseBody
	public Msg delete(@PathVariable(value="teaid") String id){
		System.out.println("id"+id);
		if(id.contains("-")){//多个删除
			String[] ids=id.split("-");
			List<Integer> list = new ArrayList<>();
			for (String teaid : ids) {
				list.add(Integer.parseInt(teaid));
			}
			teacherService.deleteBatch(list);
			return Msg.success();
		}else{//单个删除
			teacherService.deleteone(id);
			return Msg.success();
		}
	}
	
	/**
	 * 根据id获取老师信息
	 * @return
	 */
	@RequestMapping("/tea/{id}")
	@ResponseBody
	public Msg getbyId(@PathVariable(value="id")String id){
		Teacher tea=teacherService.selectbyid(id);
		return Msg.success().add("tea", tea);
	}
	
	/**
	 * 根据主键跟新数据
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/tea/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Msg update(Teacher teacher){
		teacherService.update(teacher);
		return Msg.success();
	}
	
	/**
	 * 导入老师信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/importtea", method = RequestMethod.POST)
	@ResponseBody
	public Msg importtea(HttpServletRequest request, HttpServletResponse rep,
			@RequestParam(value = "filename") MultipartFile file) throws Exception {
		if (!file.isEmpty()) {// 判断文件是否为空
			String filepath = request.getSession().getServletContext().getRealPath("/") + "upload/"
					+ file.getOriginalFilename();// 文件保存路径
			// System.out.println(filepath);
			try {
				file.transferTo(new File(filepath));// 转存文件
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String filename = file.getOriginalFilename();// 获得文件名
		String regx = filename.substring(filename.lastIndexOf("."));
		// System.out.println("后缀"+regx);
		if (regx.equals(".xls")) {
			String name = "upload\\" + filename;
			String realpath = request.getSession().getServletContext().getRealPath("/") + name;
			// System.out.println("name" + realpath);
			teacherService.importtea(realpath);
			return Msg.success();
		} else {
			return Msg.fail().add("errorfilname", "只能上传xls文件");
		}
	}

	
	/**
	 * 导出老师信息
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/exporttea")
	@ResponseBody
	public Msg export(HttpServletResponse response,HttpServletRequest request) throws IOException{
		OutputStream out=null;
		response.setHeader("Content-Disposition", "attachment;filename=tea.xls");
		response.setContentType("application/x-download");
		teacherService.export(list,response,out);
		return Msg.success();
	}
}
