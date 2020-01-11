package pl.pawelpotaczala.jpatraps.requiresnew;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final WalletService walletService;

    // Spring checks if there is an active transaction, then it creates a new one if nothing existed.
    // Otherwise, the business logic appends to the currently active transaction
    @Transactional
    public long createPerson(String name) {
        Person person = new Person(name);
        personRepository.save(person);

        walletService.createWalletAndAttachToPerson(person);

        return person.getId();
    }

}
