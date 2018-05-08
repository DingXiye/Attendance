package com.dy.service;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dy.bean.GradeInfo;
import com.dy.bean.Student;
import com.dy.bean.StudentExample;
import com.dy.bean.StudentExample.Criteria;
import com.dy.bean.StudentInfo;
import com.dy.bean.StudentInfoExample;
import com.dy.dao.GradeInfoMapper;
import com.dy.dao.StudentInfoMapper;
import com.dy.dao.StudentMapper;
import com.dy.utils.Export;
import com.dy.utils.Import;
import com.dy.utils.Verify;

@Service
public class StudentService {
	@Autowired
	private StudentMapper studentmapper;
	@Autowired
	private StudentInfoMapper studentInfoMapper;
	@Autowired
	private GradeInfoMapper gradeInfoMapper;

	private List<Student> stus = new ArrayList<>();// 记录上课的学生信息
	public StudentInfo info;
	/**
	 * 学生验证
	 * 
	 * @param stuid
	 * @param stupass
	 * @return Student
	 */
	public Student confirm(String stuid, String stupass) {
		Student stu = studentmapper.selectByPrimaryKey(stuid);
		if (stu != null && stu.getStuPassword().equals(stupass)) {
			return stu;
		}
		return null;
	}

	/**
	 * 获取所有学生信息
	 * 
	 * @return List<Student>
	 */
	public List<Student> getAll() {
		List<Student> students = studentmapper.selectByExample(null);
		return students;
	}

	/**
	 * 导入学生信息
	 * 
	 * @param filename
	 * @throws Exception
	 */
	public void importstu(String filename) throws Exception {
		List<Student> list = Import.readExcel(filename);
		for (Student student : list) {
			Student stu = studentmapper.selectByPrimaryKey(student.getStuId());// 判断是否已经添加
			if (stu != null) {
				continue;
			} else {
				studentmapper.insert(student);
			}
		}
	}

	/**
	 * 按班级名查询,自己设置条件
	 * 
	 * @param stuClassname
	 * @return List<Student>
	 */
	public List<Student> selectbyclassname(String sclassname) {
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andStuClassnameEqualTo(sclassname);
		List<Student> students = studentmapper.selectByExample(example);
		return students;
	}

	/**
	 * 根据学号查询
	 * 
	 * @param stuId
	 * @return List<Student>
	 */
	public List<Student> selectbyid(String sid) {
		List<Student> list = new ArrayList<>();
		Student stu = studentmapper.selectByPrimaryKey(sid);
		if (stu != null) {
			list.add(stu);
		}
		System.out.println(list.size());
		return list;
	}

