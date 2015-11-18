package com.javier.health.webservices;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public class RequestFactory {
    private static RequestImpl sRequestImpl;

    public static Request createResponseListener(){
        if (sRequestImpl == null){
            sRequestImpl = new RequestImpl();
        }
        return  sRequestImpl;
    }

    public static void setMockRequest(RequestImpl requestImpl){
        sRequestImpl = requestImpl;

    }
}
