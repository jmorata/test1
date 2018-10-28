package com.jmorata.test;

import com.jmorata.test.exception.EvenServiceException;
import com.jmorata.test.service.EventService;
import com.jmorata.test.swing.EventDialog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            EventService eventService=new EventService();
            EventDialog eventDialog=new EventDialog(eventService);
            eventDialog.display();

        } catch (EvenServiceException e) {
            logger.error(e.getMessage(),e);
        }
    }

}
