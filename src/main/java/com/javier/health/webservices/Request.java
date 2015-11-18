package com.javier.health.webservices;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public interface Request {
    public void performGetRequest(String url, ResponseHandler responseHandler);
    public void performPutRequest(String url, ResponseHandler responseHandler);
    public void performPostRequest(String url, ResponseHandler responseHandler);
    public void performDeleteRequest(String url, ResponseHandler responseHandler);
}
