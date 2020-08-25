package de.dreamit.rockpaperscissors.controller

import de.dreamit.rockpaperscissors.controller.game.GameControllerService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class GameControllerServiceTests {

    @Autowired
    private lateinit var gameControllerService: GameControllerService

    @Test
    fun `Assert "game" has correct statistic`() {
        val game = gameControllerService.playGame(350)

        val playerOneTotalRoundCount = game.playerOneStatistic.win + game.playerOneStatistic.draw + game.playerOneStatistic.lose
        val playerTwoTotalRoundCount = game.playerTwoStatistic.win + game.playerTwoStatistic.draw + game.playerTwoStatistic.lose

        Assertions.assertThat(playerOneTotalRoundCount).isEqualTo(350)
        Assertions.assertThat(playerTwoTotalRoundCount).isEqualTo(350)
        Assertions.assertThat(game.rounds.size).isEqualTo(350)
    }
}
