package com.qfedu.util;

/**
 * projectName: logistics
 * author: 张宁
 * time: 2020/10/5 11:08
 * description:
 */
public class JsonResult {
    private int code;
    private Object info;

    public JsonResult() {
    }

    public JsonResult(int code, Object info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code=" + code +
                ", info=" + info +
                '}';
    }
}
