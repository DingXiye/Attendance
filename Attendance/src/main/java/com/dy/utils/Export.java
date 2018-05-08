package com.dy.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor.GREEN;

import com.dy.bean.GradeInfo;
import com.dy.bean.Student;
import com.dy.bean.Teacher;

/**
 * 将数据导出生成excel文件
 * 
 * @author dingye
 *
 */
public class Export {
	/**
	 * 生成学生所有信息
	 * @throws IOException 
	 */
	@SuppressWarnings("deprecation")
	public  void create(List<Student> lists,OutputStream out,HttpServletResponse response) throws IOException {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();

		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("学生表一");
		sheet.setDefaultColumnWidth(20);//设置列宽
		
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);

		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		HSSFCell cell = row.createCell((short) 0); // 创建单元格
		cell.setCellValue("学号");
		cell.setCellStyle(style);

		cell = row.createCell((short) 1);
		cell.setCellValue("姓名");
		cell.setCellStyle(style);

		cell = row.createCell((short) 2);
		cell.setCellValue("班级");
		cell.setCellStyle(style);
		
		cell = row.createCell((short) 3);
		cell.setCellValue("注册日期");
		cell.setCellStyle(style);


		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		List<Student> list = lists;
		
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow(i + 1);
			Student stu = (Student) list.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell((short) 0).setCellValue(stu.getStuId());
			row.createCell((short) 1).setCellValue(stu.getStuName());
			row.createCell((short) 2).setCellValue(stu.getStuClassname());
			row.createCell((short) 3).setCellValue(stu.getStuRegisterdate());
		}
		// 第六步，将文件存到指定位置
		try {
			out = response.getOutputStream();
			wb.write(out);
			System.out.println("生成文件成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	/**
	 * 导出关于老师的信息
	 * @param lists
	 * @param response
	 * @param out
	 * @throws IOException 
	 */
	public  void createtea(List<Teacher> lists,HttpServletResponse response,OutputStream out) throws IOException {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();

		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("学生表一");
		sheet.setDefaultColumnWidth(20);//设置列宽
		
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);

		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		HSSFCell cell = row.createCell((short) 0); // 创建单元格
		cell.setCellValue("工号");
		cell.setCellStyle(style);

		cell = row.createCell((short) 1);
		cell.setCellValue("姓名");
		cell.setCellStyle(style);

		cell = row.createCell((short) 2);
		cell.setCellValue("班级");
		cell.setCellStyle(style);
		
		cell = row.createCell((short) 3);
		cell.setCellValue("课程名");
		cell.setCellStyle(style);


		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		List<Teacher> list = lists;
		
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow(i + 1);
			Teacher tea= (Teacher) list.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell((short) 0).setCellValue(tea.getTecId());
			row.createCell((short) 1).setCellValue(tea.getTecName());
			row.createCell((short) 2).setCellValue(tea.getClassname());
			row.createCell((short) 3).setCellValue(tea.getCoursename());
		}
		// 第六步，将文件存到指定位置
		try {
			out=response.getOutputStream();//获取字节流
			wb.write(out);//将excel写入outputstream流中
			System.out.println("生成文件成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}

	/**
	 * 创建缺勤学生的文件
	 * @param all
	 * @param out
	 * @param response
	 * @throws IOException 
	 */
	public void createabsent(List<Student> all, OutputStream out, HttpServletResponse response) throws IOException {
		// 第一步，创建一个webbook，对应一个Excel文件
				HSSFWorkbook wb = new HSSFWorkbook();

				// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
				HSSFSheet sheet = wb.createSheet("学生表一");
				sheet.setDefaultColumnWidth(20);//设置列宽
				
				// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
				HSSFRow row = sheet.createRow((int) 0);

				// 第四步，创建单元格，并设置值表头 设置表头居中
				HSSFCellStyle style = wb.createCellStyle();
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

				HSSFCell cell = row.createCell((short) 0); // 创建单元格
				cell.setCellValue("学号");
				cell.setCellStyle(style);

				cell = row.createCell((short) 1);
				cell.setCellValue("姓名");
				cell.setCellStyle(style);

				cell = row.createCell((short) 2);
				cell.setCellValue("班级");
				cell.setCellStyle(style);
				
				cell = row.createCell((short) 3);
				cell.setCellValue("课程名");
				cell.setCellStyle(style);
				
				cell = row.createCell((short) 4);
				cell.setCellValue("周次");
				cell.setCellStyle(style);
				
				cell = row.createCell((short) 5);
				cell.setCellValue("星期");
				cell.setCellStyle(style);

				cell = row.createCell((short) 6);
				cell.setCellValue("备注");
				cell.setCellStyle(style);


				// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
				List<Student> list = all;
				
				for (int i = 0; i < list.size(); i++) {
					row = sheet.createRow(i + 1);
					Student stu=list.get(i);
					// 第四步，创建单元格，并设置值
					row.createCell((short) 0).setCellValue(stu.getStuinfo().getStuinfoId());
					row.createCell((short) 1).setCellValue(stu.getStuName());
					row.createCell((short) 2).setCellValue(stu.getStuClassname());
					row.createCell((short) 3).setCellValue(stu.getStuinfo().getStuCoursename());
					row.createCell((short) 4).setCellValue(stu.getStuinfo().getStuWeek());
					row.createCell((short) 5).setCellValue(stu.getStuinfo().getStuWeekday());
					row.createCell((short) 6).setCellValue(stu.getStuinfo().getStuRemark());
				}
				// 第六步，将文件存到指定位置
				try {
					out=response.getOutputStream();//获取字节流
					wb.write(out);//将excel写入outputstream流中
					System.out.println("生成文件成功!");
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					if(out!=null){
						out.close();
					}
				}
	}

	/**
	 * 导出成绩单详细方法
	 * @param grades
	 * @param out
	 * @param response
	 * @throws IOException 
	 */
	public void createGrade(List<GradeInfo> grades, OutputStream out, HttpServletResponse response) throws IOException {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();

		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("学生表一");
		sheet.setDefaultColumnWidth(20);//设置列宽
		
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);

		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		HSSFCell cell = row.createCell((short) 0); // 创建单元格
		cell.setCellValue("学号");
		cell.setCellStyle(style);

		cell = row.createCell((short) 1);
		cell.setCellValue("姓名");
		cell.setCellStyle(style);

		cell = row.createCell((short) 2);
		cell.setCellValue("班级");
		cell.setCellStyle(style);
		
		cell = row.createCell((short) 3);
		cell.setCellValue("课程名");
		cell.setCellStyle(style);
		
		cell = row.createCell((short) 4);
		cell.setCellValue("成绩");
		cell.setCellStyle(style);

		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		List<GradeInfo> list = grades;
		
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow(i + 1);
			GradeInfo gradeInfo=list.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell((short) 0).setCellValue(gradeInfo.getStuId());
			row.createCell((short) 1).setCellValue(gradeInfo.getStuName());
			row.createCell((short) 2).setCellValue(gradeInfo.getStuClassname());
			row.createCell((short) 3).setCellValue(gradeInfo.getStuCoursename());
			row.createCell((short) 4).setCellValue(gradeInfo.getStuGrade());
		}
		// 第六步，将文件存到指定位置
		try {
			out=response.getOutputStream();//获取字节流
			wb.write(out);//将excel写入outputstream流中
			System.out.println("生成文件成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
}
