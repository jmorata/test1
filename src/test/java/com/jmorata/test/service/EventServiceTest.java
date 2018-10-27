package com.jmorata.test.service;

import com.jmorata.test.exception.EvenServiceException;
import org.junit.Assert;
import org.junit.Test;

public class EventServiceTest {

    @Test(expected = EvenServiceException.class)
    public void test_not_valid_event() throws EvenServiceException {
        String input = "F.C. Barcelona 3-2";
        parseEvent(input);
    }

    @Test
    public void test_football_event() throws EvenServiceException {
        String input = "F.C. Barcelona 3-2 Real Madrid";
        String result = parseEvent(input);
        Assert.assertEquals("{\"teamAName\":\"F.C. Barcelona\",\"teamBName\":\"Real Madrid\",\"teamAScore\":\"3\",\"teamBScore\":\"2\"}", result);
    }

    @Test
    public void test_tennis_event_serving() throws EvenServiceException {
        String input = "Anna Karolina Schmiedlova (1) 1 40-Adv 1 (0) *Varvara Lepchenko";
        String result = parseEvent(input);
        Assert.assertEquals("{\"teamAName\":\"Anna Karolina Schmiedlova\",\"teamBName\":\"Varvara Lepchenko\",\"teamAScore\":\"40\",\"teamBScore\":\"Adv\",\"teamAGames\":\"1\",\"teamBGames\":\"1\",\"teamBServing\":true,\"scoreboard\":{\"elements\":[{\"title\":\"Sets\",\"teamAScore\":\"1\",\"teamBScore\":\"0\"}]}}", result);
    }

    @Test
    public void test_tennis_event_not_serving() throws EvenServiceException {
        String input = "Anna Karolina Schmiedlova (1) 1 40-Adv 1 (0) Varvara Lepchenko";
        String result = parseEvent(input);
        Assert.assertEquals("{\"teamAName\":\"Anna Karolina Schmiedlova\",\"teamBName\":\"Varvara Lepchenko\",\"teamAScore\":\"40\",\"teamBScore\":\"Adv\",\"teamAGames\":\"1\",\"teamBGames\":\"1\",\"teamBServing\":false,\"scoreboard\":{\"elements\":[{\"title\":\"Sets\",\"teamAScore\":\"1\",\"teamBScore\":\"0\"}]}}", result);
    }

    @Test
    public void test_american_football_event() throws EvenServiceException {
        String input = "Pittsburgh Steelers 3-7 Minnesota Vikings 3rd Quarter";
        String result = parseEvent(input);
    }

    private String parseEvent(String input) throws EvenServiceException {
        EventService eventService = new EventService(input);
        return eventService.parse();
    }

}