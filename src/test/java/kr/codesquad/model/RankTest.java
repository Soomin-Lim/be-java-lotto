package kr.codesquad.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("당첨 번호를 6개 맞춘 경우 1등이어야 한다.")
    @Test
    void findRankOfFirstPlace() {
        Rank rank = Rank.find(6, false);

        assertThat(rank).isEqualTo(Rank.FIRST);
        assertThat(rank.getPrize()).isEqualTo(2000000000);
    }

    @DisplayName("당첨 번호 5개와 보너스 번호를 맞춘 경우 2등이어야 한다.")
    @Test
    void findRankOfSecondPlace() {
        Rank rank = Rank.find(5, true);

        assertThat(rank).isEqualTo(Rank.SECOND);
        assertThat(rank.getPrize()).isEqualTo(30000000);
    }

    @DisplayName("당첨 번호를 5개 맞추고 보너스 번호를 맞추지 못한 경우 3등이어야 한다.")
    @Test
    void findRankOfThirdPlace() {
        Rank rank = Rank.find(5, false);

        assertThat(rank).isEqualTo(Rank.THIRD);
        assertThat(rank.getPrize()).isEqualTo(1500000);
    }

    @DisplayName("당첨 번호를 4개 맞춘 경우 4등이어야 한다.")
    @Test
    void findRankOfFourthPlace() {
        Rank rank = Rank.find(4, false);

        assertThat(rank).isEqualTo(Rank.FOURTH);
        assertThat(rank.getPrize()).isEqualTo(50000);
    }

    @DisplayName("당첨 번호를 3개 맞춘 경우 5등이어야 한다.")
    @Test
    void findRankOfFifthPlace() {
        Rank rank = Rank.find(3, false);

        assertThat(rank).isEqualTo(Rank.FIFTH);
        assertThat(rank.getPrize()).isEqualTo(5000);
    }

    @DisplayName("당첨 번호를 아무것도 맞추지 못한 경우 어떤 등수도 아니어야 한다.")
    @Test
    void findRankOfNothing() {
        Rank rank = Rank.find(0, false);

        assertThat(rank).isEqualTo(Rank.NOTHING);
        assertThat(rank.getPrize()).isEqualTo(0);
    }
}