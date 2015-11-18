package com.javier.health.controller;

import android.content.Context;

import com.javier.health.models.User;
import com.javier.health.service.UserServiceImpl;
import com.javier.health.webservices.UserResponseHandler;
import com.javier.health.webservices.UserResponseListener;

import java.util.List;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public class UserController implements UserResponseHandler {
    private UserResponseListener mListener;

    public UserController(UserResponseListener mListener) {
        this.mListener = mListener;
    }

    public void request(Context context) {
        UserServiceImpl receiver = new UserServiceImpl();
        receiver.getUser(this, context);

    }

    @Override
    public void handlUser(List<User> userList) {
        mListener.onSuccess(userList);
    }

    @Override
    public void sendResponseFail(String error) {
        mListener.onError(error);
    }


}
