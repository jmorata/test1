package com.jmorata.test.swing;

import com.jmorata.test.exception.EvenServiceException;
import com.jmorata.test.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

public class EventDialog {

    private static final String EVEN_FIELD = "F.C. Barcelona 3-2 Real Madrid";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private EventService eventService;

    public EventDialog(EventService eventService) {
        this.eventService = eventService;
    }

    public void display() {
        JTextField eventField = new JTextField(EVEN_FIELD);
        JTextField jsonField = new JTextField();
        JPanel panel = getJPanel(eventField, jsonField);

        Boolean exit = false;
        while (!exit) {
            int result = getResult(panel);
            if (result == JOptionPane.OK_OPTION) {
                String input = eventField.getText();
                String json = getJson(input);
                jsonField.setText(json);

                logger.info(input);
                logger.info(json);

            } else {
                exit = true;
            }
        }
    }

    private String getJson(String input) {
        try {
            return eventService.parse(input);

        } catch (EvenServiceException e) {
            logger.error(e.getMessage(), e);
            return e.getCause().getMessage();
        }
    }

    private int getResult(JPanel panel) {
        return JOptionPane.showConfirmDialog(null, panel, "Event test",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    }

    private JPanel getJPanel(JTextField eventField, JTextField jsonField) {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Event:"));
        panel.add(eventField);
        panel.add(new JLabel("Json:"));
        panel.add(jsonField);
        return panel;
    }

}
