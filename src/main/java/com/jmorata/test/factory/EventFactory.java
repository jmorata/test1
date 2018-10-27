package com.jmorata.test.factory;

import com.jmorata.test.adapter.AmericanFootballEventAdapter;
import com.jmorata.test.adapter.FootballEventAdapter;
import com.jmorata.test.adapter.TennisEventAdapter;
import com.jmorata.test.domain.Event;
import com.jmorata.test.exception.EvenFactoryException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventFactory {

    private static String TENNIS_PATTERN = "(.*)\\s[(](\\d+)[)]\\s(\\d+)\\s(\\d+)-(\\w+)\\s(\\d+)\\s[(](\\d+)[)]\\s([*]?)(.*)";
    private static String AMERICAN_FOOTBALL_PATTERN = "(.*)\\s(\\d+)-(\\d+)\\s(.*)\\s((1st|2nd|3rd|4th)\\sQuarter)";
    private static String FOOTBALL_PATTERN = "(.*)\\s(\\d+)-(\\d+)\\s(.*)";

    public static Event getInstance(String input) throws EvenFactoryException {
        try {
            Pattern pattern = Pattern.compile(TENNIS_PATTERN);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                return TennisEventAdapter.from(matcher);
            }

            pattern = Pattern.compile(AMERICAN_FOOTBALL_PATTERN);
            matcher = pattern.matcher(input);
            if (matcher.find()) {
                return AmericanFootballEventAdapter.from(matcher);
            }

            pattern = Pattern.compile(FOOTBALL_PATTERN);
            matcher = pattern.matcher(input);
            if (matcher.find()) {
                return FootballEventAdapter.from(matcher);
            }

            else {
                throw new EvenFactoryException("Not valid input: " + input);
            }

        } catch (EvenFactoryException e) {
            throw e;

        } catch (Exception e) {
            throw new EvenFactoryException("Error processing input", e);
        }
    }

}
