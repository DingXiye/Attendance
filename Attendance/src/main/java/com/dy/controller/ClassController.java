package com.dy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.bean.Msg;
import com.dy.service.ClassService;

@Controller
public class ClassController {
	@Autowired
	private ClassService clsService;
	
	@RequestMapping("/getclass")
	@ResponseBody
	public Msg getClasses(){
		List<com.dy.bean.Class> list=clsService.getcls();
		return Msg.success().add("classes", list);
	}
}
