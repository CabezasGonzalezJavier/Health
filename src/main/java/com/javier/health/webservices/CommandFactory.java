package com.javier.health.webservices;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public class CommandFactory {

    public static Command createGetCommand(String mUrl, ResponseHandler handler){

        Request request = RequestFactory.createResponseListener();
        return new GetCommand(mUrl,request, handler);

    }
}
