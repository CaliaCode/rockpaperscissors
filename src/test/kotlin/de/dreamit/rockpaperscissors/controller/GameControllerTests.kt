package de.dreamit.rockpaperscissors.controller

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GameControllerTests(
    @Autowired val restTemplate: TestRestTemplate
) {

    @Test
    fun `Assert "Home" page title, content and status code`() {

        val entity = restTemplate.getForEntity<String>("/")

        Assertions.assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        Assertions.assertThat(entity.body).contains("<title>Home - dreamIt</title>")
    }

    @Test
    fun `Assert "Game Result" page title, content and status code`() {

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_FORM_URLENCODED

        val requestBody: MultiValueMap<String, Number> = LinkedMultiValueMap()
        requestBody.add("roundCount", 200)

        val request = HttpEntity(requestBody, headers)
        val entity = restTemplate.postForEntity<String>("/", request, String::class.java)

        Assertions.assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        Assertions.assertThat(entity.body).contains("<title>Game Results - dreamIt</title>")
    }
}
