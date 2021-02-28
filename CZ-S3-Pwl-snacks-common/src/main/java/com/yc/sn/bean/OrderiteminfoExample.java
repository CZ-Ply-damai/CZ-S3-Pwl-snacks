package com.yc.sn.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderiteminfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderiteminfoExample() {
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

        public Criteria andInoIsNull() {
            addCriterion("ino is null");
            return (Criteria) this;
        }

        public Criteria andInoIsNotNull() {
            addCriterion("ino is not null");
            return (Criteria) this;
        }

        public Criteria andInoEqualTo(Integer value) {
            addCriterion("ino =", value, "ino");
            return (Criteria) this;
        }

        public Criteria andInoNotEqualTo(Integer value) {
            addCriterion("ino <>", value, "ino");
            return (Criteria) this;
        }

        public Criteria andInoGreaterThan(Integer value) {
            addCriterion("ino >", value, "ino");
            return (Criteria) this;
        }

        public Criteria andInoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ino >=", value, "ino");
            return (Criteria) this;
        }

        public Criteria andInoLessThan(Integer value) {
            addCriterion("ino <", value, "ino");
            return (Criteria) this;
        }

        public Criteria andInoLessThanOrEqualTo(Integer value) {
            addCriterion("ino <=", value, "ino");
            return (Criteria) this;
        }

        public Criteria andInoIn(List<Integer> values) {
            addCriterion("ino in", values, "ino");
            return (Criteria) this;
        }

        public Criteria andInoNotIn(List<Integer> values) {
            addCriterion("ino not in", values, "ino");
            return (Criteria) this;
        }

        public Criteria andInoBetween(Integer value1, Integer value2) {
            addCriterion("ino between", value1, value2, "ino");
            return (Criteria) this;
        }

        public Criteria andInoNotBetween(Integer value1, Integer value2) {
            addCriterion("ino not between", value1, value2, "ino");
            return (Criteria) this;
        }

        public Criteria andOnoIsNull() {
            addCriterion("ono is null");
            return (Criteria) this;
        }

        public Criteria andOnoIsNotNull() {
            addCriterion("ono is not null");
            return (Criteria) this;
        }

        public Criteria andOnoEqualTo(Integer value) {
            addCriterion("ono =", value, "ono");
            return (Criteria) this;
        }

        public Criteria andOnoNotEqualTo(Integer value) {
            addCriterion("ono <>", value, "ono");
            return (Criteria) this;
        }

        public Criteria andOnoGreaterThan(Integer value) {
            addCriterion("ono >", value, "ono");
            return (Criteria) this;
        }

        public Criteria andOnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ono >=", value, "ono");
            return (Criteria) this;
        }

        public Criteria andOnoLessThan(Integer value) {
            addCriterion("ono <", value, "ono");
            return (Criteria) this;
        }

        public Criteria andOnoLessThanOrEqualTo(Integer value) {
            addCriterion("ono <=", value, "ono");
            return (Criteria) this;
        }

        public Criteria andOnoIn(List<Integer> values) {
            addCriterion("ono in", values, "ono");
            return (Criteria) this;
        }

        public Criteria andOnoNotIn(List<Integer> values) {
            addCriterion("ono not in", values, "ono");
            return (Criteria) this;
        }

        public Criteria andOnoBetween(Integer value1, Integer value2) {
            addCriterion("ono between", value1, value2, "ono");
            return (Criteria) this;
        }

        public Criteria andOnoNotBetween(Integer value1, Integer value2) {
            addCriterion("ono not between", value1, value2, "ono");
            return (Criteria) this;
        }

        public Criteria andGnoIsNull() {
            addCriterion("gno is null");
            return (Criteria) this;
        }

        public Criteria andGnoIsNotNull() {
            addCriterion("gno is not null");
            return (Criteria) this;
        }

        public Criteria andGnoEqualTo(Integer value) {
            addCriterion("gno =", value, "gno");
            return (Criteria) this;
        }

        public Criteria andGnoNotEqualTo(Integer value) {
            addCriterion("gno <>", value, "gno");
            return (Criteria) this;
        }

        public Criteria andGnoGreaterThan(Integer value) {
            addCriterion("gno >", value, "gno");
            return (Criteria) this;
        }

        public Criteria andGnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("gno >=", value, "gno");
            return (Criteria) this;
        }

        public Criteria andGnoLessThan(Integer value) {
            addCriterion("gno <", value, "gno");
            return (Criteria) this;
        }

        public Criteria andGnoLessThanOrEqualTo(Integer value) {
            addCriterion("gno <=", value, "gno");
            return (Criteria) this;
        }

        public Criteria andGnoIn(List<Integer> values) {
            addCriterion("gno in", values, "gno");
            return (Criteria) this;
        }

        public Criteria andGnoNotIn(List<Integer> values) {
            addCriterion("gno not in", values, "gno");
            return (Criteria) this;
        }

        public Criteria andGnoBetween(Integer value1, Integer value2) {
            addCriterion("gno between", value1, value2, "gno");
            return (Criteria) this;
        }

        public Criteria andGnoNotBetween(Integer value1, Integer value2) {
            addCriterion("gno not between", value1, value2, "gno");
            return (Criteria) this;
        }

        public Criteria andNumsIsNull() {
            addCriterion("nums is null");
            return (Criteria) this;
        }

        public Criteria andNumsIsNotNull() {
            addCriterion("nums is not null");
            return (Criteria) this;
        }

        public Criteria andNumsEqualTo(Integer value) {
            addCriterion("nums =", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsNotEqualTo(Integer value) {
            addCriterion("nums <>", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsGreaterThan(Integer value) {
            addCriterion("nums >", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("nums >=", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsLessThan(Integer value) {
            addCriterion("nums <", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsLessThanOrEqualTo(Integer value) {
            addCriterion("nums <=", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsIn(List<Integer> values) {
            addCriterion("nums in", values, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsNotIn(List<Integer> values) {
            addCriterion("nums not in", values, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsBetween(Integer value1, Integer value2) {
            addCriterion("nums between", value1, value2, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsNotBetween(Integer value1, Integer value2) {
            addCriterion("nums not between", value1, value2, "nums");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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