package com.github.jwcarman;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BlackjackScorerTest {
    @Test
    public void blackJackShouldBe21() {
        assertThat(BlackjackScorer.scoreHand("A", "J")).isEqualTo(21);
    }

    @Test
    public void shouldDemoteAcesWhenBusted() {
        assertThat(BlackjackScorer.scoreHand("A", "A", "A", "K", "7")).isEqualTo(20);
    }

    @Test
    public void shouldGiveUpWhenBusted() {
        assertThat(BlackjackScorer.scoreHand("K", "J", "2")).isEqualTo(22);
    }

    @Test
    public void shouldScoreSingleCardCorrectly() {
        assertThat(BlackjackScorer.scoreHand("A")).isEqualTo(11);
    }

    @Test
    public void shouldNotDemoteAcesWhenValid() {
        assertThat(BlackjackScorer.scoreHand("A", "9")).isEqualTo(20);
    }

    @Test
    public void shouldOnlyDemoteAsManyAcesAsNeededToBeValid() {
        assertThat(BlackjackScorer.scoreHand("A", "A", "9")).isEqualTo(21);
    }
}