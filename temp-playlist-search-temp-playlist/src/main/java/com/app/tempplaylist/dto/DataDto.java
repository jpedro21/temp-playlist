package com.app.tempplaylist.dto;

public class DataDto<T> {

    private T data;
    private String type;

    public DataDto(T data, String type) {
        this.data = data;
        this.type = type;
    }

    public T getData() {

        return data;
    }

    public void setData(T data) {

        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
