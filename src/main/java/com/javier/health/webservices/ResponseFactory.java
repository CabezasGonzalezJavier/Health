package com.javier.health.webservices;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public class ResponseFactory {
    public static ResponseListener createResponseListener(ResponseHandler responseHandler){
        return new ResponseImpl(responseHandler);
    }
}
