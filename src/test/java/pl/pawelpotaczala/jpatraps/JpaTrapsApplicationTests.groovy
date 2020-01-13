package pl.pawelpotaczala.jpatraps

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class JpaTrapsApplicationTests extends Specification {

    def "load context"() {
        given:
        expect:
        1 == 1
    }
}
