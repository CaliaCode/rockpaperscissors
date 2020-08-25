package de.dreamit.rockpaperscissors.controller.game

import de.dreamit.rockpaperscissors.enums.MoveType
import de.dreamit.rockpaperscissors.model.Game
import de.dreamit.rockpaperscissors.model.Move
import de.dreamit.rockpaperscissors.model.Player
import de.dreamit.rockpaperscissors.service.GameService
import de.dreamit.rockpaperscissors.service.RoundService
import org.springframework.stereotype.Service

@Service
class GameControllerServiceImpl(
    private val gameService: GameService,
    private val roundService: RoundService
) : GameControllerService {

    override fun playGame(roundCount: Int): Game {

        // Create Game
        val playerOne = Player("mr-rock", "Mr. ROCK", listOf(MoveType.ROCK))
        val playerTwo = Player("mr-random", "Mr. RANDOM", MoveType.values().toList())
        val game = gameService.createGame(playerOne, playerTwo)

        // Play Rounds
        for (round in 1..roundCount) {
            val playedRound = roundService.playRound(round, Move(MoveType.ROCK), Move(playerTwo.moveTypes.random()));

            game.rounds.add(playedRound)
        }

        // Evaluate Game
        return gameService.evaluateGame(game)
    }
}
