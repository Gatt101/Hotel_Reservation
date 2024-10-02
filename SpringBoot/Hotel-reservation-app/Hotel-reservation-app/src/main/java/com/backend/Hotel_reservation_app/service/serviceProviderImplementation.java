package com.backend.Hotel_reservation_app.service;

import com.backend.Hotel_reservation_app.dao.customerDAO;
import com.backend.Hotel_reservation_app.entity.customer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class serviceProviderImplementation implements serviceProvider{

    private customerDAO CustomerDao;

    @Autowired
    public serviceProviderImplementation(customerDAO CustomerDao)
    {
        this.CustomerDao=CustomerDao;
    }
    @Override
    public List<customer> findAll()
    {
        return CustomerDao.findAll();
    }

    @Override
    public customer findCustomer(int ID)
    {
        return CustomerDao.findCustomer(ID);
    }
    @Transactional
    @Override
    public customer save(customer theCustomer)
    {
       return  CustomerDao.save(theCustomer);
    }

    @Transactional
    @Override
    public void deleteCustomer(int id)
    {
        CustomerDao.deleteCustomer(id);
    }
}
