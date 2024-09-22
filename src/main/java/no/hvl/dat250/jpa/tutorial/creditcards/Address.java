package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String street;
  private Integer number;

  @ManyToMany(mappedBy = "addresses")
  private Set<Customer> owners = new HashSet<>();

  public Address() {}

  public Address(String street, Integer number) {
    this.street = street;
    this.number = number;
  }

  public Address(String street, Integer number, Customer owner) {
    this.street = street;
    this.number = number;
    if (owner != null) {
      this.owners.add(owner);
      owner.getAddresses().add(this);
    }
  }

  public Long getId() {
    return id;
  }

  public String getStreet() {
    return street;
  }

  public Integer getNumber() {
    return number;
  }

  public Set<Customer> getOwners() {
    return owners;
  }
}
