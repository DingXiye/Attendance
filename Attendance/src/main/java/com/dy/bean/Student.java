package com.dy.bean;

import java.util.Arrays;

import javax.validation.constraints.Pattern;

public class Student {
	@Pattern(regexp = "(s\\d{4})", message = "id必须为s+4位数字")
	private String stuId;

	private String stuName;

	private String stuPassword;

	private String stuRegisterdate;

	private String stuClassname;

	private String stuFingerprint;

	private StudentInfo stuinfo;

	public StudentInfo getStuinfo() {
		return stuinfo;
	}

	public void setStuinfo(StudentInfo stuinfo) {
		this.stuinfo = stuinfo;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId == null ? null : stuId.trim();
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName == null ? null : stuName.trim();
	}

	public String getStuPassword() {
		return stuPassword;
	}

	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword == null ? null : stuPassword.trim();
	}

	public String getStuRegisterdate() {
		return stuRegisterdate;
	}

	public void setStuRegisterdate(String stuRegisterdate) {
		this.stuRegisterdate = stuRegisterdate == null ? null : stuRegisterdate.trim();
	}

	public String getStuClassname() {
		return stuClassname;
	}

	public void setStuClassname(String stuClassname) {
		this.stuClassname = stuClassname == null ? null : stuClassname.trim();
	}

	public String getStuFingerprint() {
		return stuFingerprint;
	}

	public void setStuFingerprint(String stuFingerprint) {
		this.stuFingerprint = stuFingerprint;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuPassword=" + stuPassword
				+ ", stuRegisterdate=" + stuRegisterdate + ", stuClassname=" + stuClassname + ", stuFingerprint="
				+ stuFingerprint + ", stuinfo=" + stuinfo + "]";
	}
	
	
}