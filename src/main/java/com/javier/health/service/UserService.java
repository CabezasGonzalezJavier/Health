package com.javier.health.service;

import com.javier.health.webservices.UserResponseHandler;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public interface UserService {
    void getUser(UserResponseHandler userResponseHandler, String string);

}
