package pl.pawelpotaczala.jpatraps.requiresnew

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class PersonServiceTest extends Specification {

    @Autowired
    private PersonService personService
    @Autowired
    private PersonRepository personRepository

    def "should create person with initial amount of wallet"() {
        when: "invoke 'createPerson' method"
        def jeremyId = personService.createPerson("Jeremy", BigDecimal.TEN)
        and: "get jeremy by his id"
        def jeremy = personRepository.findById(jeremyId)

        then: "jeremy should be found"
        jeremy.isPresent()

        then: "get jeremy's wallet from jeremy"
        def jeremyWallet = jeremy.get().wallet
        and: "jeremy wallet should not be null"
        jeremyWallet != null
        and: "jeremy wallet's id should not be null"
        jeremyWallet.id != null
        and: "jeremy wallet's amount should be ten"
        jeremyWallet.amount == BigDecimal.TEN
    }
}

