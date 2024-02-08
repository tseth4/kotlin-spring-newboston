package tc.codealong.tutorials.springboot.thenewboston.service

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import tc.codealong.tutorials.springboot.thenewboston.datasource.BankDataSource
import tc.codealong.tutorials.springboot.thenewboston.model.Bank

@Service
class BankService(@Qualifier("network") private val dataSource: BankDataSource) {
    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()
    fun getBank(accountNumber: String): Bank = dataSource.retrieveBank(accountNumber)
    fun addBank(bank: Bank): Bank = dataSource.createBank(bank)

    fun updateBank(bank: Bank): Bank = dataSource.updateBank(bank)

    fun deleteBank(accountNumber: String): Unit = dataSource.deleteBank(accountNumber)
}