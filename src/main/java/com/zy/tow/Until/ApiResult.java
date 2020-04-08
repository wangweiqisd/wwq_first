package com.zy.tow.Until;

import lombok.Data;

@Data
public class ApiResult {
    public static final Integer STATUS_SUCCESS = 0;
    public static final Integer STATUS_FAILURE = -1;

    public static final String DESC_SUCCESS = "操作成功";
    public static final String DESC_FAILURE = "操作失败";

    private Integer status;
    private String desc;
    private Object result;

    private ApiResult() {}

    private ApiResult(Integer status, String desc, Object result) {
        this.status = status;
        this.desc = desc;
        this.result = result;
    }

    //这个方法和Builder设计模式二选一即可，功能是重复的
    public static ApiResult success(Object result) {
        return success(DESC_SUCCESS, result);
    }

    //同上
    public static ApiResult success(String desc, Object result) {
        return new ApiResult(STATUS_SUCCESS, desc, result);
    }

    //同上
    public static ApiResult failure(Integer status) {
        return failure(status, null);
    }

    //同上
    public static ApiResult failure(Integer status, String desc) {
        return failure(status, desc, null);
    }

    //同上
    public static ApiResult failure(Integer status, String desc, Object result) {
        return new ApiResult(status, desc, result);
    }

    public static Builder builder() {
        return new Builder();
    }

    //静态内部类，这里使用Builder设计模式
    public static class Builder {
        private Integer status;
        private String desc;
        private Object result;

        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public Object getResult() {
            return result;
        }

        public void setResult(Object result) {
            this.result = result;
        }

        public Builder desc(String desc) {
            this.desc = desc;
            return this;
        }

        public Builder result(Object result) {
            this.result = result;
            return this;
        }

        public ApiResult build() {
            return new ApiResult(status, desc, result);
        }
    }

}
