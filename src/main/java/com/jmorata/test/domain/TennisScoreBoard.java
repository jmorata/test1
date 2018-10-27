package com.jmorata.test.domain;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
@lombok.Data
public class TennisScoreBoard {

    private List<TennisScoreBoardElement> elements;

}
