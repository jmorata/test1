package com.jmorata.test.domain;

import lombok.Builder;

import java.util.regex.Matcher;

@Builder
@lombok.Data
public class FootballEvent extends Event {

    private String teamAName;
    private String teamAScore;
    private String teamBScore;
    private String teamBName;

}
