package com.dy.bean;

import java.util.ArrayList;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
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

        public Criteria andStuIdIsNull() {
            addCriterion("stu_id is null");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNotNull() {
            addCriterion("stu_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdEqualTo(String value) {
            addCriterion("stu_id =", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotEqualTo(String value) {
            addCriterion("stu_id <>", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThan(String value) {
            addCriterion("stu_id >", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThanOrEqualTo(String value) {
            addCriterion("stu_id >=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThan(String value) {
            addCriterion("stu_id <", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThanOrEqualTo(String value) {
            addCriterion("stu_id <=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLike(String value) {
            addCriterion("stu_id like", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotLike(String value) {
            addCriterion("stu_id not like", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdIn(List<String> values) {
            addCriterion("stu_id in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotIn(List<String> values) {
            addCriterion("stu_id not in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdBetween(String value1, String value2) {
            addCriterion("stu_id between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotBetween(String value1, String value2) {
            addCriterion("stu_id not between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNull() {
            addCriterion("stu_name is null");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNotNull() {
            addCriterion("stu_name is not null");
            return (Criteria) this;
        }

        public Criteria andStuNameEqualTo(String value) {
            addCriterion("stu_name =", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotEqualTo(String value) {
            addCriterion("stu_name <>", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThan(String value) {
            addCriterion("stu_name >", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThanOrEqualTo(String value) {
            addCriterion("stu_name >=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThan(String value) {
            addCriterion("stu_name <", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThanOrEqualTo(String value) {
            addCriterion("stu_name <=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLike(String value) {
            addCriterion("stu_name like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotLike(String value) {
            addCriterion("stu_name not like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameIn(List<String> values) {
            addCriterion("stu_name in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotIn(List<String> values) {
            addCriterion("stu_name not in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameBetween(String value1, String value2) {
            addCriterion("stu_name between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotBetween(String value1, String value2) {
            addCriterion("stu_name not between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuPasswordIsNull() {
            addCriterion("stu_password is null");
            return (Criteria) this;
        }

        public Criteria andStuPasswordIsNotNull() {
            addCriterion("stu_password is not null");
            return (Criteria) this;
        }

        public Criteria andStuPasswordEqualTo(String value) {
            addCriterion("stu_password =", value, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordNotEqualTo(String value) {
            addCriterion("stu_password <>", value, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordGreaterThan(String value) {
            addCriterion("stu_password >", value, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("stu_password >=", value, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordLessThan(String value) {
            addCriterion("stu_password <", value, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordLessThanOrEqualTo(String value) {
            addCriterion("stu_password <=", value, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordLike(String value) {
            addCriterion("stu_password like", value, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordNotLike(String value) {
            addCriterion("stu_password not like", value, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordIn(List<String> values) {
            addCriterion("stu_password in", values, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordNotIn(List<String> values) {
            addCriterion("stu_password not in", values, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordBetween(String value1, String value2) {
            addCriterion("stu_password between", value1, value2, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordNotBetween(String value1, String value2) {
            addCriterion("stu_password not between", value1, value2, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuRegisterdateIsNull() {
            addCriterion("stu_registerdate is null");
            return (Criteria) this;
        }

        public Criteria andStuRegisterdateIsNotNull() {
            addCriterion("stu_registerdate is not null");
            return (Criteria) this;
        }

        public Criteria andStuRegisterdateEqualTo(String value) {
            addCriterion("stu_registerdate =", value, "stuRegisterdate");
            return (Criteria) this;
        }

        public Criteria andStuRegisterdateNotEqualTo(String value) {
            addCriterion("stu_registerdate <>", value, "stuRegisterdate");
            return (Criteria) this;
        }

        public Criteria andStuRegisterdateGreaterThan(String value) {
            addCriterion("stu_registerdate >", value, "stuRegisterdate");
            return (Criteria) this;
        }

        public Criteria andStuRegisterdateGreaterThanOrEqualTo(String value) {
            addCriterion("stu_registerdate >=", value, "stuRegisterdate");
            return (Criteria) this;
        }

        public Criteria andStuRegisterdateLessThan(String value) {
            addCriterion("stu_registerdate <", value, "stuRegisterdate");
            return (Criteria) this;
        }

        public Criteria andStuRegisterdateLessThanOrEqualTo(String value) {
            addCriterion("stu_registerdate <=", value, "stuRegisterdate");
            return (Criteria) this;
        }

        public Criteria andStuRegisterdateLike(String value) {
            addCriterion("stu_registerdate like", value, "stuRegisterdate");
            return (Criteria) this;
        }

        public Criteria andStuRegisterdateNotLike(String value) {
            addCriterion("stu_registerdate not like", value, "stuRegisterdate");
            return (Criteria) this;
        }

        public Criteria andStuRegisterdateIn(List<String> values) {
            addCriterion("stu_registerdate in", values, "stuRegisterdate");
            return (Criteria) this;
        }

        public Criteria andStuRegisterdateNotIn(List<String> values) {
            addCriterion("stu_registerdate not in", values, "stuRegisterdate");
            return (Criteria) this;
        }

        public Criteria andStuRegisterdateBetween(String value1, String value2) {
            addCriterion("stu_registerdate between", value1, value2, "stuRegisterdate");
            return (Criteria) this;
        }

        public Criteria andStuRegisterdateNotBetween(String value1, String value2) {
            addCriterion("stu_registerdate not between", value1, value2, "stuRegisterdate");
            return (Criteria) this;
        }

        public Criteria andStuClassnameIsNull() {
            addCriterion("stu_classname is null");
            return (Criteria) this;
        }

        public Criteria andStuClassnameIsNotNull() {
            addCriterion("stu_classname is not null");
            return (Criteria) this;
        }

        public Criteria andStuClassnameEqualTo(String value) {
            addCriterion("stu_classname =", value, "stuClassname");
            return (Criteria) this;
        }

        public Criteria andStuClassnameNotEqualTo(String value) {
            addCriterion("stu_classname <>", value, "stuClassname");
            return (Criteria) this;
        }

        public Criteria andStuClassnameGreaterThan(String value) {
            addCriterion("stu_classname >", value, "stuClassname");
            return (Criteria) this;
        }

        public Criteria andStuClassnameGreaterThanOrEqualTo(String value) {
            addCriterion("stu_classname >=", value, "stuClassname");
            return (Criteria) this;
        }

        public Criteria andStuClassnameLessThan(String value) {
            addCriterion("stu_classname <", value, "stuClassname");
            return (Criteria) this;
        }

        public Criteria andStuClassnameLessThanOrEqualTo(String value) {
            addCriterion("stu_classname <=", value, "stuClassname");
            return (Criteria) this;
        }

        public Criteria andStuClassnameLike(String value) {
            addCriterion("stu_classname like", value, "stuClassname");
            return (Criteria) this;
        }

        public Criteria andStuClassnameNotLike(String value) {
            addCriterion("stu_classname not like", value, "stuClassname");
            return (Criteria) this;
        }

        public Criteria andStuClassnameIn(List<String> values) {
            addCriterion("stu_classname in", values, "stuClassname");
            return (Criteria) this;
        }

        public Criteria andStuClassnameNotIn(List<String> values) {
            addCriterion("stu_classname not in", values, "stuClassname");
            return (Criteria) this;
        }

        public Criteria andStuClassnameBetween(String value1, String value2) {
            addCriterion("stu_classname between", value1, value2, "stuClassname");
            return (Criteria) this;
        }

        public Criteria andStuClassnameNotBetween(String value1, String value2) {
            addCriterion("stu_classname not between", value1, value2, "stuClassname");
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