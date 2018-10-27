package com.jmorata.test.adapter;

import com.jmorata.test.domain.AmericanFootballEvent;

import java.util.regex.Matcher;

public class AmericanFootballEventAdapter {

    public static AmericanFootballEvent from(Matcher matcher) {
        return AmericanFootballEvent.builder()
                .teamAName(matcher.group(1))
                .teamAScore(matcher.group(2))
                .teamBScore(matcher.group(3))
                .teamBName(matcher.group(4))
                .period(matcher.group(5))
                .build();
    }

}
