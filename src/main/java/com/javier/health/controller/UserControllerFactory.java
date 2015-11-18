package com.javier.health.controller;

import com.javier.health.webservices.UserResponseListener;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public class UserControllerFactory {
    private static UserController sFuseController;
    private static UserResponseListener sListener;

    public static  void setResponseListerner(UserResponseListener responseListener) {
        sListener = responseListener;
    }

    public static UserController getUserController() {
        if (sFuseController == null) {
            sFuseController = new UserController(sListener);
        }
        return sFuseController;
    }
}
