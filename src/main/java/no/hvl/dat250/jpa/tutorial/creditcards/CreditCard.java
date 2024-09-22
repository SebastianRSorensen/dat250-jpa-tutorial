package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

@Entity
public class CreditCard {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer number;
  private Integer balance;
  private Integer creditLimit;

  @ManyToOne(cascade = CascadeType.ALL)
  private Pincode pincode;

  @ManyToOne
  private Bank owningBank;

  @ManyToOne
  private Customer owner;

  public CreditCard() {}

  public CreditCard(
    Integer number,
    Integer balance,
    Integer creditLimit,
    Pincode pincode,
    Bank owningBank,
    Customer owner
  ) {
    this.number = number;
    this.balance = balance;
    this.creditLimit = creditLimit;
    this.pincode = pincode;
    this.owningBank = owningBank;
    this.owner = owner;

    if (owningBank != null) {
      owningBank.addOwnedCard(this);
    }

    if (owner != null) {
      owner.addCreditCard(this);
    }
  }

  public Long getId() {
    return id;
  }

  public Integer getNumber() {
    return number;
  }

  public Integer getBalance() {
    return balance;
  }

  public Integer getCreditLimit() {
    return creditLimit;
  }

  public Pincode getPincode() {
    return pincode;
  }

  public Bank getOwningBank() {
    return owningBank;
  }

  public Customer getOwner() {
    return owner;
  }

  void setOwningBank(Bank owningBank) {
    this.owningBank = owningBank;
  }

  void setOwner(Customer owner) {
    this.owner = owner;
  }
}
