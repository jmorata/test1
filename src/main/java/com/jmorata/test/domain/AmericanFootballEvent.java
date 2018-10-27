package com.jmorata.test.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;

@Builder
@lombok.Data
@JsonPropertyOrder({ "teamAName", "teamBName","teamAScore", "teamBScore" })
public class AmericanFootballEvent extends Event  {

    private String teamAName;
    private String teamAScore;
    private String teamBScore;
    private String teamBName;
    private String period;

}
