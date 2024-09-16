package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ManyToMany
  private Collection<Address> addresses;

  @OneToMany(mappedBy = "owner")
  private Collection<CreditCard> creditCards;

  public String getName() {
    return name;
  }

  public Collection<Address> getAddresses() {
    return addresses;
  }

  public Collection<CreditCard> getCreditCards() {
    return creditCards;
  }
}
