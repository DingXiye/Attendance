package com.dy.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFileChooser;
import javax.validation.Valid;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dy.bean.GradeInfo;
import com.dy.bean.Msg;
import com.dy.bean.Student;
import com.dy.bean.StudentInfo;
import com.dy.service.StudentService;
import com.dy.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 处理和学生有关的操作
 * 
 * @author dingye
 *
 */
@Controller
public class StudentController {
	@Autowired
	private StudentService studentservice;

	private StudentInfo updateinfo ;//跟新时所要记录的数据
	private String stuid;// 记住登录时的学生id
	private List<Student> all = new ArrayList<>();// 记录所有需要导出的学生信息
	private List<Student> grades = new ArrayList<>();// 记录平时分
	private List<GradeInfo> exportinfo =new ArrayList<>();//打印平时分成绩单
	
//	@RequestMapping(value="/dispatch/{id}" ,method=RequestMethod.POST)
//	@ResponseBody
//	public String dis(StudentInfo info,@PathVariable(value="id")String sid){
//		return "verify";
//	}
	
	
//	/**
//	 * 注册指纹
//	 * @return
//	 */
//	@RequestMapping(value="/regfinger/{ids}",method=RequestMethod.POST)
//	@ResponseBody
//	public Msg regfinger(@PathVariable(value = "ids") String sid,@RequestParam(value = "regtemp") String regtemp){
//		//System.out.println("学号"+sid+"指纹："+regtemp);
//		studentservice.toregfinger(sid,regtemp);
//		return Msg.success();
//	}
//	
//	/**
//	 * 验证指纹是否对应
//	 * @return
//	 */
//	@RequestMapping(value="/checkfinger/{sid}",method=RequestMethod.POST)
//	@ResponseBody
//	public void verify(@PathVariable(value="sid")String sid,@RequestParam(value = "verifytem") String verifytem){
//		System.out.println("学号"+sid+"指纹："+verifytem);
//		studentservice.verifyfinger(updateinfo,sid,verifytem);
//	}
	
	/**
	 * 学生登录验证
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/stu", method = RequestMethod.POST)
	public String stulog(HttpServletRequest request, HttpServletResponse response, String username, String password,
			Model model) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String piccode = (String) request.getSession().getAttribute("piccode");
		String checkcode = request.getParameter("checkcode");// 从文本框获取的字符串
		checkcode = checkcode.toUpperCase();// 消除大小写的问题
		System.out.println(username + " " + password);
		stuid = username;
		Student stu = studentservice.confirm(username, password);
		if (stu != null && piccode.equals(checkcode)) {
			model.addAttribute("stu", stu);
			return "student";
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
	 * 返回所有学生信息 分页查询，使用pagehelper插件
	 * 
	 * @return 一个结果集，里面包含了页面的各种信息
	 */
	@RequestMapping("/stu")
	@ResponseBody
	public Msg getStuAll(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		all = studentservice.getAll();// 导出文件所需的数据
		// 实现分页查询，使用过pagehelper插件,从第几页开始查，8为每页显示的数据条数，pn是由前台传入
		PageHelper.startPage(pn, 10);
		// 紧跟着的查询就是分页查询
		List<Student> stus = studentservice.getAll();
		// 将信息使用pageinfo封装，5表示连续显示的5页
		PageInfo pageinfo = new PageInfo(stus, 5);
		return Msg.success().add("pageinfo", pageinfo);
	}

