package de.dreamit.rockpaperscissors.model

import de.dreamit.rockpaperscissors.enums.MoveType

data class Move(
    val type: MoveType
) : Comparable<Move> {

    override fun compareTo(other: Move): Int {

        if (type == MoveType.ROCK) {
            if (other.type == MoveType.ROCK) {
                return 0
            }
            if (other.type == MoveType.PAPER) {
                return -1
            }
            if (other.type == MoveType.SCISSOR) {
                return 1
            }
        }

        if (type == MoveType.PAPER) {
            if (other.type == MoveType.ROCK) {
                return 1
            }
            if (other.type == MoveType.PAPER) {
                return 0
            }
            if (other.type == MoveType.SCISSOR) {
                return -1
            }
        }

        if (type == MoveType.SCISSOR) {
            if (other.type == MoveType.ROCK) {
                return -1
            }
            if (other.type == MoveType.PAPER) {
                return 1
            }
            if (other.type == MoveType.SCISSOR) {
                return 0
            }
        }

        throw RuntimeException("Invalid move comparison")
    }
}
