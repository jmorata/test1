package com.jmorata.test.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;

@Builder
@lombok.Data
@JsonPropertyOrder({ "teamAName", "teamBName","teamAScore", "teamBScore", "teamAGames", "teamBGames", "teamBServing", "scoreboard"})
public class TennisEvent extends Event {

    private String teamAName;
    private String teamAScore;
    private String teamBScore;
    private String teamBName;
    private String teamAGames;
    private String teamBGames;
    private Boolean teamBServing;
    private TennisScoreBoard scoreboard;

}
