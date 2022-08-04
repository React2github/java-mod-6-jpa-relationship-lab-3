package org.example;

import org.example.Models.Cats;
import org.example.Models.Owners;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Main {
    public static void main(String[] args) {
        // create EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Cats
        Cats cat1 = new Cats();
        Cats cat2 = new Cats();
        Cats cat3 = new Cats();

        cat1.setName("Tabby");
        cat1.setAge(2);
        cat1.setBreed("Mixed");

        cat2.setName("Sabby");
        cat2.setAge(2);
        cat2.setBreed("Mixed");

        cat3.setName("Wabby");
        cat3.setAge(2);
        cat3.setBreed("Mixed");

        // Owners

        Owners owner1 = new Owners();
        Owners owner2 = new Owners();

        owner1.setName("Max");
        owner2.setName("Will");

        // Association of cat to owner

        cat1.addOwner(owner1);
        owner1.addCat(cat1);
        cat1.addOwner(owner2);
        owner2.addCat(cat1);

        cat2.addOwner(owner1);
        owner1.addCat(cat2);
        cat2.addOwner(owner2);
        owner2.addCat(cat2);

        cat3.addOwner(owner1);
        owner1.addCat(cat3);
        cat3.addOwner(owner2);
        owner2.addCat(cat3);

        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(cat1);
        entityManager.persist(cat2);
        entityManager.persist(cat3);
        entityManager.persist(owner1);
        entityManager.persist(owner2);
        transaction.commit();
        // close entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}