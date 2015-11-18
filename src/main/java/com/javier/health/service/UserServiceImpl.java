package com.javier.health.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.javier.health.models.User;
import com.javier.health.utils.Constants;
import com.javier.health.webservices.CommandFactory;
import com.javier.health.webservices.ResponseHandler;
import com.javier.health.webservices.UserResponseHandler;

import java.util.List;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
    }

    private CommandFactory mCommandFactory = new CommandFactory();

    @Override
    public void getUser(final UserResponseHandler userResponseHandler) {
        ResponseHandler handler = new ResponseHandler() {
            @Override
            public void sendResponseSusccesful(String response) {
                Gson gson = new Gson();
                List<User> user = gson.fromJson(response, new TypeToken<List<User>>(){}.getType());

                userResponseHandler.handlUser(user);
            }

            @Override
            public void sendResponseFail(String error) {
                userResponseHandler.sendResponseFail(error);
            }
        };
        mCommandFactory.createGetCommand(Constants.URL, handler).execute();
    }


}
