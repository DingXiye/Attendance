package com.dy.bean;

import java.util.ArrayList;
import java.util.List;

public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherExample() {
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

        public Criteria andTecIdIsNull() {
            addCriterion("tec_id is null");
            return (Criteria) this;
        }

        public Criteria andTecIdIsNotNull() {
            addCriterion("tec_id is not null");
            return (Criteria) this;
        }

        public Criteria andTecIdEqualTo(String value) {
            addCriterion("tec_id =", value, "tecId");
            return (Criteria) this;
        }

        public Criteria andTecIdNotEqualTo(String value) {
            addCriterion("tec_id <>", value, "tecId");
            return (Criteria) this;
        }

        public Criteria andTecIdGreaterThan(String value) {
            addCriterion("tec_id >", value, "tecId");
            return (Criteria) this;
        }

        public Criteria andTecIdGreaterThanOrEqualTo(String value) {
            addCriterion("tec_id >=", value, "tecId");
            return (Criteria) this;
        }

        public Criteria andTecIdLessThan(String value) {
            addCriterion("tec_id <", value, "tecId");
            return (Criteria) this;
        }

        public Criteria andTecIdLessThanOrEqualTo(String value) {
            addCriterion("tec_id <=", value, "tecId");
            return (Criteria) this;
        }

        public Criteria andTecIdLike(String value) {
            addCriterion("tec_id like", value, "tecId");
            return (Criteria) this;
        }

        public Criteria andTecIdNotLike(String value) {
            addCriterion("tec_id not like", value, "tecId");
            return (Criteria) this;
        }

        public Criteria andTecIdIn(List<String> values) {
            addCriterion("tec_id in", values, "tecId");
            return (Criteria) this;
        }

        public Criteria andTecIdNotIn(List<String> values) {
            addCriterion("tec_id not in", values, "tecId");
            return (Criteria) this;
        }

        public Criteria andTecIdBetween(String value1, String value2) {
            addCriterion("tec_id between", value1, value2, "tecId");
            return (Criteria) this;
        }

        public Criteria andTecIdNotBetween(String value1, String value2) {
            addCriterion("tec_id not between", value1, value2, "tecId");
            return (Criteria) this;
        }

        public Criteria andTecNameIsNull() {
            addCriterion("tec_name is null");
            return (Criteria) this;
        }

        public Criteria andTecNameIsNotNull() {
            addCriterion("tec_name is not null");
            return (Criteria) this;
        }

        public Criteria andTecNameEqualTo(String value) {
            addCriterion("tec_name =", value, "tecName");
            return (Criteria) this;
        }

        public Criteria andTecNameNotEqualTo(String value) {
            addCriterion("tec_name <>", value, "tecName");
            return (Criteria) this;
        }

        public Criteria andTecNameGreaterThan(String value) {
            addCriterion("tec_name >", value, "tecName");
            return (Criteria) this;
        }

        public Criteria andTecNameGreaterThanOrEqualTo(String value) {
            addCriterion("tec_name >=", value, "tecName");
            return (Criteria) this;
        }

        public Criteria andTecNameLessThan(String value) {
            addCriterion("tec_name <", value, "tecName");
            return (Criteria) this;
        }

        public Criteria andTecNameLessThanOrEqualTo(String value) {
            addCriterion("tec_name <=", value, "tecName");
            return (Criteria) this;
        }

        public Criteria andTecNameLike(String value) {
            addCriterion("tec_name like", value, "tecName");
            return (Criteria) this;
        }

        public Criteria andTecNameNotLike(String value) {
            addCriterion("tec_name not like", value, "tecName");
            return (Criteria) this;
        }

        public Criteria andTecNameIn(List<String> values) {
            addCriterion("tec_name in", values, "tecName");
            return (Criteria) this;
        }

        public Criteria andTecNameNotIn(List<String> values) {
            addCriterion("tec_name not in", values, "tecName");
            return (Criteria) this;
        }

        public Criteria andTecNameBetween(String value1, String value2) {
            addCriterion("tec_name between", value1, value2, "tecName");
            return (Criteria) this;
        }

        public Criteria andTecNameNotBetween(String value1, String value2) {
            addCriterion("tec_name not between", value1, value2, "tecName");
            return (Criteria) this;
        }

        public Criteria andTecPasswordIsNull() {
            addCriterion("tec_password is null");
            return (Criteria) this;
        }

        public Criteria andTecPasswordIsNotNull() {
            addCriterion("tec_password is not null");
            return (Criteria) this;
        }

        public Criteria andTecPasswordEqualTo(String value) {
            addCriterion("tec_password =", value, "tecPassword");
            return (Criteria) this;
        }

        public Criteria andTecPasswordNotEqualTo(String value) {
            addCriterion("tec_password <>", value, "tecPassword");
            return (Criteria) this;
        }

        public Criteria andTecPasswordGreaterThan(String value) {
            addCriterion("tec_password >", value, "tecPassword");
            return (Criteria) this;
        }

        public Criteria andTecPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("tec_password >=", value, "tecPassword");
            return (Criteria) this;
        }

        public Criteria andTecPasswordLessThan(String value) {
            addCriterion("tec_password <", value, "tecPassword");
            return (Criteria) this;
        }

        public Criteria andTecPasswordLessThanOrEqualTo(String value) {
            addCriterion("tec_password <=", value, "tecPassword");
            return (Criteria) this;
        }

        public Criteria andTecPasswordLike(String value) {
            addCriterion("tec_password like", value, "tecPassword");
            return (Criteria) this;
        }

        public Criteria andTecPasswordNotLike(String value) {
            addCriterion("tec_password not like", value, "tecPassword");
            return (Criteria) this;
        }

        public Criteria andTecPasswordIn(List<String> values) {
            addCriterion("tec_password in", values, "tecPassword");
            return (Criteria) this;
        }

        public Criteria andTecPasswordNotIn(List<String> values) {
            addCriterion("tec_password not in", values, "tecPassword");
            return (Criteria) this;
        }

        public Criteria andTecPasswordBetween(String value1, String value2) {
            addCriterion("tec_password between", value1, value2, "tecPassword");
            return (Criteria) this;
        }

        public Criteria andTecPasswordNotBetween(String value1, String value2) {
            addCriterion("tec_password not between", value1, value2, "tecPassword");
            return (Criteria) this;
        }

        public Criteria andCoursenameIsNull() {
            addCriterion("coursename is null");
            return (Criteria) this;
        }

        public Criteria andCoursenameIsNotNull() {
            addCriterion("coursename is not null");
            return (Criteria) this;
        }

        public Criteria andCoursenameEqualTo(String value) {
            addCriterion("coursename =", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameNotEqualTo(String value) {
            addCriterion("coursename <>", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameGreaterThan(String value) {
            addCriterion("coursename >", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameGreaterThanOrEqualTo(String value) {
            addCriterion("coursename >=", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameLessThan(String value) {
            addCriterion("coursename <", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameLessThanOrEqualTo(String value) {
            addCriterion("coursename <=", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameLike(String value) {
            addCriterion("coursename like", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameNotLike(String value) {
            addCriterion("coursename not like", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameIn(List<String> values) {
            addCriterion("coursename in", values, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameNotIn(List<String> values) {
            addCriterion("coursename not in", values, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameBetween(String value1, String value2) {
            addCriterion("coursename between", value1, value2, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameNotBetween(String value1, String value2) {
            addCriterion("coursename not between", value1, value2, "coursename");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNull() {
            addCriterion("classname is null");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNotNull() {
            addCriterion("classname is not null");
            return (Criteria) this;
        }

        public Criteria andClassnameEqualTo(String value) {
            addCriterion("classname =", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotEqualTo(String value) {
            addCriterion("classname <>", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThan(String value) {
            addCriterion("classname >", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThanOrEqualTo(String value) {
            addCriterion("classname >=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThan(String value) {
            addCriterion("classname <", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThanOrEqualTo(String value) {
            addCriterion("classname <=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLike(String value) {
            addCriterion("classname like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotLike(String value) {
            addCriterion("classname not like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameIn(List<String> values) {
            addCriterion("classname in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotIn(List<String> values) {
            addCriterion("classname not in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameBetween(String value1, String value2) {
            addCriterion("classname between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotBetween(String value1, String value2) {
            addCriterion("classname not between", value1, value2, "classname");
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