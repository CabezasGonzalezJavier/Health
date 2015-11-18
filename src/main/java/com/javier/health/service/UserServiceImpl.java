package com.javier.health.service;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.javier.health.models.User;
import com.javier.health.models.dao.UserDAO;
import com.javier.health.utils.Constants;
import com.javier.health.webservices.CommandFactory;
import com.javier.health.webservices.ResponseHandler;
import com.javier.health.webservices.UserResponseHandler;

import java.util.List;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public class UserServiceImpl implements UserService {

    private UserDAO mUserDAO;
    public UserServiceImpl() {
    }

    private CommandFactory mCommandFactory = new CommandFactory();

    @Override
    public void getUser(final UserResponseHandler userResponseHandler, final Context context) {

        ResponseHandler handler = new ResponseHandler() {
            @Override
            public void sendResponseSusccesful(String response) {
                Gson gson = new Gson();
                List<User> user = gson.fromJson(response, new TypeToken<List<User>>(){}.getType());
                insertDataBase(user, context);
                userResponseHandler.handlUser(user);
            }

            @Override
            public void sendResponseFail(String error) {
                userResponseHandler.sendResponseFail(error);
            }
        };
        mCommandFactory.createGetCommand(Constants.URL, handler).execute();
    }

    public boolean exitsDB(){
        int user = mUserDAO.getCount();
        return user > 0;
    }

    public void insertDataBase(List<User> listUser, Context context){
        mUserDAO = new UserDAO(context);
        if(!exitsDB()) {
            mUserDAO.createAll(listUser);
        }
    }
}
