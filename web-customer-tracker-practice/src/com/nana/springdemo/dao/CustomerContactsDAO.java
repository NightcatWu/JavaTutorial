package com.nana.springdemo.dao;

import com.nana.springdemo.entity.Customer;
import com.nana.springdemo.entity.CustomerContacts;

import java.util.List;

public interface CustomerContactsDAO {

    public List<CustomerContacts> listCustomerContacts(int customerId);

    public void saveCustomerContacts(Customer theCustomer);
}
