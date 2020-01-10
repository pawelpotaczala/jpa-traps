package pl.pawelpotaczala.jpatraps.requiresnew;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class WalletService {

    private final WalletRepository walletRepository;

    // Spring suspends the current transaction if it exists and then creates a new one
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Wallet createWalletAndAttachToPerson(Person person) {
        Wallet emptyWallet = new Wallet();
        walletRepository.save(emptyWallet);

        person.setWallet(emptyWallet);

        return emptyWallet;
    }

}