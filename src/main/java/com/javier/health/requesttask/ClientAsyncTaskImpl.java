package com.javier.health.requesttask;

import android.os.AsyncTask;

import com.javier.health.models.Response;
import com.javier.health.webservices.ResponseListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public class ClientAsyncTaskImpl extends AsyncTask<String, Void, Response> implements ClientAsyncTask {

    private ResponseListener listener;

    @Override
    public void executeAsync(ResponseListener mListener, String url, String type) {

        this.listener = mListener;

        this.execute(url, type);
    }

    @Override
    protected Response doInBackground(String... params) {

        final String url = params[0];
        final String type = params[1];

        return callClient(url, type);
    }

    public Response callClient(final String url, final String type) {

        Response responseModel = new Response();
        String responseJson;

        try {
            URL obj = new URL(url);

            HttpURLConnection connection = HttpURLConnectionFactory.getHttpURLConnection(obj);

            connection.setRequestMethod(type);


            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();


            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            responseJson = response.toString();


//            Log.v("Asyntask", String.valueOf(con.getResponseCode()));

            //con.getResponseCode() //set statusCode to Response obj
            responseModel.setContent(connection.getContent()); // set the body to the T response
            responseModel.setHeaders(connection.getHeaderFields());
            responseModel.setCode(connection.getResponseCode());
            responseModel.setInfo(responseJson);
//            Log.v("Client",con.getResponseCode());
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
            responseJson = e.toString();
            responseModel.setInterneterror(true);
            listener.onError(e.toString());
        }

        return responseModel;
    }

    @Override
    protected void onPostExecute(Response response) {
        super.onPostExecute(response);


        if (response.isInterneterror()) {

            listener.onGeneralError();

        } else {
            if (response.checkStatusCode(response.getCode())) {
                listener.onSuccess(response.getInfo());
            } else {
                listener.onError(response.getInfo());
            }

        }

    }
}
