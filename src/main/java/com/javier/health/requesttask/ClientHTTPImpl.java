package com.javier.health.requesttask;

import com.javier.health.utils.Constants;
import com.javier.health.webservices.ResponseListener;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public class ClientHTTPImpl implements ClientHTTP {

    private ResponseListener mListener;

    private ClientAsyncTask mAsyncTaskClient;


    public ClientHTTPImpl(ResponseListener listener){
        mListener = listener;
        this.mAsyncTaskClient = new ClientAsyncTaskImpl();
    }



    @Override
    public void get(String url) {

        mAsyncTaskClient.executeAsync(mListener, url, Constants.TYPE_STRING_GET);
    }

    @Override
    public void post(String url) {

    }

    @Override
    public void put(String url) {

    }

    @Override
    public void delete(String url) {

    }
}
