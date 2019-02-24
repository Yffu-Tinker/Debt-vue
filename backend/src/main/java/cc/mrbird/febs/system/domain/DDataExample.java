package cc.mrbird.febs.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public DDataExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andClientNameIsNull() {
            addCriterion("CLIENT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andClientNameIsNotNull() {
            addCriterion("CLIENT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andClientNameEqualTo(String value) {
            addCriterion("CLIENT_NAME =", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotEqualTo(String value) {
            addCriterion("CLIENT_NAME <>", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThan(String value) {
            addCriterion("CLIENT_NAME >", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThanOrEqualTo(String value) {
            addCriterion("CLIENT_NAME >=", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThan(String value) {
            addCriterion("CLIENT_NAME <", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThanOrEqualTo(String value) {
            addCriterion("CLIENT_NAME <=", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLike(String value) {
            addCriterion("CLIENT_NAME like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotLike(String value) {
            addCriterion("CLIENT_NAME not like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameIn(List<String> values) {
            addCriterion("CLIENT_NAME in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotIn(List<String> values) {
            addCriterion("CLIENT_NAME not in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameBetween(String value1, String value2) {
            addCriterion("CLIENT_NAME between", value1, value2, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotBetween(String value1, String value2) {
            addCriterion("CLIENT_NAME not between", value1, value2, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientIdNumIsNull() {
            addCriterion("CLIENT_ID_NUM is null");
            return (Criteria) this;
        }

        public Criteria andClientIdNumIsNotNull() {
            addCriterion("CLIENT_ID_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdNumEqualTo(String value) {
            addCriterion("CLIENT_ID_NUM =", value, "clientIdNum");
            return (Criteria) this;
        }

        public Criteria andClientIdNumNotEqualTo(String value) {
            addCriterion("CLIENT_ID_NUM <>", value, "clientIdNum");
            return (Criteria) this;
        }

        public Criteria andClientIdNumGreaterThan(String value) {
            addCriterion("CLIENT_ID_NUM >", value, "clientIdNum");
            return (Criteria) this;
        }

        public Criteria andClientIdNumGreaterThanOrEqualTo(String value) {
            addCriterion("CLIENT_ID_NUM >=", value, "clientIdNum");
            return (Criteria) this;
        }

        public Criteria andClientIdNumLessThan(String value) {
            addCriterion("CLIENT_ID_NUM <", value, "clientIdNum");
            return (Criteria) this;
        }

        public Criteria andClientIdNumLessThanOrEqualTo(String value) {
            addCriterion("CLIENT_ID_NUM <=", value, "clientIdNum");
            return (Criteria) this;
        }

        public Criteria andClientIdNumLike(String value) {
            addCriterion("CLIENT_ID_NUM like", value, "clientIdNum");
            return (Criteria) this;
        }

        public Criteria andClientIdNumNotLike(String value) {
            addCriterion("CLIENT_ID_NUM not like", value, "clientIdNum");
            return (Criteria) this;
        }

        public Criteria andClientIdNumIn(List<String> values) {
            addCriterion("CLIENT_ID_NUM in", values, "clientIdNum");
            return (Criteria) this;
        }

        public Criteria andClientIdNumNotIn(List<String> values) {
            addCriterion("CLIENT_ID_NUM not in", values, "clientIdNum");
            return (Criteria) this;
        }

        public Criteria andClientIdNumBetween(String value1, String value2) {
            addCriterion("CLIENT_ID_NUM between", value1, value2, "clientIdNum");
            return (Criteria) this;
        }

        public Criteria andClientIdNumNotBetween(String value1, String value2) {
            addCriterion("CLIENT_ID_NUM not between", value1, value2, "clientIdNum");
            return (Criteria) this;
        }

        public Criteria andClientPhoneIsNull() {
            addCriterion("CLIENT_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andClientPhoneIsNotNull() {
            addCriterion("CLIENT_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andClientPhoneEqualTo(String value) {
            addCriterion("CLIENT_PHONE =", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneNotEqualTo(String value) {
            addCriterion("CLIENT_PHONE <>", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneGreaterThan(String value) {
            addCriterion("CLIENT_PHONE >", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("CLIENT_PHONE >=", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneLessThan(String value) {
            addCriterion("CLIENT_PHONE <", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneLessThanOrEqualTo(String value) {
            addCriterion("CLIENT_PHONE <=", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneLike(String value) {
            addCriterion("CLIENT_PHONE like", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneNotLike(String value) {
            addCriterion("CLIENT_PHONE not like", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneIn(List<String> values) {
            addCriterion("CLIENT_PHONE in", values, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneNotIn(List<String> values) {
            addCriterion("CLIENT_PHONE not in", values, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneBetween(String value1, String value2) {
            addCriterion("CLIENT_PHONE between", value1, value2, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneNotBetween(String value1, String value2) {
            addCriterion("CLIENT_PHONE not between", value1, value2, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andDataStatusIsNull() {
            addCriterion("DATA_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andDataStatusIsNotNull() {
            addCriterion("DATA_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andDataStatusEqualTo(String value) {
            addCriterion("DATA_STATUS =", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotEqualTo(String value) {
            addCriterion("DATA_STATUS <>", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusGreaterThan(String value) {
            addCriterion("DATA_STATUS >", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_STATUS >=", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusLessThan(String value) {
            addCriterion("DATA_STATUS <", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusLessThanOrEqualTo(String value) {
            addCriterion("DATA_STATUS <=", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusLike(String value) {
            addCriterion("DATA_STATUS like", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotLike(String value) {
            addCriterion("DATA_STATUS not like", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusIn(List<String> values) {
            addCriterion("DATA_STATUS in", values, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotIn(List<String> values) {
            addCriterion("DATA_STATUS not in", values, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusBetween(String value1, String value2) {
            addCriterion("DATA_STATUS between", value1, value2, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotBetween(String value1, String value2) {
            addCriterion("DATA_STATUS not between", value1, value2, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNull() {
            addCriterion("OPERATOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("OPERATOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(Integer value) {
            addCriterion("OPERATOR_ID =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(Integer value) {
            addCriterion("OPERATOR_ID <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(Integer value) {
            addCriterion("OPERATOR_ID >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("OPERATOR_ID >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(Integer value) {
            addCriterion("OPERATOR_ID <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("OPERATOR_ID <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<Integer> values) {
            addCriterion("OPERATOR_ID in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<Integer> values) {
            addCriterion("OPERATOR_ID not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(Integer value1, Integer value2) {
            addCriterion("OPERATOR_ID between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("OPERATOR_ID not between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNull() {
            addCriterion("OPERATOR_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNotNull() {
            addCriterion("OPERATOR_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameEqualTo(String value) {
            addCriterion("OPERATOR_NAME =", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotEqualTo(String value) {
            addCriterion("OPERATOR_NAME <>", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThan(String value) {
            addCriterion("OPERATOR_NAME >", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATOR_NAME >=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThan(String value) {
            addCriterion("OPERATOR_NAME <", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThanOrEqualTo(String value) {
            addCriterion("OPERATOR_NAME <=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLike(String value) {
            addCriterion("OPERATOR_NAME like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotLike(String value) {
            addCriterion("OPERATOR_NAME not like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIn(List<String> values) {
            addCriterion("OPERATOR_NAME in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotIn(List<String> values) {
            addCriterion("OPERATOR_NAME not in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameBetween(String value1, String value2) {
            addCriterion("OPERATOR_NAME between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotBetween(String value1, String value2) {
            addCriterion("OPERATOR_NAME not between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andDataSourceIsNull() {
            addCriterion("DATA_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceIsNotNull() {
            addCriterion("DATA_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceEqualTo(String value) {
            addCriterion("DATA_SOURCE =", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotEqualTo(String value) {
            addCriterion("DATA_SOURCE <>", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThan(String value) {
            addCriterion("DATA_SOURCE >", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_SOURCE >=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThan(String value) {
            addCriterion("DATA_SOURCE <", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThanOrEqualTo(String value) {
            addCriterion("DATA_SOURCE <=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLike(String value) {
            addCriterion("DATA_SOURCE like", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotLike(String value) {
            addCriterion("DATA_SOURCE not like", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceIn(List<String> values) {
            addCriterion("DATA_SOURCE in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotIn(List<String> values) {
            addCriterion("DATA_SOURCE not in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceBetween(String value1, String value2) {
            addCriterion("DATA_SOURCE between", value1, value2, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotBetween(String value1, String value2) {
            addCriterion("DATA_SOURCE not between", value1, value2, "dataSource");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLastOperatTimeIsNull() {
            addCriterion("LAST_OPERAT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastOperatTimeIsNotNull() {
            addCriterion("LAST_OPERAT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastOperatTimeEqualTo(Date value) {
            addCriterion("LAST_OPERAT_TIME =", value, "lastOperatTime");
            return (Criteria) this;
        }

        public Criteria andLastOperatTimeNotEqualTo(Date value) {
            addCriterion("LAST_OPERAT_TIME <>", value, "lastOperatTime");
            return (Criteria) this;
        }

        public Criteria andLastOperatTimeGreaterThan(Date value) {
            addCriterion("LAST_OPERAT_TIME >", value, "lastOperatTime");
            return (Criteria) this;
        }

        public Criteria andLastOperatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_OPERAT_TIME >=", value, "lastOperatTime");
            return (Criteria) this;
        }

        public Criteria andLastOperatTimeLessThan(Date value) {
            addCriterion("LAST_OPERAT_TIME <", value, "lastOperatTime");
            return (Criteria) this;
        }

        public Criteria andLastOperatTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_OPERAT_TIME <=", value, "lastOperatTime");
            return (Criteria) this;
        }

        public Criteria andLastOperatTimeIn(List<Date> values) {
            addCriterion("LAST_OPERAT_TIME in", values, "lastOperatTime");
            return (Criteria) this;
        }

        public Criteria andLastOperatTimeNotIn(List<Date> values) {
            addCriterion("LAST_OPERAT_TIME not in", values, "lastOperatTime");
            return (Criteria) this;
        }

        public Criteria andLastOperatTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_OPERAT_TIME between", value1, value2, "lastOperatTime");
            return (Criteria) this;
        }

        public Criteria andLastOperatTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_OPERAT_TIME not between", value1, value2, "lastOperatTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("CREATE_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("CREATE_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("CREATE_USER_ID =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("CREATE_USER_ID <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("CREATE_USER_ID >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER_ID >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("CREATE_USER_ID <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER_ID <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("CREATE_USER_ID like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("CREATE_USER_ID not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("CREATE_USER_ID in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("CREATE_USER_ID not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("CREATE_USER_ID between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER_ID not between", value1, value2, "createUserId");
            return (Criteria) this;
        }
    }

    /**
     */
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