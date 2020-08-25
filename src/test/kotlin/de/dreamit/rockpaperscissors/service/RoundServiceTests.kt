package de.dreamit.rockpaperscissors.service

import de.dreamit.rockpaperscissors.enums.MoveType
import de.dreamit.rockpaperscissors.model.Move
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RoundServiceTests {

    @Autowired
    private lateinit var roundService: RoundService

    @Test
    fun `Assert that "Round" get played correctly`() {

        val roundNumber = 35
        val movePlayerOne = Move(MoveType.ROCK)
        val movePlayerTwo = Move(MoveType.PAPER)

        val round = roundService.playRound(roundNumber, movePlayerOne, movePlayerTwo)

        Assertions.assertThat(round.number).isEqualTo(35)
        Assertions.assertThat(round.movePlayerOne).isEqualTo(movePlayerOne)
        Assertions.assertThat(round.movePlayerTwo).isEqualTo(movePlayerTwo)
    }
}
