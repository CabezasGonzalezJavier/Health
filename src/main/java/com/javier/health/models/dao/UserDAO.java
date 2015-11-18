package com.javier.health.models.dao;

import android.content.Context;

import com.javier.health.models.User;
import com.javier.health.utils.Constants;

import garin.artemiy.sqlitesimple.library.SQLiteSimpleDAO;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public class UserDAO extends SQLiteSimpleDAO<User> {
    public UserDAO(Context context) {
        super(User.class, context, Constants.DATABASE_NAME);
    }
}