	/**
	 * 导入学生信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/import", method = RequestMethod.POST)
	@ResponseBody
	public Msg importstu(HttpServletRequest request, HttpServletResponse rep,
			@RequestParam(value = "filename") MultipartFile file) throws Exception {
		if (!file.isEmpty()) {// 判断文件是否为空
			String filepath = request.getSession().getServletContext().getRealPath("/") + "upload/"
					+ file.getOriginalFilename();// 文件保存路径
			System.out.println(filepath);
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
			System.out.println("name" + realpath);
			studentservice.importstu(realpath);
			return Msg.success();
		} else {
			return Msg.fail().add("errorfilname", "只能上传xls文件");
		}
	}


	/**
	 * 管理员的条件查询 可以按照学号或者班级名
	 * 
	 * @return
	 */
	@RequestMapping("/select/{pn}")
	@ResponseBody
	public Msg select(Student stu, @PathVariable(value = "pn") Integer pn) {
		System.out.println(stu.toString());
		if (stu.getStuId().equals("") && stu.getStuClassname().equals("")) {
			return Msg.fail().add("error", "不能全为空");
		} else if (!stu.getStuClassname().equals("") && stu.getStuId().equals("")) {// 根据班级名查询
			all = studentservice.selectbyclassname(stu.getStuClassname());
			PageHelper.startPage(pn, 10);
			List<Student> stus = studentservice.selectbyclassname(stu.getStuClassname());
			PageInfo pageinfo = new PageInfo(stus, 5);
			return Msg.success().add("pageinfo", pageinfo);
		} else if (stu.getStuClassname().equals("") && !stu.getStuId().equals("")) {// 根据学号查询
			all = studentservice.selectbyid(stu.getStuId());
			PageHelper.startPage(1, 10);
			List<Student> student = studentservice.selectbyid(stu.getStuId());
			PageInfo pageinfo = new PageInfo(student, 5);
			return Msg.success().add("pageinfo", pageinfo);
		} else {
			return Msg.fail().add("error", "不能同时查询");
		}
	}

