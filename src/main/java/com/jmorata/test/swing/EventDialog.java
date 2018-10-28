package com.jmorata.test.swing;

import com.jmorata.test.exception.EvenServiceException;
import com.jmorata.test.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

public class EventDialog {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private EventService eventService;

    public EventDialog(EventService eventService) {
        this.eventService = eventService;
    }

    public void display() throws EvenServiceException {
        JTextField eventField = new JTextField("F.C. Barcelona 3-2 Real Madrid");
        JTextField jsonField = new JTextField();
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Event:"));
        panel.add(eventField);
        panel.add(new JLabel("Json:"));
        panel.add(jsonField);

        Boolean exit=false;
        while(!exit) {
            int result = JOptionPane.showConfirmDialog(null, panel, "Event test",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                String input=eventField.getText();
                String json=eventService.parse(input);
                jsonField.setText(json);

                logger.info(input);
                logger.info(json);

            } else {
                exit=true;
            }
        }
    }

}
