package com.javier.health.controller;

import com.javier.health.models.User;
import com.javier.health.service.UserServiceImpl;
import com.javier.health.webservices.UserResponseHandler;
import com.javier.health.webservices.UserResponseListener;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public class UserController implements UserResponseHandler {
    private UserResponseListener mListener;

    public UserController(UserResponseListener mListener) {
        this.mListener = mListener;
    }

    public void request(String string) {
        UserServiceImpl receiver = new UserServiceImpl();
        receiver.getUser(this, string);

    }

    @Override
    public void handlUser(User fuseClient) {
        mListener.onSuccess(fuseClient);
    }

    @Override
    public void sendResponseFail(String error) {
        mListener.onError(error);
    }


}
