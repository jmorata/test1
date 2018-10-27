package com.jmorata.test.adapter;

import com.jmorata.test.domain.FootballEvent;

import java.util.regex.Matcher;

public class FootballEventAdapter {

    public static FootballEvent from(Matcher matcher) {
        return FootballEvent.builder()
                .teamAName(matcher.group(1))
                .teamAScore(matcher.group(2))
                .teamBScore(matcher.group(3))
                .teamBName(matcher.group(4))
                .build();
    }

}
