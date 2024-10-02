package com.backend.Hotel_reservation_app.dao;

import com.backend.Hotel_reservation_app.entity.customer;

import java.util.List;

public interface customerDAO {
    //    get all ids
    List<customer> findAll();
    //    get By a single id
    public customer findCustomer(int ID);
    //    Save an Employee
    customer save(customer theCustomer);

    //    Delete an employee
    public void deleteCustomer(int id);
}
