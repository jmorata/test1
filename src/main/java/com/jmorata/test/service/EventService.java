package com.jmorata.test.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmorata.test.domain.Event;
import com.jmorata.test.exception.EvenServiceException;
import com.jmorata.test.factory.EventFactory;

public class EventService {

    public String parse(String input) throws EvenServiceException {
        try {
            Event event = EventFactory.getInstance(input);
            return new ObjectMapper().writeValueAsString(event);

        } catch (Exception e) {
            throw new EvenServiceException("Error processing event", e);
        }
    }

}
