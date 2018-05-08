package com.dy.dao;

import com.dy.bean.Student;
import com.dy.bean.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
	long countByExample(StudentExample example);

	int deleteByExample(StudentExample example);

	int deleteByPrimaryKey(String stuId);

	int insert(Student record);

	int insertSelective(Student record);

	List<Student> selectByExampleWithBLOBs(StudentExample example);

	List<Student> selectByExample(StudentExample example);

	// 老师上课时的班级信息
	List<Student> selectWithStudent(String Classname, String weekday, Integer week, String Coursename);

	// 老师根据班级名查询缺勤信息
	List<Student> selectbyClassnameWithinfo(String stuAttendance, String stuClassname);

	// 老师根据课程名查询缺勤信息
	List<Student> selectbyCoursenameWithinfo(String stuAttendance, String stuCoursename);

	// 老师根据课程名以及班级名查询缺勤信息
	List<Student> selectbyCoursenameandClassnameWithinfo(String stuAttendance, String stuClassname,
			String stuCoursename);

	Student selectByPrimaryKey(String stuId);
	
	//根据学号查找完整信息

	int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

	int updateByExampleWithBLOBs(@Param("record") Student record, @Param("example") StudentExample example);

	int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

	int updateByPrimaryKeySelective(Student record);

	int updateByPrimaryKeyWithBLOBs(Student record);

	int updateByPrimaryKey(Student record);

	List<Student> selectWithinfo(StudentExample example);

	//注册指纹
	void updateById(String sid, String regtemp);

//	//根据学号获取详细信息
//	Student selectByPrimaryKeywithInfo(String sid);
}