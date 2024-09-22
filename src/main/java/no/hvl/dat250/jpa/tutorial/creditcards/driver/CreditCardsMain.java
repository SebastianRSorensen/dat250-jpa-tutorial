package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.Address;
import no.hvl.dat250.jpa.tutorial.creditcards.Bank;
import no.hvl.dat250.jpa.tutorial.creditcards.CreditCard;
import no.hvl.dat250.jpa.tutorial.creditcards.Customer;
import no.hvl.dat250.jpa.tutorial.creditcards.Pincode;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (
      EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME
      );
      EntityManager em = factory.createEntityManager()
    ) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }
  }

  private static void createObjects(EntityManager em) {
    Pincode pincode = new Pincode("123", 1);
    Bank bank = new Bank("Pengebank");
    Customer customer = new Customer("Max Mustermann");
    Address address = new Address("Inndalsveien", 28);

    // Associate Address with Customer using the addAddress method
    customer.addAddress(address);

    // Create Credit Cards using constructor that sets relationships
    new CreditCard(12345, -5000, -10000, pincode, bank, customer);
    new CreditCard(123, 1, 2000, pincode, bank, customer);

    // Persist entities
    em.persist(customer); // Cascades to addresses and creditCards
    em.persist(bank); // Cascades to ownedCards and their pincode
  }
}
