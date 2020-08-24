package de.dreamit.rockpaperscissors.service

import de.dreamit.rockpaperscissors.enums.MoveType
import de.dreamit.rockpaperscissors.model.Game
import de.dreamit.rockpaperscissors.model.Player
import de.dreamit.rockpaperscissors.model.PlayerStatistic
import org.springframework.stereotype.Service

@Service
class GameServiceImpl : GameService {

    override fun createGame(playerOne: Player, playerTwo: Player): Game {

        val playerOneStatistics = PlayerStatistic(playerOne)
        val playerTwoStatistics = PlayerStatistic(playerTwo)

        return Game(playerOneStatistics, playerTwoStatistics);
    }

    override fun evaluateGame(game: Game): Game {

        for (round in game.rounds) {
            when(round.movePlayerOne.compareTo(round.movePlayerTwo)) {
               1 -> {
                   game.playerOneStatistic.win += 1
                   game.playerTwoStatistic.lose += 1
               }
               0 -> {
                   game.playerOneStatistic.draw += 1
                   game.playerTwoStatistic.draw += 1
               }
               -1 -> {
                   game.playerOneStatistic.lose += 1
                   game.playerTwoStatistic.win += 1
               }

            }
        }

        return game;
    }
}
