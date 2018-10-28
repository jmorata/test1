package com.jmorata.test;

import com.jmorata.test.service.EventService;
import com.jmorata.test.swing.EventDialog;

public class Main {

    public static void main(String[] args) {
            EventService eventService=new EventService();
            EventDialog eventDialog=new EventDialog(eventService);
            eventDialog.display();
    }

}
