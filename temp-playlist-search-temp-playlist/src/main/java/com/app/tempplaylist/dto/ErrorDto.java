package com.app.tempplaylist.dto;

import org.joda.time.LocalDate;

public class ErrorDto {

    private Integer code;
    private String date;
    private String msg;

    public ErrorDto(Integer code, String date, String msg) {
        this.code = code;
        this.date = date;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
