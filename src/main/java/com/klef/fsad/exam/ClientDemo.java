package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class ClientDemo {

    static SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    // I. Insert records using a persistent object
    public static void insertRestaurants() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Restaurant r1 = new Restaurant("Spice Garden", LocalDate.of(2015, 3, 10), "Active", "Indian", "Hyderabad", "9876543210");
        Restaurant r2 = new Restaurant("The Italian House", LocalDate.of(2018, 7, 22), "Active", "Italian", "Bangalore", "9123456780");
        Restaurant r3 = new Restaurant("Dragon Wok", LocalDate.of(2020, 1, 5), "Inactive", "Chinese", "Chennai", "9988776655");

        session.save(r1);
        session.save(r2);
        session.save(r3);

        tx.commit();
        session.close();

        System.out.println("Records inserted successfully.");
        System.out.println("Inserted: " + r1);
        System.out.println("Inserted: " + r2);
        System.out.println("Inserted: " + r3);
    }

    // II. Update Name and Status by ID using HQL with named parameters
    public static void updateRestaurant(int id, String newName, String newStatus) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        String hql = "UPDATE Restaurant r SET r.name = :newName, r.status = :newStatus WHERE r.id = :rid";
        Query query = session.createQuery(hql);
        query.setParameter("newName", newName);
        query.setParameter("newStatus", newStatus);
        query.setParameter("rid", id);

        int rowsUpdated = query.executeUpdate();
        tx.commit();
        session.close();

        System.out.println(rowsUpdated + " record(s) updated for ID: " + id);
    }

    // Display all restaurants using HQL SELECT
    public static void displayAll() {
        Session session = factory.openSession();

        Query<Restaurant> query = session.createQuery("FROM Restaurant", Restaurant.class);
        List<Restaurant> list = query.list();

        System.out.println("\n--- All Restaurants ---");
        for (Restaurant r : list) {
            System.out.println(r);
        }

        session.close();
    }

    public static void main(String[] args) {
        // I. Insert records
        System.out.println("=== Inserting Records ===");
        insertRestaurants();

        // Display after insert
        displayAll();

        // II. Update Name and Status using HQL named parameters
        System.out.println("\n=== Updating Record with ID=1 ===");
        updateRestaurant(1, "Spice Paradise", "Inactive");

        // Display after update
        displayAll();

        factory.close();
    }
}
