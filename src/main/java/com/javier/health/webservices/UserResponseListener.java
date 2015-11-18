package com.javier.health.webservices;

import com.javier.health.models.User;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public interface UserResponseListener {
    public void onSuccess(User successResponse);
    public void onError(String errorResponse);
}
