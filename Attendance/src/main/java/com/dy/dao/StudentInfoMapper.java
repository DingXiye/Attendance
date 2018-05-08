package com.dy.dao;

import com.dy.bean.StudentInfo;
import com.dy.bean.StudentInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentInfoMapper {
    long countByExample(StudentInfoExample example);

    int deleteByExample(StudentInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    List<StudentInfo> selectByExample(StudentInfoExample example);

    StudentInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentInfo record, @Param("example") StudentInfoExample example);

    int updateByExample(@Param("record") StudentInfo record, @Param("example") StudentInfoExample example);

    int updateByPrimaryKeySelective(StudentInfo record);

    //根据stuinfoid跟新remark
	void updatebyid(String id, String msg);

	//修改出勤信息
	void updateAttendance(String arg0, Integer arg1, String arg2, String arg3, String arg4, String arg5);

	//根据学号查看详细信息
	StudentInfo selectByinfoid(String sid);
}