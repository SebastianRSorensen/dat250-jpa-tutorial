package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ManyToMany(cascade = CascadeType.ALL)
  private Set<Address> addresses = new HashSet<>();

  @OneToMany(
    mappedBy = "owner",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private Set<CreditCard> creditCards = new HashSet<>();

  public Customer() {}

  public Customer(String name) {
    this.name = name;
  }

  public Customer(
    String name,
    Set<Address> addresses,
    Set<CreditCard> creditCards
  ) {
    this.name = name;
    if (addresses != null) {
      this.addresses = addresses;
    }
    if (creditCards != null) {
      this.creditCards = creditCards;
      for (CreditCard card : creditCards) {
        card.setOwner(this);
      }
    }
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Set<Address> getAddresses() {
    return addresses;
  }

  public Set<CreditCard> getCreditCards() {
    return creditCards;
  }

  void addCreditCard(CreditCard card) {
    if (card != null && !creditCards.contains(card)) {
      creditCards.add(card);

      if (card.getOwner() != this) {
        card.setOwner(this);
      }
    }
  }

  public void addAddress(Address address) {
    this.addresses.add(address);
    address.getOwners().add(this);
  }
}
