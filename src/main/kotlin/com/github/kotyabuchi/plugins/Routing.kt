package com.github.kotyabuchi.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.resources.*
import kotlinx.serialization.Serializable
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.resources.*
import io.ktor.server.resources.Resources
import io.ktor.server.routing.get

fun Application.configureRouting() {
    install(Resources)

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get<Articles> { article ->
            // Get all articles ...
            call.respond("List of articles sorted starting from ${article.sort}")
        }
    }
}

@Serializable
@Resource("/articles")
class Articles(val sort: String? = "new")
