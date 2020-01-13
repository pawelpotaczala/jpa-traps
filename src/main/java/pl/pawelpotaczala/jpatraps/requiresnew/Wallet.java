package pl.pawelpotaczala.jpatraps.requiresnew;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Entity
public class Wallet {

    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal amount;

    public Wallet() {
        this.amount = BigDecimal.ZERO;
    }
}
