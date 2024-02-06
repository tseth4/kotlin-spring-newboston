package tc.codealong.tutorials.springboot.thenewboston.datasource

import tc.codealong.tutorials.springboot.thenewboston.model.Bank

interface BankDataSource {
    fun retrieveBanks(): Collection<Bank>
}