package de.dreamit.rockpaperscissors.service

import de.dreamit.rockpaperscissors.model.Move
import de.dreamit.rockpaperscissors.model.Round

interface RoundService {
    fun playRound(number: Int, movePlayerOne: Move, movePlayerTwo: Move): Round;
}
