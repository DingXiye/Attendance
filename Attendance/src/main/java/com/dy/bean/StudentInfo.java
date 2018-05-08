package com.dy.bean;

public class StudentInfo {
    private Integer id;

    private String stuinfoId;

    private Integer stuWeek;

    private String stuWeekday;

    private String stuAttendance;

    private String stuRemark;

    private String stuCoursename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuinfoId() {
        return stuinfoId;
    }

    public void setStuinfoId(String stuinfoId) {
        this.stuinfoId = stuinfoId == null ? null : stuinfoId.trim();
    }

    public Integer getStuWeek() {
        return stuWeek;
    }

    public void setStuWeek(Integer stuWeek) {
        this.stuWeek = stuWeek;
    }

    public String getStuWeekday() {
        return stuWeekday;
    }

    public void setStuWeekday(String stuWeekday) {
        this.stuWeekday = stuWeekday == null ? null : stuWeekday.trim();
    }

    public String getStuAttendance() {
        return stuAttendance;
    }

    public void setStuAttendance(String stuAttendance) {
        this.stuAttendance = stuAttendance == null ? null : stuAttendance.trim();
    }

    public String getStuRemark() {
        return stuRemark;
    }

    public void setStuRemark(String stuRemark) {
        this.stuRemark = stuRemark == null ? null : stuRemark.trim();
    }

    public String getStuCoursename() {
        return stuCoursename;
    }

    public void setStuCoursename(String stuCoursename) {
        this.stuCoursename = stuCoursename == null ? null : stuCoursename.trim();
    }

	@Override
	public String toString() {
		return "StudentInfo [id=" + id + ", stuinfoId=" + stuinfoId + ", stuWeek=" + stuWeek + ", stuWeekday="
				+ stuWeekday + ", stuAttendance=" + stuAttendance + ", stuRemark=" + stuRemark + ", stuCoursename="
				+ stuCoursename + "]";
	}
    
    
}