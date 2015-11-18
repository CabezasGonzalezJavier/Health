package com.javier.health;

import com.javier.health.utils.Constants;
import com.javier.health.webservices.Command;
import com.javier.health.webservices.CommandFactory;
import com.javier.health.webservices.GetCommand;
import com.javier.health.webservices.RequestFactory;
import com.javier.health.webservices.RequestImpl;
import com.javier.health.webservices.ResponseHandler;
import com.javier.health.webservices.ResponseImpl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public class CommandFactoryTest {
    String mUrl;
    ResponseHandler mockResponseHandler;
    GetCommand mockGetCommand;
    CommandFactory mCommandFactory;
    ResponseImpl mockResponseImpl;

    RequestImpl mockRequestImpl;

    @Before
    public void setup() {
        mUrl = Constants.URL;
        mockGetCommand = mock(GetCommand.class);
        mockResponseImpl = mock(ResponseImpl.class);


        mCommandFactory = new CommandFactory();
        mockResponseHandler = mock(ResponseHandler.class);
        mockRequestImpl = mock(RequestImpl.class);
        RequestFactory.setMockRequest(mockRequestImpl);
    }

    @Test
    public void commandFactoryTestNotNull(){
        Command command = mCommandFactory.createGetCommand(mUrl, mockResponseHandler);
        assertNotNull(command);
        assertTrue(command.getClass().equals(GetCommand.class));
    }

}
