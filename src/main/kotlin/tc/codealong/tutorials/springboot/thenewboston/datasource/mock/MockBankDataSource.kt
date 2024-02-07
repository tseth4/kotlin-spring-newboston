package tc.codealong.tutorials.springboot.thenewboston.datasource.mock

import org.springframework.stereotype.Repository
import tc.codealong.tutorials.springboot.thenewboston.datasource.BankDataSource
import tc.codealong.tutorials.springboot.thenewboston.model.Bank

@Repository
class MockBankDataSource : BankDataSource {
    val banks = listOf(
        Bank("12345", 3.14, 17),
        Bank("1010", 17.0, 0),
        Bank("1234", 0.0, 100),
    )

    override fun retrieveBanks(): Collection<Bank> = banks
    override fun retrieveBank(accountNumber: String): Bank = banks.firstOrNull({ it.accountNumber == accountNumber })
        ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")
}