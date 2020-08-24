package de.dreamit.rockpaperscissors.controller.game

import de.dreamit.rockpaperscissors.model.Game

interface GameControllerService {
    fun playGame(roundCount: Int): Game
}
