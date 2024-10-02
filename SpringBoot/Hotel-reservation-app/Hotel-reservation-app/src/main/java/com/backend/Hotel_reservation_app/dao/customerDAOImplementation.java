package com.backend.Hotel_reservation_app.dao;

import com.backend.Hotel_reservation_app.entity.customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;
@Repository
public class customerDAOImplementation implements  customerDAO{

    private EntityManager entityManager;
    @Autowired
    public customerDAOImplementation(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }
    @Override
    public List<customer> findAll() {
        TypedQuery<customer> theQuery = entityManager.createQuery("from customer", customer.class);
        List<customer> customers = theQuery.getResultList();
        return customers;
    }

    @Override
    public customer findCustomer(int ID) {
        customer onecustomer = entityManager.find(customer.class,ID);
        return onecustomer;
    }

    @Override
    public customer save(customer theCustomer) {
        customer thecustomer = entityManager.merge(theCustomer);
        System.out.println("customer added");
        return theCustomer;
    }

    @Override
    public void deleteCustomer(int id)
    {
            customer customer1 = entityManager.find(customer.class,id);
            entityManager.remove(customer1);
    }
}
