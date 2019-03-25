package com.app.tempplaylist.dto;

import org.joda.time.LocalDate;

public class ErrorDto {

    private Integer code;
    private LocalDate date;
    private String msg;

    public ErrorDto(Integer code, LocalDate date, String msg) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
