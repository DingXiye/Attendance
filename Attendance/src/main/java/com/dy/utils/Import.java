package com.dy.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.dy.bean.Student;
import com.dy.bean.Teacher;

/**
 * 实现导入Excel中的数据,需要导入poi包
 * 只能导入xls文件 
 * @author Agustin
 *
 */
public class Import {
	/**
	 * 导入学生信息
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	public static List<Student> readExcel(String filename) throws Exception {
		System.out.println("filename"+filename);
		InputStream is = new FileInputStream(filename);
		HSSFWorkbook workbook = new HSSFWorkbook(is);
		Student s = null;
		List<Student> list = new ArrayList<Student>();
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {// 遍历数据表
			HSSFSheet hs = workbook.getSheetAt(i);
			if (hs == null) {
				continue;
			}
			for (int j = 1; j <= hs.getLastRowNum(); j++) {// 遍历表中每行是否有数据
				HSSFRow hassrow = hs.getRow(j);
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				if (hassrow != null) {
					s = new Student();
					HSSFCell id = hassrow.getCell(0);// 遍历行中每个单元格
					HSSFCell name = hassrow.getCell(1);
					HSSFCell psw = hassrow.getCell(2);
					HSSFCell classname = hassrow.getCell(3);
					HSSFCell date = hassrow.getCell(4);
					s.setStuId(getValue(id));
					s.setStuName(getValue(name));
					s.setStuPassword(getValue(psw));
					s.setStuClassname(getValue(classname));
					s.setStuRegisterdate(getValue(date));
					list.add(s);
				}
			}
		}
		return list;
	}

	/**
	 * 获取单元格的值
	 * 
	 * @param hc
	 * @return 单元格中的值
	 */
	public static String getValue(HSSFCell hc) {
		if (hc.getCellType() == hc.CELL_TYPE_BOOLEAN) {
			return String.valueOf(hc.getBooleanCellValue());
		} else if (hc.getCellType() == hc.CELL_TYPE_NUMERIC) {
			return String.valueOf(hc.getNumericCellValue());
		} else {
			return String.valueOf(hc.getStringCellValue());
		}
	}

	/**
	 * 导入老师信息
	 * @param realpath
	 * @return
	 * @throws Exception 
	 */
	public static List<Teacher> readExceltea(String realpath) throws Exception {
		System.out.println("filename"+realpath);
		InputStream is = new FileInputStream(realpath);
		HSSFWorkbook workbook = new HSSFWorkbook(is);
		Teacher t = null;
		List<Teacher> list = new ArrayList<Teacher>();
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {// 遍历数据表
			HSSFSheet hs = workbook.getSheetAt(i);
			if (hs == null) {
				continue;
			}
			for (int j = 1; j <= hs.getLastRowNum(); j++) {// 遍历表中每行是否有数据
				HSSFRow hassrow = hs.getRow(j);
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				if (hassrow != null) {
					t = new Teacher();
					HSSFCell id = hassrow.getCell(0);// 遍历行中每个单元格
					HSSFCell name = hassrow.getCell(1);
					HSSFCell psw = hassrow.getCell(2);
					HSSFCell coursename = hassrow.getCell(4);
					HSSFCell classname = hassrow.getCell(3);
					t.setTecId(getValue(id));
					t.setTecName(getValue(name));
					t.setTecPassword(getValue(psw));
					t.setClassname(getValue(classname));
					t.setCoursename(getValue(coursename));
					list.add(t);
				}
			}
		}
		return list;
	}
}