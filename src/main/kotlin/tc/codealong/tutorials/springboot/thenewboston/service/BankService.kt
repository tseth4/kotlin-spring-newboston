package tc.codealong.tutorials.springboot.thenewboston.service

import org.springframework.stereotype.Service
import tc.codealong.tutorials.springboot.thenewboston.datasource.BankDataSource
import tc.codealong.tutorials.springboot.thenewboston.model.Bank

@Service
class BankService(private val dataSource: BankDataSource) {
    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()
}