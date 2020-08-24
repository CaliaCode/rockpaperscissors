package de.dreamit.rockpaperscissors.model

data class PlayerStatistic(
    val player: Player,
    var win: Int = 0,
    var draw: Int = 0,
    var lose: Int = 0
)
