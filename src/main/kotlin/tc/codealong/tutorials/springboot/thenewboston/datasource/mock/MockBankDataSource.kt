package tc.codealong.tutorials.springboot.thenewboston.datasource.mock

import org.springframework.stereotype.Repository
import tc.codealong.tutorials.springboot.thenewboston.datasource.BankDataSource
import tc.codealong.tutorials.springboot.thenewboston.model.Bank

@Repository
class MockBankDataSource : BankDataSource {
    val banks = mutableListOf(
        Bank("12345", 3.14, 17),
        Bank("1010", 17.0, 0),
        Bank("1234", 0.0, 100),
    )

    override fun retrieveBanks(): Collection<Bank> = banks
    override fun retrieveBank(accountNumber: String): Bank = banks.firstOrNull({ it.accountNumber == accountNumber })
        ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")

    override fun createBank(bank: Bank): Bank {
        if (banks.any { it.accountNumber == bank.accountNumber }) {
            throw IllegalArgumentException("Bank with account number ${bank.accountNumber} already exists")
        }
        banks.add(bank)
        return bank
    }

    override fun updateBank(bank: Bank): Bank {
//        TODO("Not yet implemented")
        val currentBank = banks.firstOrNull { it.accountNumber == bank.accountNumber }
            ?: throw NoSuchElementException("Bank with account number ${bank.accountNumber} not found.")

        banks.remove(currentBank)
        banks.add(bank)
        return bank
//        if (updatedBank == null){
//            throw NoSuchElementException("Bank with account number ${bank.accountNumber} not found.")
//        }
//
//        updatedBank.let {
//            // Assuming you want to update the balance and transactions
//            it.trust = bank.trust
//            it.transactionFee = bank.transactionFee
//        }


    }
    override fun deleteBank(accountNumber: String) {
        val currentBank = banks.firstOrNull { it.accountNumber == accountNumber}
            ?: throw NoSuchElementException("Bank with account number $accountNumber not found.")

        banks.remove(currentBank)
    }
}