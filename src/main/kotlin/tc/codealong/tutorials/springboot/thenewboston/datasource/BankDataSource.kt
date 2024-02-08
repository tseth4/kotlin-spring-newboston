package tc.codealong.tutorials.springboot.thenewboston.datasource

import tc.codealong.tutorials.springboot.thenewboston.model.Bank

interface BankDataSource {
    fun retrieveBanks(): Collection<Bank>
    fun retrieveBank(accountNumber: String): Bank
    fun createBank(bank: Bank): Bank

    fun updateBank(bank: Bank): Bank
}