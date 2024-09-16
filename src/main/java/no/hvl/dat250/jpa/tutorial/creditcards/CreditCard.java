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

  @OneToOne
  private Pincode pincode;

  @ManyToOne
  private Bank owningBank;

  @ManyToOne
  private Customer owner;

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
}
