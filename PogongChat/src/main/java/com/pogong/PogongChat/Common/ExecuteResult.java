package com.pogong.PogongChat.Common;

import java.util.Map;

public class ExecuteResult {
    private Integer code;//大于等于1>属于正常返回 小于等于-1>属于非正常返回(有error)
    private String desc;
    private Map info;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Map getInfo() {
        return info;
    }

    public void setInfo(Map info) {
        this.info = info;
    }
}
