package de.dreamit.rockpaperscissors.model

data class Game(
    val playerOneStatistic: PlayerStatistic,
    val playerTwoStatistic: PlayerStatistic,
    val rounds: MutableList<Round> = mutableListOf()
)
