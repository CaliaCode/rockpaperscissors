package de.dreamit.rockpaperscissors.service

import de.dreamit.rockpaperscissors.enums.MoveType
import de.dreamit.rockpaperscissors.model.Move
import de.dreamit.rockpaperscissors.model.Player
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class GameServiceTests {

    @Autowired
    private lateinit var gameService: GameService

    @Autowired
    private lateinit var roundService: RoundService

    @Test
    fun `Assert "Game" is created correctly`() {
        val playerOne = Player("mr-rock", "Mr. ROCK", listOf(MoveType.ROCK))
        val playerTwo = Player("mr-random", "Mr. RANDOM", MoveType.values().toList())

        val game = gameService.createGame(playerOne, playerTwo)

        Assertions.assertThat(game.playerOneStatistic.player).isEqualTo(playerOne)
        Assertions.assertThat(game.playerTwoStatistic.player).isEqualTo(playerTwo)
    }

    @Test
    fun `Assert "Game" evaluation is correct`() {

        val playerOne = Player("mr-rock", "Mr. ROCK", listOf(MoveType.ROCK))
        val playerTwo = Player("mr-random", "Mr. RANDOM", listOf(MoveType.PAPER))
        val game = gameService.createGame(playerOne, playerTwo)

        val roundOne = roundService.playRound(1, Move(MoveType.ROCK), Move(MoveType.ROCK))
        val roundTwo = roundService.playRound(2, Move(MoveType.ROCK), Move(MoveType.PAPER))
        val roundThree = roundService.playRound(3, Move(MoveType.ROCK), Move(MoveType.SCISSOR))
        val roundFour = roundService.playRound(4, Move(MoveType.ROCK), Move(MoveType.SCISSOR))

        game.rounds.add(roundOne)
        game.rounds.add(roundTwo)
        game.rounds.add(roundThree)
        game.rounds.add(roundFour)

        val evaluatedGame = gameService.evaluateGame(game)

        Assertions.assertThat(evaluatedGame.playerOneStatistic.player).isEqualTo(playerOne)
        Assertions.assertThat(evaluatedGame.playerTwoStatistic.player).isEqualTo(playerTwo)

        Assertions.assertThat(evaluatedGame.playerOneStatistic.win).isEqualTo(2)
        Assertions.assertThat(evaluatedGame.playerOneStatistic.draw).isEqualTo(1)
        Assertions.assertThat(evaluatedGame.playerOneStatistic.lose).isEqualTo(1)

        Assertions.assertThat(evaluatedGame.playerTwoStatistic.win).isEqualTo(1)
        Assertions.assertThat(evaluatedGame.playerTwoStatistic.draw).isEqualTo(1)
        Assertions.assertThat(evaluatedGame.playerTwoStatistic.lose).isEqualTo(2)

        Assertions.assertThat(evaluatedGame.rounds.size).isEqualTo(4)
    }
}
