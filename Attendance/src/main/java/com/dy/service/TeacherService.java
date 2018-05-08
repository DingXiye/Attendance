package com.dy.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.TabableView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dy.bean.Student;
import com.dy.bean.Teacher;
import com.dy.bean.TeacherExample;
import com.dy.bean.TeacherExample.Criteria;
import com.dy.dao.TeacherMapper;
import com.dy.utils.Export;
import com.dy.utils.Import;

@Service
public class TeacherService {
	@Autowired
	private TeacherMapper teacherMapper;

	/**
	 * 验证老师登录信息
	 * 
	 * @param userid
	 * @param password
	 * @return
	 */
	public Teacher confirm(String userid, String password) {
		List<Teacher> list = new ArrayList<Teacher>();
		TeacherExample example = new TeacherExample();
		Criteria criteria = example.createCriteria();
		criteria.andTecIdEqualTo(userid);
		list = teacherMapper.selectByExample(example);
		for (Teacher tea : list) {
			if (tea != null && tea.getTecPassword().equals(password)) {
				return tea;
			}
		}
		return null;
	}

	/**
	 * 获取所有老师信息
	 * 
	 * @return
	 */
	public List<Teacher> getall() {
		List<Teacher> list = teacherMapper.selectByExample(null);
		return list;
	}

	/**
	 * 根据课程名查询
	 * 
	 * @param coursename
	 * @return
	 */
	public List<Teacher> selectbyCoursename(String coursename) {
		TeacherExample example = new TeacherExample();
		Criteria criteria = example.createCriteria();
		criteria.andCoursenameEqualTo(coursename);
		List<Teacher> teas = teacherMapper.selectByExample(example);
		return teas;
	}

	/**
	 * 根据工号查询
	 * 
	 * @param tecId
	 * @return
	 */
	public List<Teacher> selectbyteaid(String tecId) {
		TeacherExample example = new TeacherExample();
		Criteria criteria = example.createCriteria();
		criteria.andTecIdEqualTo(tecId);
		List<Teacher> teas = teacherMapper.selectByExample(example);
		return teas;
	}

	/**
	 * 添加老师信息,默认密码为1234
	 * 
	 * @param tea
	 */
	public void add(Teacher tea) {
		tea.setTecPassword("1234");
		teacherMapper.insert(tea);
	}

	/**
	 * 单个删除
	 * 
	 * @param id
	 */
	public void deleteone(String id) {
		teacherMapper.deleteByPrimaryKey(Integer.parseInt(id));
	}

	/**
	 * 批量删除
	 * 
	 * @param list
	 */
	public void deleteBatch(List<Integer> list) {
		TeacherExample example = new TeacherExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(list);
		teacherMapper.deleteByExample(example);
	}

	/**
	 * 根据id查找一个老师信息
	 * 
	 * @param id
	 * @return
	 */
	public Teacher selectbyid(String id) {
		return teacherMapper.selectByPrimaryKey(Integer.parseInt(id));
	}

	/**
	 * 跟新老师数据
	 * 
	 * @param teacher
	 */
	public void update(Teacher teacher) {
		teacher.setTecId(teacher.getTecId());
		teacherMapper.updateByPrimaryKeySelective(teacher);
	}

	/**
	 * 导出老师信息
	 * 
	 * @param list
	 * @throws IOException
	 */
	public void export(List<Teacher> list, HttpServletResponse response, OutputStream out) throws IOException {
		Export export = new Export();
		export.createtea(list, response, out);
	}

	/**
	 * 导入老师信息
	 * 
	 * @param realpath
	 * @throws Exception
	 */
	public void importtea(String realpath) throws Exception {
		List<Teacher> list = Import.readExceltea(realpath);
		for (Teacher teacher : list) {
			TeacherExample example=new TeacherExample();
			Criteria c=example.createCriteria();
			c.andClassnameEqualTo(teacher.getClassname());
			c.andCoursenameEqualTo(teacher.getCoursename());
			c.andTecPasswordEqualTo(teacher.getTecPassword());
			c.andTecNameEqualTo(teacher.getTecName());
			c.andTecIdEqualTo(teacher.getTecId());
			List<Teacher> tea =  teacherMapper.selectByExample(example);// 判断是否已经添加
			System.out.println(tea.size());
			if (tea.isEmpty()) {
				teacherMapper.insert(teacher);
			} else {
				continue;
			}
		}
	}
}
