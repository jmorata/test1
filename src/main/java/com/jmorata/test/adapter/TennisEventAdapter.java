package com.jmorata.test.adapter;

import com.jmorata.test.domain.TennisEvent;
import com.jmorata.test.domain.TennisScoreBoard;
import com.jmorata.test.domain.TennisScoreBoardElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class TennisEventAdapter {

    public static TennisEvent from(Matcher matcher) {
        return TennisEvent.builder()
                .teamAName(matcher.group(1))
                .teamAGames(matcher.group(3))
                .teamAScore(matcher.group(4))
                .teamBScore(matcher.group(5))
                .teamBGames(matcher.group(6))
                .teamBServing(getIsServing(matcher.group(8)))
                .teamBName(matcher.group(9))
                .scoreboard(getScoreBoard(matcher))
                .build();
    }

    private static TennisScoreBoard getScoreBoard(Matcher matcher) {
        return TennisScoreBoard.builder().elements(getScoreBoardElements(matcher)).build();
    }

    private static List<TennisScoreBoardElement> getScoreBoardElements(Matcher matcher) {
        List<TennisScoreBoardElement> elements=new ArrayList<>();
        elements.add(getTennisScoreBoardElement(matcher));
        return elements;
    }

    private static TennisScoreBoardElement getTennisScoreBoardElement(Matcher matcher) {
        return TennisScoreBoardElement.builder()
                .title("Sets")
                .teamAScore(matcher.group(2))
                .teamBScore(matcher.group(7))
                .build();
    }

    private static Boolean getIsServing(String serving) {
        return "*".equals(serving);
    }

}
