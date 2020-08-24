package de.dreamit.rockpaperscissors.service

import de.dreamit.rockpaperscissors.model.Game
import de.dreamit.rockpaperscissors.model.Player

interface GameService {

    fun createGame(playerOne: Player, playerTwo: Player): Game
    fun evaluateGame(game: Game): Game
}
