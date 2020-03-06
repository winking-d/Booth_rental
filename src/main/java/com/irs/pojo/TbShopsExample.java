package com.irs.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbShopsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbShopsExample() {
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

        public Criteria andShopNumberIsNull() {
            addCriterion("shop_number is null");
            return (Criteria) this;
        }

        public Criteria andShopNumberIsNotNull() {
            addCriterion("shop_number is not null");
            return (Criteria) this;
        }

        public Criteria andShopNumberEqualTo(String value) {
            addCriterion("shop_number =", value, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberNotEqualTo(String value) {
            addCriterion("shop_number <>", value, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberGreaterThan(String value) {
            addCriterion("shop_number >", value, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberGreaterThanOrEqualTo(String value) {
            addCriterion("shop_number >=", value, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberLessThan(String value) {
            addCriterion("shop_number <", value, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberLessThanOrEqualTo(String value) {
            addCriterion("shop_number <=", value, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberLike(String value) {
            addCriterion("shop_number like", value, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberNotLike(String value) {
            addCriterion("shop_number not like", value, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberIn(List<String> values) {
            addCriterion("shop_number in", values, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberNotIn(List<String> values) {
            addCriterion("shop_number not in", values, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberBetween(String value1, String value2) {
            addCriterion("shop_number between", value1, value2, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNumberNotBetween(String value1, String value2) {
            addCriterion("shop_number not between", value1, value2, "shopNumber");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNull() {
            addCriterion("shop_name is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("shop_name =", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("shop_name <>", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("shop_name >", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_name >=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("shop_name <", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("shop_name <=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLike(String value) {
            addCriterion("shop_name like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("shop_name not like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("shop_name in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("shop_name not in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("shop_name between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("shop_name not between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopSizeIsNull() {
            addCriterion("shop_size is null");
            return (Criteria) this;
        }

        public Criteria andShopSizeIsNotNull() {
            addCriterion("shop_size is not null");
            return (Criteria) this;
        }

        public Criteria andShopSizeEqualTo(Double value) {
            addCriterion("shop_size =", value, "shopSize");
            return (Criteria) this;
        }

        public Criteria andShopSizeNotEqualTo(Double value) {
            addCriterion("shop_size <>", value, "shopSize");
            return (Criteria) this;
        }

        public Criteria andShopSizeGreaterThan(Double value) {
            addCriterion("shop_size >", value, "shopSize");
            return (Criteria) this;
        }

        public Criteria andShopSizeGreaterThanOrEqualTo(Double value) {
            addCriterion("shop_size >=", value, "shopSize");
            return (Criteria) this;
        }

        public Criteria andShopSizeLessThan(Double value) {
            addCriterion("shop_size <", value, "shopSize");
            return (Criteria) this;
        }

        public Criteria andShopSizeLessThanOrEqualTo(Double value) {
            addCriterion("shop_size <=", value, "shopSize");
            return (Criteria) this;
        }

        public Criteria andShopSizeIn(List<Double> values) {
            addCriterion("shop_size in", values, "shopSize");
            return (Criteria) this;
        }

        public Criteria andShopSizeNotIn(List<Double> values) {
            addCriterion("shop_size not in", values, "shopSize");
            return (Criteria) this;
        }

        public Criteria andShopSizeBetween(Double value1, Double value2) {
            addCriterion("shop_size between", value1, value2, "shopSize");
            return (Criteria) this;
        }

        public Criteria andShopSizeNotBetween(Double value1, Double value2) {
            addCriterion("shop_size not between", value1, value2, "shopSize");
            return (Criteria) this;
        }

        public Criteria andShopTypeIsNull() {
            addCriterion("shop_type is null");
            return (Criteria) this;
        }

        public Criteria andShopTypeIsNotNull() {
            addCriterion("shop_type is not null");
            return (Criteria) this;
        }

        public Criteria andShopTypeEqualTo(String value) {
            addCriterion("shop_type =", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotEqualTo(String value) {
            addCriterion("shop_type <>", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeGreaterThan(String value) {
            addCriterion("shop_type >", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeGreaterThanOrEqualTo(String value) {
            addCriterion("shop_type >=", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeLessThan(String value) {
            addCriterion("shop_type <", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeLessThanOrEqualTo(String value) {
            addCriterion("shop_type <=", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeLike(String value) {
            addCriterion("shop_type like", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotLike(String value) {
            addCriterion("shop_type not like", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeIn(List<String> values) {
            addCriterion("shop_type in", values, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotIn(List<String> values) {
            addCriterion("shop_type not in", values, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeBetween(String value1, String value2) {
            addCriterion("shop_type between", value1, value2, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotBetween(String value1, String value2) {
            addCriterion("shop_type not between", value1, value2, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopStateIsNull() {
            addCriterion("shop_state is null");
            return (Criteria) this;
        }

        public Criteria andShopStateIsNotNull() {
            addCriterion("shop_state is not null");
            return (Criteria) this;
        }

        public Criteria andShopStateEqualTo(String value) {
            addCriterion("shop_state =", value, "shopState");
            return (Criteria) this;
        }

        public Criteria andShopStateNotEqualTo(String value) {
            addCriterion("shop_state <>", value, "shopState");
            return (Criteria) this;
        }

        public Criteria andShopStateGreaterThan(String value) {
            addCriterion("shop_state >", value, "shopState");
            return (Criteria) this;
        }

        public Criteria andShopStateGreaterThanOrEqualTo(String value) {
            addCriterion("shop_state >=", value, "shopState");
            return (Criteria) this;
        }

        public Criteria andShopStateLessThan(String value) {
            addCriterion("shop_state <", value, "shopState");
            return (Criteria) this;
        }

        public Criteria andShopStateLessThanOrEqualTo(String value) {
            addCriterion("shop_state <=", value, "shopState");
            return (Criteria) this;
        }

        public Criteria andShopStateLike(String value) {
            addCriterion("shop_state like", value, "shopState");
            return (Criteria) this;
        }

        public Criteria andShopStateNotLike(String value) {
            addCriterion("shop_state not like", value, "shopState");
            return (Criteria) this;
        }

        public Criteria andShopStateIn(List<String> values) {
            addCriterion("shop_state in", values, "shopState");
            return (Criteria) this;
        }

        public Criteria andShopStateNotIn(List<String> values) {
            addCriterion("shop_state not in", values, "shopState");
            return (Criteria) this;
        }

        public Criteria andShopStateBetween(String value1, String value2) {
            addCriterion("shop_state between", value1, value2, "shopState");
            return (Criteria) this;
        }

        public Criteria andShopStateNotBetween(String value1, String value2) {
            addCriterion("shop_state not between", value1, value2, "shopState");
            return (Criteria) this;
        }

        public Criteria andShopRentIsNull() {
            addCriterion("shop_rent is null");
            return (Criteria) this;
        }

        public Criteria andShopRentIsNotNull() {
            addCriterion("shop_rent is not null");
            return (Criteria) this;
        }

        public Criteria andShopRentEqualTo(String value) {
            addCriterion("shop_rent =", value, "shopRent");
            return (Criteria) this;
        }

        public Criteria andShopRentNotEqualTo(String value) {
            addCriterion("shop_rent <>", value, "shopRent");
            return (Criteria) this;
        }

        public Criteria andShopRentGreaterThan(String value) {
            addCriterion("shop_rent >", value, "shopRent");
            return (Criteria) this;
        }

        public Criteria andShopRentGreaterThanOrEqualTo(String value) {
            addCriterion("shop_rent >=", value, "shopRent");
            return (Criteria) this;
        }

        public Criteria andShopRentLessThan(String value) {
            addCriterion("shop_rent <", value, "shopRent");
            return (Criteria) this;
        }

        public Criteria andShopRentLessThanOrEqualTo(String value) {
            addCriterion("shop_rent <=", value, "shopRent");
            return (Criteria) this;
        }

        public Criteria andShopRentLike(String value) {
            addCriterion("shop_rent like", value, "shopRent");
            return (Criteria) this;
        }

        public Criteria andShopRentNotLike(String value) {
            addCriterion("shop_rent not like", value, "shopRent");
            return (Criteria) this;
        }

        public Criteria andShopRentIn(List<String> values) {
            addCriterion("shop_rent in", values, "shopRent");
            return (Criteria) this;
        }

        public Criteria andShopRentNotIn(List<String> values) {
            addCriterion("shop_rent not in", values, "shopRent");
            return (Criteria) this;
        }

        public Criteria andShopRentBetween(String value1, String value2) {
            addCriterion("shop_rent between", value1, value2, "shopRent");
            return (Criteria) this;
        }

        public Criteria andShopRentNotBetween(String value1, String value2) {
            addCriterion("shop_rent not between", value1, value2, "shopRent");
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