	/**
	 * 添加一个学生
	 * 
	 * @param Student
	 */
	public void savestu(Student stu) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sf.format(new Date().getTime());
		stu.setStuRegisterdate(date);
		stu.setStuPassword(stu.getStuId());
		studentmapper.insert(stu);
	}

	/**
	 * 学生查重
	 * 
	 * @param stuId
	 * @return boolean
	 */
	public boolean check(String sid) {
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andStuIdEqualTo(sid);
		long count = studentmapper.countByExample(example);
		return count == 0;
	}

	/**
	 * 删除单个学生
	 * 
	 * @param stuId
	 */
	public void deleteById(String id) {
		studentmapper.deleteByPrimaryKey(id);
	}

	/**
	 * 
	 * 批量删除
	 * 
	 * @param List<String>
	 */
	public void deleteBatch(List<String> ids) {
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andStuIdIn(ids);
		studentmapper.deleteByExample(example);
	}

	/**
	 * 根据id查找
	 * 
	 * @param stuId
	 * @return Student
	 */
	public Student getbyid(String id) {
		Student stu = studentmapper.selectByPrimaryKey(id);
		return stu;
	}

	/**
	 * 编辑跟新用户信息
	 * 
	 * @param student
	 */
	public void update(Student stu) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String date = stu.getStuRegisterdate();
		stu.setStuRegisterdate(date);
		stu.setStuPassword(stu.getStuId());
		studentmapper.updateByPrimaryKey(stu);
	}

	/**
	 * 修改密码
	 * 
	 * @param student
	 */
	public void updatepassword(Student stu) {
		studentmapper.updateByPrimaryKey(stu);
	}

	/**
	 * 学生查询缺课信息
	 * 
	 * @param stuId
	 * @return List<Student>
	 */
	public List<StudentInfo> lack(String stuid) {
		List<StudentInfo> list = new ArrayList<>();
		StudentInfoExample example = new StudentInfoExample();
		com.dy.bean.StudentInfoExample.Criteria criteria = example.createCriteria();
		criteria.andStuinfoIdEqualTo(stuid);
		criteria.andStuAttendanceEqualTo("缺勤");
		list = studentInfoMapper.selectByExample(example);
		return list;
	}

	/**
	 * 导出所有学生信息
	 * 
	 * @param List<Student>
	 * @throws IOException
	 */
	public void export(List<Student> all, OutputStream out, HttpServletResponse response) throws IOException {
		Export export = new Export();
		export.create(all, out, response);
	}

	/**
	 * 上课点名的名单
	 * 
	 * @param StudentInfo
	 * @param classname
	 * @return List<Student>
	 */
	public List<Student> begin(StudentInfo stuinfo, String classname) {
		info=stuinfo;
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andStuClassnameEqualTo(classname);
		List<Student> students = studentmapper.selectByExample(example);
		System.out.println(students.size());
		for (int i = 0; i < students.size(); i++) {
			StudentInfo record = new StudentInfo();
			record.setStuinfoId(students.get(i).getStuId());
			record.setStuWeek(stuinfo.getStuWeek());
			record.setStuWeekday(stuinfo.getStuWeekday());
			record.setStuCoursename(stuinfo.getStuCoursename());
			record.setStuAttendance("缺勤");
			studentInfoMapper.insert(record);
		}
		List<Student> lists = studentmapper.selectWithStudent(classname, stuinfo.getStuWeekday(), stuinfo.getStuWeek(),
				stuinfo.getStuCoursename());
		stus = lists;
		return lists;

	}

	/**
	 * 通过班级名查询缺勤信息
	 * 
	 * @param stuClassname
	 * @return List<Student>
	 */
	public List<Student> absentByclassname(String stuClassname) {
		List<Student> students = studentmapper.selectbyClassnameWithinfo("缺勤", stuClassname);
		System.out.println(students.size());
		return students;
	}

	/**
	 * 根据课程名查询
	 * 
	 * @param stuCoursename
	 * @return List<Student>
	 */
	public List<Student> absentByCoursename(String stuCoursename) {
		List<Student> students = studentmapper.selectbyCoursenameWithinfo("缺勤", stuCoursename);
		for (Student student : students) {
			System.out.println(student.toString());
		}
		return students;
	}

	/**
	 * 根据班级名和课程名共同查询缺勤信息
	 * 
	 * @param stuClassname
	 * @param stuCoursename
	 * @return List<Student>
	 */
	public List<Student> absent(String stuClassname, String stuCoursename) {
		List<Student> students = studentmapper.selectbyCoursenameandClassnameWithinfo("缺勤", stuClassname,
				stuCoursename);
		return students;
	}

	/**
	 * 导出缺勤学生信息
	 * 
	 * @param all
	 * @param out
	 * @param response
	 * @throws IOException
	 */
	public void exportabsent(List<Student> all, OutputStream out, HttpServletResponse response) throws IOException {
		Export export = new Export();
		export.createabsent(all, out, response);
	}

	/**
	 * 添加关于成绩的记录
	 * 
	 * @param key
	 * @param name
	 * @param classname
	 * @param coursename
	 * @param grade
	 */
	public void insert(String stuid, String classname, String coursename, double grade) {
		GradeInfo record = new GradeInfo();
		record.setStuId(stuid);
		Student student = studentmapper.selectByPrimaryKey(stuid);
		record.setStuClassname(classname);
		record.setStuCoursename(coursename);
		record.setStuGrade((int) grade);
		record.setStuName(student.getStuName());
		gradeInfoMapper.insert(record);
	}

	/**
	 * 导出成绩单
	 * 
	 * @param grades
	 * @param out
	 * @param response
	 * @throws IOException
	 */
	public void exportgrade(List<GradeInfo> grades, OutputStream out, HttpServletResponse response) throws IOException {
		Export export = new Export();
		export.createGrade(grades, out, response);
	}

	/**
	 * 通过班级和课程名查询成绩
	 * 
	 * @param classname
	 * @param coursename
	 * @return
	 */
	public List<GradeInfo> selectbyclassnameandcoursename(String classname, String coursename) {
		List<GradeInfo> list = gradeInfoMapper.selectbyCoursenameandClassnameWithGrade(classname, coursename);
		return list;
	}

	/**
	 * 根据学号跟新备注信息
	 * 
	 * @param id
	 * @param msg
	 */
	public void updateremark(String id, String msg, StudentInfo info) {
//		Student stu = studentmapper.selectByPrimaryKey(id);
		// System.out.println(stu.toString());
		// System.out.println(info.toString());
		info.setStuinfoId(id);
		info.setStuAttendance("出勤");
		info.setStuRemark(msg);
		System.out.println(info.toString());
		studentInfoMapper.updateByPrimaryKeySelective(info);
	}
//
//	/**
//	 * 指纹注册
//	 * 
//	 * @param sid
//	 * @param regtemp
//	 */
//	public void toregfinger(String sid, String regtemp) {
//		studentmapper.updateById(sid, regtemp);
//	}
//
//	/**
//	 * 指纹对比
//	 * @param updateinfo 
//	 * 
//	 * @param sid
//	 *            学号
//	 * @param verifytem
//	 *            对比指纹
//	 */
//	public void verifyfinger(StudentInfo updateinfo, String sid, String verifytem) {
//		Student student = studentmapper.selectByPrimaryKey(sid);
//		System.out.println(student.toString());
//		System.out.println(updateinfo.toString());
//		Verify verfy = new Verify();
//		boolean flag = verfy.test(student.getStuFingerprint(), verifytem);
//		System.out.println("对比结果："+flag);
//		if (flag) {
//			updateinfo.setStuAttendance("出勤");
//			updateinfo.setStuinfoId(sid);
//			System.out.println(updateinfo.toString());
//			studentInfoMapper.updateByPrimaryKeySelective(updateinfo);
//		}
//	}

}
