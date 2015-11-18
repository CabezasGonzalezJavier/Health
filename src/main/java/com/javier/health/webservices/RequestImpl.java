package com.javier.health.webservices;

import com.javier.health.requesttask.ClientHTTP;
import com.javier.health.requesttask.ClientHTTPFactory;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public class RequestImpl implements Request {

    @Override
    public void performGetRequest(String url, ResponseHandler responseHandler) {

        ResponseListener response = ResponseFactory.createResponseListener(responseHandler);

        ClientHTTP clientHTTP = ClientHTTPFactory.createResponseListener(response);
        clientHTTP.get(url);

    }

    @Override
    public void performPutRequest(String url, ResponseHandler responseHandler) {

    }

    @Override
    public void performPostRequest(String url, ResponseHandler responseHandler) {

    }

    @Override
    public void performDeleteRequest(String url, ResponseHandler responseHandler) {

    }
}
