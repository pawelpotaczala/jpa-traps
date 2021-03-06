package pl.pawelpotaczala.jpatraps.requiresnew;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final WalletService walletService;

    // Spring checks if there is an active transaction, then it creates a new one if nothing existed.
    // Otherwise, the business logic appends to the currently active transaction
    @Transactional
    public long createPerson(String name, BigDecimal money) {
        Person person = new Person(name);
        personRepository.save(person);

        Wallet wallet = walletService.createWallet(money);
        if(wallet.getAmount().compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Initial amount of money cannot be less than zero");
        }

        person.setWallet(wallet);

        return person.getId();
    }

}
