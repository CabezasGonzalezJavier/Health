package com.javier.health.webservices;

import com.javier.health.models.User;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public interface UserResponseHandler {
    public void handlUser(User fuseClient);
    public void sendResponseFail(String error);
}
