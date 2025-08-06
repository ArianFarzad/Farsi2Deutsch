package org.example.server

import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress


class Server (port: Int) {
    val server = HttpServer.create(InetSocketAddress(port), 0)

    init {
        server.createContext("/") { exchange ->
            val response = "Hello from server"
            exchange.sendResponseHeaders(200, response.toByteArray().size.toLong())
            exchange.responseBody.use { it.write(response.toByteArray()) }
        }

        server.executor = null
        server.start()
        println("Server started, listening on $port")
    }
}