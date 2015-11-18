package com.javier.health;

import com.javier.health.webservices.Command;
import com.javier.health.webservices.GetCommand;
import com.javier.health.webservices.RequestImpl;
import com.javier.health.webservices.ResponseHandler;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public class GetCommandTest {
    @Test
    public void testGetCommandPerformsRequest() {

        String url = "SomeURL";
        String type;
        ResponseHandler handler = mock(ResponseHandler.class);

        RequestImpl mockClient = mock(RequestImpl.class);

        Command command = new GetCommand(url, mockClient, handler);

        command.execute();

        verify(mockClient).performGetRequest(url, handler);
    }

    @Test
    public void testGetCommandCallsHandlerWithSuccessfulResponse() {

        String url = "SomeURL";
        String type;
        ResponseHandler handler = mock(ResponseHandler.class);

        RequestImpl mockClient = mock(RequestImpl.class);

        GetCommand command = new GetCommand(url, mockClient, handler);

        command.execute();

        verify(mockClient).performGetRequest(url, handler);
    }

    @Test
    public void testGetCommandCallsHandlerWithFailureResponse() {

        String url = "SomeURL";
        String type;
        ResponseHandler handler = mock(ResponseHandler.class);

        RequestImpl mockClient = mock(RequestImpl.class);

        GetCommand command = new GetCommand(url, mockClient, handler);

        command.execute();

        verify(mockClient).performGetRequest(url, handler);
    }
}