	/**
	 * 添加一个学生，在这之前会进行查重和验证数据合法性操作（需要点击保存按钮之后才会提示验证信息） 使用jsr303进行数据合法性的校验
	 * 
	 * @return
	 */
	@RequestMapping(value = "/stuadd", method = RequestMethod.POST)
	@ResponseBody
	public Msg save(@Valid Student stu, BindingResult result) {
		Map<String, Object> map = new HashMap<>();
		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fielderror : errors) {
				System.out.println("错误字段名:" + fielderror.getField());
				System.out.println("错误信息:" + fielderror.getDefaultMessage());
				map.put(fielderror.getField(), fielderror.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);// 返回错误信息
		} else {
			studentservice.savestu(stu);
			return Msg.success();
		}
	}

	/**
	 * 基于学号的查重
	 * 
	 * @return
	 */
	@RequestMapping("/checkstu")
	@ResponseBody
	public Msg checkstu(@RequestParam(value = "stuId") String sid) {
		boolean b = studentservice.check(sid);
		String regx = "s\\d{4}";
		if (!sid.matches(regx)) {
			return Msg.fail().add("rex_msg", "学号应使用s+4位数字");
		}
		if (b) {
			return Msg.success();
		} else {
			return Msg.fail().add("rex_msg", "该学号已存在，不可用");
		}
	}

	/**
	 * 单个或多个删除
	 * 
	 * @return
	 */
	@RequestMapping(value = "/stu/{ids}", method = RequestMethod.DELETE)
	@ResponseBody
	public Msg deletestu(@PathVariable(value = "ids") String id) {
		System.out.println("id" + id);
		if (id.contains("-")) {
			String[] ids = id.split("-");
			List<String> list = new ArrayList<>();
			for (String stuids : ids) {
				list.add(stuids);
			}
			studentservice.deleteBatch(list);
			return Msg.success();
		} else {
			studentservice.deleteById(id);
			return Msg.success();
		}
	}

	/**
	 * 查找一个学生信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/stu/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Msg getstu(@PathVariable("id") String id) {
		Student stu = studentservice.getbyid(id);
		return Msg.success().add("stu", stu);
	}

	/**
	 * 跟新学生信息
	 * 
	 * @param emp
	 * @return
	 */
	@RequestMapping(value = "/stu/{stuId}", method = RequestMethod.PUT)
	@ResponseBody
	public Msg update(Student stu) {
		studentservice.update(stu);
		return Msg.success();
	}

	/**
	 * 导出学生信息
	 * 
	 * @return Msg
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/export")
	@ResponseBody
	public Msg export(HttpServletResponse response, HttpServletRequest request) throws Exception {
		OutputStream out = null;
		response.setHeader("Content-Disposition", "attachment;filename=stu.xls");// 下载文件的标识符，将文件内容直接显示在页面
																					// attachment
		response.setContentType("application/x-download");// 下载类型
		studentservice.export(all, out, response);
		return Msg.success();
	}

	/**
	 * 导出缺勤学生信息
	 * 
	 * @return Msg
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/exportabsent")
	@ResponseBody
	public Msg exportabsent(HttpServletResponse response, HttpServletRequest request) throws Exception {
		OutputStream out = null;
		response.setHeader("Content-Disposition", "attachment;filename=stu_absent.xls");// 下载文件的标识符，将文件内容直接显示在页面
																						// attachment
		response.setContentType("application/x-download");// 下载类型
		studentservice.exportabsent(all, out, response);
		return Msg.success();
	}

	/**
	 * 修改密码
	 * 
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Msg updatePassowrd(HttpServletResponse rep, HttpServletRequest req) {
		String old = req.getParameter("old");
		String newp = req.getParameter("new");
		Student stu = studentservice.confirm(stuid, old);
		if (stu != null) {
			stu.setStuPassword(newp);
			studentservice.updatepassword(stu);
		} else {
			return Msg.fail().add("error", "原密码错误");
		}
		return Msg.success();
	}

	/**
	 * 学生查询自己的缺勤信息
	 * 
	 * @return
	 */
	@RequestMapping("/lack/{pn}")
	@ResponseBody
	public Msg lack(@PathVariable(value = "pn") Integer pn) {
		List<StudentInfo> stuinfos = studentservice.lack(stuid);
		Map<String, Integer> map = new HashMap<>();
		for (StudentInfo studentInfo : stuinfos) {
			if (!map.containsKey(studentInfo.getStuCoursename())) {
				map.put(studentInfo.getStuCoursename(), 1);
			} else {
				map.put(studentInfo.getStuCoursename(), map.get(studentInfo.getStuCoursename()) + 1);
			}
		}
		String abMsg = null;
		StringBuffer sb = new StringBuffer();
		sb.append("【");
		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			int value = map.get(key);
			// System.out.println(key + "--->" + value);
			if (value >= 3) {
				sb.append(key + " ");
			}
		}
		sb.append("】");
		abMsg = sb + "缺勤已经达到或超过3次，超过3次将无法参加考试";

		PageHelper.startPage(pn, 10);
		List<StudentInfo> list = studentservice.lack(stuid);
		PageInfo pageinfo = new PageInfo(list, 5);
		return Msg.success().add("pageinfo", pageinfo).add("count", abMsg);
	}

	/**
	 * 获取上课的学生信息
	 * 
	 * @return
	 */
	@RequestMapping("/begin/{pn}")
	@ResponseBody
	public Msg begin(@PathVariable(value = "pn") Integer pn, StudentInfo stuinfo, Student stu) {
		 System.out.println("課程名"+stuinfo.getStuCoursename()+"班级名" +stu.getStuClassname()
		 +"周次"+stuinfo.getStuWeek()+"星期"+stuinfo.getStuWeekday());
		if (stuinfo.getStuWeek()==null || stuinfo.getStuWeekday().equals("")
				|| stuinfo.getStuCoursename().equals("")||stu.getStuClassname().equals("")) {
			return Msg.fail().add("msg", "信息不能为空");
		}else {
			updateinfo=stuinfo;
			PageHelper.startPage(pn, 40);
			List<Student> lists = studentservice.begin(stuinfo, stu.getStuClassname());
			PageInfo pageinfo = new PageInfo(lists, 5);
			return Msg.success().add("pageinfo", pageinfo);
		}
	}

	/**
	 * 老师的条件查询缺勤信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/absent/{pn}", method = RequestMethod.POST)
	@ResponseBody
	public Msg Absent(@PathVariable(value = "pn") Integer pn, Student stu, StudentInfo info) {
		System.out.println(stu.getStuClassname() + info.getStuCoursename());
		if (stu.getStuClassname().equals("") && info.getStuCoursename().equals("")) {
			return Msg.fail().add("error", "请输入正确的查询条件");
		} else if (!stu.getStuClassname().equals("") && info.getStuCoursename().equals("")) {// 按班级查询
			System.out.println("按班级查询");
			PageHelper.startPage(pn, 10);
			List<Student> students = studentservice.absentByclassname(stu.getStuClassname());
			all = students;
			PageInfo pageinfo = new PageInfo(students, 5);
			return Msg.success().add("pageinfo", pageinfo);
		} else if (stu.getStuClassname().equals("") && !info.getStuCoursename().equals("")) {// 按课程名查询
			System.out.println("按课程名");
			all = studentservice.absentByCoursename(info.getStuCoursename());
			PageHelper.startPage(pn, 10);
			List<Student> students = studentservice.absentByCoursename(info.getStuCoursename());
			PageInfo pageinfo = new PageInfo(students, 5);
			return Msg.success().add("pageinfo", pageinfo);
		} else {// 混合查询
			System.out.println("混合查询");
			all = studentservice.absent(stu.getStuClassname(), info.getStuCoursename());
			grades = studentservice.absent(stu.getStuClassname(), info.getStuCoursename());
			PageHelper.startPage(pn, 10);
			List<Student> students = studentservice.absent(stu.getStuClassname(), info.getStuCoursename());
			PageInfo pageinfo = new PageInfo(students, 5);
			return Msg.success().add("pageinfo", pageinfo);
		}
	}

	/**
	 * 获取学生平时分 需要选择一个班级的一门课
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/weight", method = RequestMethod.POST)
	@ResponseBody
	public Msg weight(@RequestParam(value = "weight") String rate,HttpServletResponse response) throws Exception {
		if (grades.size() > 0) {
			double weight = Double.parseDouble(rate);
			String classname = null;
			String coursename = null;
			Map<String,Integer> map = new HashMap<>();
			 Map<String,String> map2=new HashMap<>();
			for (Student student : grades) {
				classname = student.getStuClassname();
				coursename = student.getStuinfo().getStuCoursename();
				if (!map.containsKey(student.getStuinfo().getStuinfoId())) {
					map.put(student.getStuinfo().getStuinfoId(), 1);
					map2.put(student.getStuinfo().getStuinfoId(), student.getStuName());
					//System.out.println("执行"+student.getStuinfo().getStuinfoId());
				} else {
					map.put(student.getStuinfo().getStuinfoId(), map.get(student.getStuinfo().getStuinfoId()) + 1);
				//	System.out.println("相加"+student.getStuinfo().getStuinfoId());
				}
			}
			double grade;
			Set<String> set = map.keySet();
			Iterator<String> iterator = set.iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				int value = map.get(key);
				String name=map2.get(key);
				System.out.println("name"+name);
				System.out.println(key+"-->"+value);
				if (value > 3) {
					grade = 0;
				//	System.out.println(key+"-->"+grade);
				} else {
					grade = (100 - value * 10) * weight;
					//System.out.println(key+"-->"+grade);
				}
				exportinfo.add(new GradeInfo(key, classname,(int)grade, coursename,name));
				studentservice.insert(key, classname, coursename, grade);
			}
			return Msg.success();
		} else {
			return Msg.fail().add("error", "查询的信息需要班级和课程名同时查询");
		}
	}
	
	/**
	 * 导出成绩信息
	 * @return
	 */
	@RequestMapping("/exportgrade")
	@ResponseBody
	public Msg exportGrade(HttpServletResponse response, HttpServletRequest request) throws Exception {
		OutputStream out = null;
		response.setHeader("Content-Disposition", "attachment;filename=grade.xls");// 下载文件的标识符，将文件内容直接显示在页面
		response.setContentType("application/x-download");// 下载类型
		studentservice.exportgrade(exportinfo, out, response);
		return Msg.success();
	}
	
	/**
	 * 跟新评价信息
	 * @return
	 */
	@RequestMapping(value="/remarkupdate/{stuId}",method=RequestMethod.PUT)
	@ResponseBody
	public Msg updateremark(@PathVariable(value="stuId")String id,@RequestParam("Remark")String msg){
		System.out.println(id+"-->"+msg);
		studentservice.updateremark(id,msg,updateinfo);
		return Msg.success();
	}
}
