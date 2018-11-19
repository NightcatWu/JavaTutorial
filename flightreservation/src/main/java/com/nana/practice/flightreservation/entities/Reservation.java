package com.nana.practice.flightreservation.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "res_reservation")
public class Reservation extends AbstractEntity{

    private boolean checkIn;
    private int numberOfBags;
    private Passenger passenger;
    private Flight flight;

    public boolean isCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public void setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
