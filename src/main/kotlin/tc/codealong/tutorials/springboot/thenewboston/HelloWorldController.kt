package tc.codealong.tutorials.springboot.thenewboston

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/hello")
class HelloWorldController {

    fun helloMoon(): String = "Hello Moon!"

    @GetMapping("/world")
    fun helloWorld(): String {
        return "Hello, this is a REST endpoint!"
    }

}