package com.github.jwcarman;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

/**
 * Solution to <a href="https://dev.to/thepracticaldev/daily-challenge-128-blackjack-scorer-4lhp">#128</a>.
 */
public class BlackjackScorer {
    private static final Logger log = LoggerFactory.getLogger(BlackjackScorer.class);

    public static final String ACE = "A";
    public static final String ONE = "1";
    private static final Map<String, Integer> CARD_VALUES = Map.ofEntries(
            entry(ACE, 11),
            entry("K", 10),
            entry("Q", 10),
            entry("J", 10),
            entry("10", 10),
            entry("9", 9),
            entry("8", 8),
            entry("7", 7),
            entry("6", 6),
            entry("5", 5),
            entry("4", 4),
            entry("3", 3),
            entry("2", 2),
            entry(ONE, 1)
    );

    public static int scoreHand(String... hand) {
        final List<String> cards = new ArrayList<>(Arrays.asList(hand));
        int sum = sumOf(cards);
        while (sum > 21 && cards.contains(ACE)) {
            cards.remove(ACE);
            cards.add(ONE);
            sum = sumOf(cards);
        }
        return sum;
    }

    private static int sumOf(List<String> cards) {

        int score = cards.stream().mapToInt(CARD_VALUES::get).sum();
        log.debug("Scoring of {} = {}", cards, score);
        return score;
    }

}
