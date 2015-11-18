package com.javier.health.models;

import java.util.List;
import java.util.Map;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public class Response {

    private Map<String, List<String >> headers;
    private Object content;
    private int code;
    private String info;
    private boolean interneterror;

    public boolean checkStatusCode(int status) {

        boolean successful = false;

        if (status >=200 && status<300){
            successful = true;
        }
        return successful;
    }

    public boolean isInterneterror() {
        return interneterror;
    }

    public void setInterneterror(boolean interneterror) {
        this.interneterror = interneterror;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

}
