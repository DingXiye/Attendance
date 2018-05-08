package com.dy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dy.bean.Course;
import com.dy.dao.CourseMapper;

@Service
public class CourseService {

	@Autowired
	private CourseMapper couseMapper;
	
	/**
	 * 获取所有课程名
	 * @return
	 */
	public List<Course> getCou() {
		return couseMapper.selectByExample(null);
	}

}
