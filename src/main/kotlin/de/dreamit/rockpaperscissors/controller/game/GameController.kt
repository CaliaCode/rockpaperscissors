package de.dreamit.rockpaperscissors.controller.game

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class GameController(
    val gameControllerService: GameControllerService
) {

    @GetMapping("/")
    fun home(model: Model): String {

        model["title"] = "Home"

        return "home"
    }

    @PostMapping("/")
    fun playGame(model: Model, roundCount: Int = 100): String {

        model["title"] = "Game Results"
        model["game"] = gameControllerService.playGame(roundCount)

        return "result"
    }
}
