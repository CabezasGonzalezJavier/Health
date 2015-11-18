package com.javier.health.webservices;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public class ResponseImpl implements ResponseListener {
    private ResponseHandler mResponseHandler;

    public ResponseImpl(ResponseHandler responseHandler){

        mResponseHandler = responseHandler;
    }


    @Override
    public void onSuccess(String successResponse) {
        mResponseHandler.sendResponseSusccesful(successResponse);
    }

    @Override
    public void onError(String errorResponse) {
        mResponseHandler.sendResponseFail(errorResponse);
    }

    @Override
    public void onGeneralError() {
        String generalError="error General";
        mResponseHandler.sendResponseFail(generalError);
    }
}
