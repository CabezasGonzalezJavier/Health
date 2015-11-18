package com.javier.health.webservices;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public interface ResponseListener {
    public void onSuccess(final String successResponse);
    public void onError(final String errorResponse);
    public void onGeneralError();

}
