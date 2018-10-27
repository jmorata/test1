package com.jmorata.test.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;

@Builder
@lombok.Data
@JsonPropertyOrder({ "title", "teamAScore","teamBScore"})
public class TennisScoreBoardElement {

    private String title;
    private String teamAScore;
    private String teamBScore;

}
