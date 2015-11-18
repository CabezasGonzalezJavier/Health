package com.javier.health.webservices;

import com.javier.health.models.User;

import java.util.List;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public interface UserResponseListener {
    public void onSuccess(List<User> successResponse);
    public void onError(String errorResponse);
}
