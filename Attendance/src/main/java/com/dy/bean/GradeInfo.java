package com.dy.bean;

public class GradeInfo {
    private Integer id;

    private String stuId;

    private String stuClassname;

    private Integer stuGrade;

    private String stuCoursename;

    private String stuName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getStuClassname() {
        return stuClassname;
    }

    public void setStuClassname(String stuClassname) {
        this.stuClassname = stuClassname == null ? null : stuClassname.trim();
    }

    public Integer getStuGrade() {
        return stuGrade;
    }

    public void setStuGrade(Integer stuGrade) {
        this.stuGrade = stuGrade;
    }

    public String getStuCoursename() {
        return stuCoursename;
    }

    public void setStuCoursename(String stuCoursename) {
        this.stuCoursename = stuCoursename == null ? null : stuCoursename.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

	public GradeInfo( String stuId, String stuClassname, Integer stuGrade, String stuCoursename,String name) {
		super();
		this.stuId = stuId;
		this.stuClassname = stuClassname;
		this.stuGrade = stuGrade;
		this.stuCoursename = stuCoursename;
		this.stuName=name;
	}
    
    public GradeInfo() {
		// TODO Auto-generated constructor stub
	}
}