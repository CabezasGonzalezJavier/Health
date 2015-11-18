package com.javier.health.webservices;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public interface ResponseHandler {
    public void sendResponseSusccesful(String response);
    public void sendResponseFail(String error);
}
