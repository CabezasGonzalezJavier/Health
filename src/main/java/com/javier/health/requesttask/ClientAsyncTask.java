package com.javier.health.requesttask;

import com.javier.health.models.Response;
import com.javier.health.webservices.ResponseListener;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public interface ClientAsyncTask {
    public void executeAsync(ResponseListener mListener, String url, String type);
    public Response callClient(final String url, final String type);
}
