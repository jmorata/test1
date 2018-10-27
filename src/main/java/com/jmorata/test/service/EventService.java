package com.jmorata.test.service;

import com.jmorata.test.domain.Event;
import com.jmorata.test.exception.EvenFactoryException;
import com.jmorata.test.factory.EventFactory;

public class EventService {

    private String input;

    public EventService(String input) {
        this.input = input;
    }

    public void parse() throws EvenFactoryException {
        Event event=EventFactory.getInstance(input);

    }

}
