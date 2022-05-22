package com.luohao.springboot.R;

public enum Renum {
    UnKnow_Error(-1, "未知错误"),
    Success(10000, "成功"),
    USER_NOT_EXIST(1, "用户不存在"),
    USER_IS_EXISTS(2, "用户已存在"),
    DATA_IS_NULL(3, "数据为空");

    private final Integer code;
    private final String msg;

    Renum(Integer code, String msg) {
        this.code =code;
        this.msg =msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
