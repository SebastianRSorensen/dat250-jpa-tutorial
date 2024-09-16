package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String street;
  private Integer number;

  @ManyToMany(mappedBy = "addresses")
  private Collection<Customer> owners;

  public String getStreet() {
    return street;
  }

  public Integer getNumber() {
    return number;
  }

  public Collection<Customer> getOwners() {
    return owners;
  }
}
