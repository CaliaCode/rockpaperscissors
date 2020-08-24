package de.dreamit.rockpaperscissors.model

import de.dreamit.rockpaperscissors.enums.MoveType

data class Player(
    val id: String,
    val name: String,
    val moveTypes: List<MoveType>
)
