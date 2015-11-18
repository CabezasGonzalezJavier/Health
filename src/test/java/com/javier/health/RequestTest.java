package com.javier.health;

import com.javier.health.requesttask.ClientHTTP;
import com.javier.health.requesttask.ClientHTTPFactory;
import com.javier.health.utils.Constants;
import com.javier.health.webservices.Request;
import com.javier.health.webservices.RequestImpl;
import com.javier.health.webservices.ResponseHandler;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public class RequestTest {
    Request mRequest;
    String mUrl;
    ResponseHandler mockResponseHandler;
    ClientHTTP mockClientHTTP;

    @Before
    public void setup() {
        mRequest = new RequestImpl();
        mockResponseHandler = mock(ResponseHandler.class);
        mockClientHTTP = mock(ClientHTTP.class);
        mUrl = Constants.URL;
        ClientHTTPFactory.setMockClientHTTP(mockClientHTTP);
    }

    @Test
    public void responseTestReturns() {
        mRequest.performGetRequest(mUrl, mockResponseHandler);
        verify(mockClientHTTP).get(mUrl);
    }
}
