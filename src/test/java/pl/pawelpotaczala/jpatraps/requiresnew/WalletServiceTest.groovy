package pl.pawelpotaczala.jpatraps.requiresnew

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class WalletServiceTest extends Specification {

    @Autowired
    private WalletRepository walletRepository
    @Autowired
    private WalletService walletService

    def "should create empty wallet"() {
        when: "invoke method 'createWallet' and return wallet id"
        def walletId = walletService.createWallet().id
        and: "search wallet by its id"
        def dbWallet = walletRepository.findById(walletId)

        then: "dbWallet should be found"
        dbWallet.isPresent()
        and: "dbWallet id should exist"
        dbWallet.get().id != null
        and: "dbWallet id should have amount zero"
        dbWallet.get().amount == 0
    }
}
