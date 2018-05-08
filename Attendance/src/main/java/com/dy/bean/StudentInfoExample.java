package com.dy.bean;

import java.util.ArrayList;
import java.util.List;

public class StudentInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStuinfoIdIsNull() {
            addCriterion("stuinfo_id is null");
            return (Criteria) this;
        }

        public Criteria andStuinfoIdIsNotNull() {
            addCriterion("stuinfo_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuinfoIdEqualTo(String value) {
            addCriterion("stuinfo_id =", value, "stuinfoId");
            return (Criteria) this;
        }

        public Criteria andStuinfoIdNotEqualTo(String value) {
            addCriterion("stuinfo_id <>", value, "stuinfoId");
            return (Criteria) this;
        }

        public Criteria andStuinfoIdGreaterThan(String value) {
            addCriterion("stuinfo_id >", value, "stuinfoId");
            return (Criteria) this;
        }

        public Criteria andStuinfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("stuinfo_id >=", value, "stuinfoId");
            return (Criteria) this;
        }

        public Criteria andStuinfoIdLessThan(String value) {
            addCriterion("stuinfo_id <", value, "stuinfoId");
            return (Criteria) this;
        }

        public Criteria andStuinfoIdLessThanOrEqualTo(String value) {
            addCriterion("stuinfo_id <=", value, "stuinfoId");
            return (Criteria) this;
        }

        public Criteria andStuinfoIdLike(String value) {
            addCriterion("stuinfo_id like", value, "stuinfoId");
            return (Criteria) this;
        }

        public Criteria andStuinfoIdNotLike(String value) {
            addCriterion("stuinfo_id not like", value, "stuinfoId");
            return (Criteria) this;
        }

        public Criteria andStuinfoIdIn(List<String> values) {
            addCriterion("stuinfo_id in", values, "stuinfoId");
            return (Criteria) this;
        }

        public Criteria andStuinfoIdNotIn(List<String> values) {
            addCriterion("stuinfo_id not in", values, "stuinfoId");
            return (Criteria) this;
        }

        public Criteria andStuinfoIdBetween(String value1, String value2) {
            addCriterion("stuinfo_id between", value1, value2, "stuinfoId");
            return (Criteria) this;
        }

        public Criteria andStuinfoIdNotBetween(String value1, String value2) {
            addCriterion("stuinfo_id not between", value1, value2, "stuinfoId");
            return (Criteria) this;
        }

        public Criteria andStuWeekIsNull() {
            addCriterion("stu_week is null");
            return (Criteria) this;
        }

        public Criteria andStuWeekIsNotNull() {
            addCriterion("stu_week is not null");
            return (Criteria) this;
        }

        public Criteria andStuWeekEqualTo(Integer value) {
            addCriterion("stu_week =", value, "stuWeek");
            return (Criteria) this;
        }

        public Criteria andStuWeekNotEqualTo(Integer value) {
            addCriterion("stu_week <>", value, "stuWeek");
            return (Criteria) this;
        }

        public Criteria andStuWeekGreaterThan(Integer value) {
            addCriterion("stu_week >", value, "stuWeek");
            return (Criteria) this;
        }

        public Criteria andStuWeekGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_week >=", value, "stuWeek");
            return (Criteria) this;
        }

        public Criteria andStuWeekLessThan(Integer value) {
            addCriterion("stu_week <", value, "stuWeek");
            return (Criteria) this;
        }

        public Criteria andStuWeekLessThanOrEqualTo(Integer value) {
            addCriterion("stu_week <=", value, "stuWeek");
            return (Criteria) this;
        }

        public Criteria andStuWeekIn(List<Integer> values) {
            addCriterion("stu_week in", values, "stuWeek");
            return (Criteria) this;
        }

        public Criteria andStuWeekNotIn(List<Integer> values) {
            addCriterion("stu_week not in", values, "stuWeek");
            return (Criteria) this;
        }

        public Criteria andStuWeekBetween(Integer value1, Integer value2) {
            addCriterion("stu_week between", value1, value2, "stuWeek");
            return (Criteria) this;
        }

        public Criteria andStuWeekNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_week not between", value1, value2, "stuWeek");
            return (Criteria) this;
        }

        public Criteria andStuWeekdayIsNull() {
            addCriterion("stu_weekday is null");
            return (Criteria) this;
        }

        public Criteria andStuWeekdayIsNotNull() {
            addCriterion("stu_weekday is not null");
            return (Criteria) this;
        }

        public Criteria andStuWeekdayEqualTo(String value) {
            addCriterion("stu_weekday =", value, "stuWeekday");
            return (Criteria) this;
        }

        public Criteria andStuWeekdayNotEqualTo(String value) {
            addCriterion("stu_weekday <>", value, "stuWeekday");
            return (Criteria) this;
        }

        public Criteria andStuWeekdayGreaterThan(String value) {
            addCriterion("stu_weekday >", value, "stuWeekday");
            return (Criteria) this;
        }

        public Criteria andStuWeekdayGreaterThanOrEqualTo(String value) {
            addCriterion("stu_weekday >=", value, "stuWeekday");
            return (Criteria) this;
        }

        public Criteria andStuWeekdayLessThan(String value) {
            addCriterion("stu_weekday <", value, "stuWeekday");
            return (Criteria) this;
        }

        public Criteria andStuWeekdayLessThanOrEqualTo(String value) {
            addCriterion("stu_weekday <=", value, "stuWeekday");
            return (Criteria) this;
        }

        public Criteria andStuWeekdayLike(String value) {
            addCriterion("stu_weekday like", value, "stuWeekday");
            return (Criteria) this;
        }

        public Criteria andStuWeekdayNotLike(String value) {
            addCriterion("stu_weekday not like", value, "stuWeekday");
            return (Criteria) this;
        }

        public Criteria andStuWeekdayIn(List<String> values) {
            addCriterion("stu_weekday in", values, "stuWeekday");
            return (Criteria) this;
        }

        public Criteria andStuWeekdayNotIn(List<String> values) {
            addCriterion("stu_weekday not in", values, "stuWeekday");
            return (Criteria) this;
        }

        public Criteria andStuWeekdayBetween(String value1, String value2) {
            addCriterion("stu_weekday between", value1, value2, "stuWeekday");
            return (Criteria) this;
        }

        public Criteria andStuWeekdayNotBetween(String value1, String value2) {
            addCriterion("stu_weekday not between", value1, value2, "stuWeekday");
            return (Criteria) this;
        }

        public Criteria andStuAttendanceIsNull() {
            addCriterion("stu_attendance is null");
            return (Criteria) this;
        }

        public Criteria andStuAttendanceIsNotNull() {
            addCriterion("stu_attendance is not null");
            return (Criteria) this;
        }

        public Criteria andStuAttendanceEqualTo(String value) {
            addCriterion("stu_attendance =", value, "stuAttendance");
            return (Criteria) this;
        }

        public Criteria andStuAttendanceNotEqualTo(String value) {
            addCriterion("stu_attendance <>", value, "stuAttendance");
            return (Criteria) this;
        }

        public Criteria andStuAttendanceGreaterThan(String value) {
            addCriterion("stu_attendance >", value, "stuAttendance");
            return (Criteria) this;
        }

        public Criteria andStuAttendanceGreaterThanOrEqualTo(String value) {
            addCriterion("stu_attendance >=", value, "stuAttendance");
            return (Criteria) this;
        }

        public Criteria andStuAttendanceLessThan(String value) {
            addCriterion("stu_attendance <", value, "stuAttendance");
            return (Criteria) this;
        }

        public Criteria andStuAttendanceLessThanOrEqualTo(String value) {
            addCriterion("stu_attendance <=", value, "stuAttendance");
            return (Criteria) this;
        }

        public Criteria andStuAttendanceLike(String value) {
            addCriterion("stu_attendance like", value, "stuAttendance");
            return (Criteria) this;
        }

        public Criteria andStuAttendanceNotLike(String value) {
            addCriterion("stu_attendance not like", value, "stuAttendance");
            return (Criteria) this;
        }

        public Criteria andStuAttendanceIn(List<String> values) {
            addCriterion("stu_attendance in", values, "stuAttendance");
            return (Criteria) this;
        }

        public Criteria andStuAttendanceNotIn(List<String> values) {
            addCriterion("stu_attendance not in", values, "stuAttendance");
            return (Criteria) this;
        }

        public Criteria andStuAttendanceBetween(String value1, String value2) {
            addCriterion("stu_attendance between", value1, value2, "stuAttendance");
            return (Criteria) this;
        }

        public Criteria andStuAttendanceNotBetween(String value1, String value2) {
            addCriterion("stu_attendance not between", value1, value2, "stuAttendance");
            return (Criteria) this;
        }

        public Criteria andStuRemarkIsNull() {
            addCriterion("stu_remark is null");
            return (Criteria) this;
        }

        public Criteria andStuRemarkIsNotNull() {
            addCriterion("stu_remark is not null");
            return (Criteria) this;
        }

        public Criteria andStuRemarkEqualTo(String value) {
            addCriterion("stu_remark =", value, "stuRemark");
            return (Criteria) this;
        }

        public Criteria andStuRemarkNotEqualTo(String value) {
            addCriterion("stu_remark <>", value, "stuRemark");
            return (Criteria) this;
        }

        public Criteria andStuRemarkGreaterThan(String value) {
            addCriterion("stu_remark >", value, "stuRemark");
            return (Criteria) this;
        }

        public Criteria andStuRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("stu_remark >=", value, "stuRemark");
            return (Criteria) this;
        }

        public Criteria andStuRemarkLessThan(String value) {
            addCriterion("stu_remark <", value, "stuRemark");
            return (Criteria) this;
        }

        public Criteria andStuRemarkLessThanOrEqualTo(String value) {
            addCriterion("stu_remark <=", value, "stuRemark");
            return (Criteria) this;
        }

        public Criteria andStuRemarkLike(String value) {
            addCriterion("stu_remark like", value, "stuRemark");
            return (Criteria) this;
        }

        public Criteria andStuRemarkNotLike(String value) {
            addCriterion("stu_remark not like", value, "stuRemark");
            return (Criteria) this;
        }

        public Criteria andStuRemarkIn(List<String> values) {
            addCriterion("stu_remark in", values, "stuRemark");
            return (Criteria) this;
        }

        public Criteria andStuRemarkNotIn(List<String> values) {
            addCriterion("stu_remark not in", values, "stuRemark");
            return (Criteria) this;
        }

        public Criteria andStuRemarkBetween(String value1, String value2) {
            addCriterion("stu_remark between", value1, value2, "stuRemark");
            return (Criteria) this;
        }

        public Criteria andStuRemarkNotBetween(String value1, String value2) {
            addCriterion("stu_remark not between", value1, value2, "stuRemark");
            return (Criteria) this;
        }

        public Criteria andStuCoursenameIsNull() {
            addCriterion("stu_coursename is null");
            return (Criteria) this;
        }

        public Criteria andStuCoursenameIsNotNull() {
            addCriterion("stu_coursename is not null");
            return (Criteria) this;
        }

        public Criteria andStuCoursenameEqualTo(String value) {
            addCriterion("stu_coursename =", value, "stuCoursename");
            return (Criteria) this;
        }

        public Criteria andStuCoursenameNotEqualTo(String value) {
            addCriterion("stu_coursename <>", value, "stuCoursename");
            return (Criteria) this;
        }

        public Criteria andStuCoursenameGreaterThan(String value) {
            addCriterion("stu_coursename >", value, "stuCoursename");
            return (Criteria) this;
        }

        public Criteria andStuCoursenameGreaterThanOrEqualTo(String value) {
            addCriterion("stu_coursename >=", value, "stuCoursename");
            return (Criteria) this;
        }

        public Criteria andStuCoursenameLessThan(String value) {
            addCriterion("stu_coursename <", value, "stuCoursename");
            return (Criteria) this;
        }

        public Criteria andStuCoursenameLessThanOrEqualTo(String value) {
            addCriterion("stu_coursename <=", value, "stuCoursename");
            return (Criteria) this;
        }

        public Criteria andStuCoursenameLike(String value) {
            addCriterion("stu_coursename like", value, "stuCoursename");
            return (Criteria) this;
        }

        public Criteria andStuCoursenameNotLike(String value) {
            addCriterion("stu_coursename not like", value, "stuCoursename");
            return (Criteria) this;
        }

        public Criteria andStuCoursenameIn(List<String> values) {
            addCriterion("stu_coursename in", values, "stuCoursename");
            return (Criteria) this;
        }

        public Criteria andStuCoursenameNotIn(List<String> values) {
            addCriterion("stu_coursename not in", values, "stuCoursename");
            return (Criteria) this;
        }

        public Criteria andStuCoursenameBetween(String value1, String value2) {
            addCriterion("stu_coursename between", value1, value2, "stuCoursename");
            return (Criteria) this;
        }

        public Criteria andStuCoursenameNotBetween(String value1, String value2) {
            addCriterion("stu_coursename not between", value1, value2, "stuCoursename");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}