package com.javier.health.webservices;

import com.javier.health.models.User;

import java.util.List;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public interface UserResponseHandler {
    public void handlUser(List<User> userList);
    public void sendResponseFail(String error);
}
