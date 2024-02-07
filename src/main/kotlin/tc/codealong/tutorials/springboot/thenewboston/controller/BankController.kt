package tc.codealong.tutorials.springboot.thenewboston.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tc.codealong.tutorials.springboot.thenewboston.model.Bank
import tc.codealong.tutorials.springboot.thenewboston.service.BankService


@RestController
@RequestMapping("api/banks")
class BankController(private val service: BankService) {

    @GetMapping
    fun getBanks(): Collection<Bank> = service.getBanks()

    @GetMapping("/{accountNumber}")
    fun getBank(@PathVariable accountNumber: String): Bank = service.getBank(accountNumber)
    // we want to use a pathvariable which tells spring to get the value from the requests path

}