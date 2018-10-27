package com.jmorata.test.domain;

import lombok.Builder;

@Builder
@lombok.Data
public class AmericanFootballEvent extends Event  {

    private String teamAName;
    private String teamAScore;
    private String teamBScore;
    private String teamBName;
    private String period;

}
