package de.dreamit.rockpaperscissors.service

import de.dreamit.rockpaperscissors.model.Move
import de.dreamit.rockpaperscissors.model.Round
import org.springframework.stereotype.Service

@Service
class RoundServiceImpl : RoundService {

    override fun playRound(number: Int, movePlayerOne: Move, movePlayerTwo: Move): Round {

        return Round(number, movePlayerOne, movePlayerTwo)
    }
}
