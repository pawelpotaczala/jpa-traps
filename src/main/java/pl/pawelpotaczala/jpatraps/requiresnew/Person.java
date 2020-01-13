package pl.pawelpotaczala.jpatraps.requiresnew;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @Setter
    @OneToOne
    private Wallet wallet;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Wallet wallet) {
        this.name = name;
        this.wallet = wallet;
    }
}
