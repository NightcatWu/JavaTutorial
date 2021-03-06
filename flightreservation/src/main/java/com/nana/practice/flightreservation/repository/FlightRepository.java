package com.nana.practice.flightreservation.repository;

import com.nana.practice.flightreservation.entities.Flight;
import com.nana.practice.flightreservation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query(value = "from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
    List<Flight> findFlight(@Param("departureCity") String from, @Param("arrivalCity")String to, @Param("dateOfDeparture") Date departureDate);

}

