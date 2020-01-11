package pl.pawelpotaczala.jpatraps.requiresnew

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class WalletServiceTest extends Specification {

    @Autowired
    private PersonRepository personRepository
    @Autowired
    private WalletRepository walletRepository
    @Autowired
    private WalletService walletService

    def "should create and add empty wallet to person"() {
        given: "saved person margaret"
        def margaret = personRepository.save(new Person("Margaret"))

        when: "invoke method 'createWalletAndAttachToPerson' and return margaret wallet id"
        def walletId = walletService.createWalletAndAttachToPerson(margaret.id).id
        and: "search wallet by its id"
        def dbWallet = walletRepository.findById(walletId)

        then: "dbWallet should be found"
        dbWallet.isPresent()

        when: "search margaret by her id"
        def dbMargaret = personRepository.findById(margaret.id)
        then: "dbMargaret should be found"
        dbMargaret.isPresent()

        then: "having a margaret wallet from her person"
        def margaretWallet = dbMargaret.get().wallet
        and: "wallet should exist"
        margaretWallet != null
        and: "wallet id should exist"
        margaretWallet.id != null
        and: "wallet id should have amount zero"
        margaretWallet.amount == 0
    }
}
