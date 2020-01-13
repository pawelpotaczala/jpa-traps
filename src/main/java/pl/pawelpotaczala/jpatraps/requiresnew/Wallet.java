package pl.pawelpotaczala.jpatraps.requiresnew;

import lombok.Getter;
import lombok.Setter;

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

    @Setter
    private BigDecimal amount;

    public Wallet() {
        this.amount = BigDecimal.ZERO;
    }
}
