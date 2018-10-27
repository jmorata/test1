package com.jmorata.test.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmorata.test.domain.Event;
import com.jmorata.test.exception.EvenServiceException;
import com.jmorata.test.factory.EventFactory;

public class EventService {

    private String input;

    public EventService(String input) {
        this.input = input;
    }

    public String parse() throws EvenServiceException {
        try {
            Event event = EventFactory.getInstance(input);
            String result = new ObjectMapper().writeValueAsString(event);

            return result;

        } catch (Exception e) {
            throw new EvenServiceException("Error processing event", e);
        }
    }

}
