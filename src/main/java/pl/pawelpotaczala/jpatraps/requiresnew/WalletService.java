package pl.pawelpotaczala.jpatraps.requiresnew;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class WalletService {

    private final WalletRepository walletRepository;
    private final PersonRepository personRepository;

    public Wallet createWallet(BigDecimal money) {
        Wallet emptyWallet = new Wallet(money);
        return walletRepository.save(emptyWallet);
    }

}
