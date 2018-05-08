package com.dy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.bean.Course;
import com.dy.bean.Msg;
import com.dy.service.CourseService;

/**
 * 处理课程信息
 * @author Administrator
 *
 */
@Controller
public class CourseController {

	@Autowired
	private CourseService  courseService;
	
	/**
	 * 获得所有课程名
	 * @return
	 */
	@RequestMapping("/getcourse")
	@ResponseBody
	public Msg getCourse(){
		List<Course> list=courseService.getCou();
		return Msg.success().add("couses", list);
	}
}
