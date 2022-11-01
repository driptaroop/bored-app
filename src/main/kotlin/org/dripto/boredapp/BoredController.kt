package org.dripto.boredapp

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import java.net.InetAddress

@RestController
class BoredController(private val restTemplate: RestTemplate) {
    private val hostname: String = InetAddress.getLocalHost().hostName
    @GetMapping("/whattodo")
    fun bored(): Todo = restTemplate.getForObject<BoredApiResponse>("/activity").let {
        Todo(activity = it.activity, type = it.type, assigner = hostname)
    }
}

data class Todo(
    val activity: String,
    val type: ActivityType,
    val assigner: String
) {
    enum class ActivityType {
        education, recreational, social, diy, charity, cooking, relaxation, music, busywork
    }
}

data class BoredApiResponse(
    val activity: String,
    val type: Todo.ActivityType
)