package com.nana.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addAccount() {

        System.out.println(getClass() + ": Doing stuff: Adding a membership account");

        return true;
    }

    public void goToSleep() {

        System.out.println(getClass() + ": Going to sleep");

    }

}
