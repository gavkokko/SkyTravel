package com.code.ergasia.repository;

import com.code.ergasia.model.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("flightRepository")
public interface FlightRepository extends JpaRepository<Flights, Long>{

    public List<Flights> findByTo(String to);
}
