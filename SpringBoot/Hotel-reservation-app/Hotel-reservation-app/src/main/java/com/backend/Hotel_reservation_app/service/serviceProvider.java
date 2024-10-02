package com.backend.Hotel_reservation_app.service;

import com.backend.Hotel_reservation_app.entity.customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface serviceProvider {
    //    get all ids
    List<customer> findAll();
    //    get By a single id
    public customer findCustomer(int ID);
    //    Save an Employee
    customer save(customer theCustomer);

    //    Delete an employee
    public void deleteCustomer(int id);


}
