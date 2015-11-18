package com.javier.health.requesttask;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public interface ClientHTTP {
    void get(String url);
    void post(String url);
    void put(String url);
    void delete(String url);
}
