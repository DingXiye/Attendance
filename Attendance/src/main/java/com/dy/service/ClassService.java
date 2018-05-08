package com.dy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dy.dao.ClassMapper;

@Service
public class ClassService {
	@Autowired
	private ClassMapper clsMapper;

	public List<com.dy.bean.Class> getcls() {

		return clsMapper.selectByExample(null);
	}

}
