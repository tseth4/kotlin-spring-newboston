package tc.codealong.tutorials.springboot.thenewboston.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tc.codealong.tutorials.springboot.thenewboston.model.Bank
import tc.codealong.tutorials.springboot.thenewboston.service.BankService


@RestController
@RequestMapping("api/banks")
class BankController(private val service: BankService) {

    @GetMapping
    fun getBanks(): Collection<Bank> = service.getBanks()

}