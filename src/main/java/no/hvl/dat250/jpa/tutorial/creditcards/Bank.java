package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bank {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(
    mappedBy = "owningBank",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private Set<CreditCard> ownedCards = new HashSet<>();

  public Bank() {}

  public Bank(String name) {
    this.name = name;
  }

  public Bank(String name, Set<CreditCard> ownedCards) {
    this.name = name;
    this.ownedCards = ownedCards;
    for (CreditCard card : ownedCards) {
      card.setOwningBank(this);
    }
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Set<CreditCard> getOwnedCards() {
    return ownedCards;
  }

  void addOwnedCard(CreditCard card) {
    if (card != null && !ownedCards.contains(card)) {
      ownedCards.add(card);
      if (card.getOwningBank() != this) {
        card.setOwningBank(this);
      }
    }
  }
}
