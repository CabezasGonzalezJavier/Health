package com.javier.health.service;

import com.google.gson.Gson;
import com.javier.health.models.User;
import com.javier.health.utils.Constants;
import com.javier.health.webservices.CommandFactory;
import com.javier.health.webservices.ResponseHandler;
import com.javier.health.webservices.UserResponseHandler;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
    }

    private CommandFactory mCommandFactory = new CommandFactory();

    @Override
    public void getUser(final UserResponseHandler fuseResponseHandler, String string) {
        ResponseHandler handler = new ResponseHandler() {
            @Override
            public void sendResponseSusccesful(String response) {
                Gson gson = new Gson();
                User user = gson.fromJson(response, User.class);
                fuseResponseHandler.handlUser(user);
            }

            @Override
            public void sendResponseFail(String error) {
                fuseResponseHandler.sendResponseFail(error);
            }
        };
        mCommandFactory.createGetCommand(Constants.URL, handler).execute();
    }


}
