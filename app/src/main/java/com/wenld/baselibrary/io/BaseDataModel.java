package com.wenld.baselibrary.io;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/8.
 */

public class BaseDataModel implements Serializable{

    private String code;
    private String message;
    private String datatype;
    private String limit;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    private String data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "BaseDataModel{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", datatype='" + datatype + '\'' +
                ", limit='" + limit + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
