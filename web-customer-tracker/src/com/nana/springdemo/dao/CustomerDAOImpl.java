package com.nana.springdemo.dao;

import com.nana.springdemo.entity.Customer;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    // @Transactional -- move to Servie layer
    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

//        // create query
//        Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
//
//        // get result list by executing query
//        List<Customer> customers = theQuery.getResultList();

        // SQL query
        String sql = "select * from customer order by last_name";
        Query<Customer> query = currentSession.createNativeQuery(sql, Customer.class);
        List<Customer> customers = (List<Customer>)query.getResultList();

        // return list of customers
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save customer to db
        //currentSession.save(theCustomer);
        // saveOrUpdate will do save or update based on primary key / id, if primary key is empty will execute save, otherwise will update
        currentSession.saveOrUpdate(theCustomer);

    }

    @Override
    public Customer getCustomer(int id) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // retrieve from databsae using the prilmary key
        Customer theCustomer = currentSession.get(Customer.class, id);

        //
        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete customer
        String sql = "delete from customer where id=:customerId";
        Query query = currentSession.createNativeQuery(sql, Customer.class);
        query.setParameter("customerId", theId);

        query.executeUpdate();

    }
}
