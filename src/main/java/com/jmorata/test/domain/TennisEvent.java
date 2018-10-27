package com.jmorata.test.domain;

import lombok.Builder;

@Builder
@lombok.Data
public class TennisEvent extends Event {

    private String teamAName;
    private String teamAScore;
    private String teamBScore;
    private String teamBName;
    private String teamASets;
    private String teamAGames;
    private String teamBGames;
    private String teamBSets;
    private Boolean isServing;

}
