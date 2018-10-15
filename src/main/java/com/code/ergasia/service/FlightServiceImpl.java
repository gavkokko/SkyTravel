package com.code.ergasia.service;

import com.code.ergasia.repository.FlightRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Resource
    private FlightRepository flightRepository;


    @Transactional
    @Override
    public List findAll(){
        return flightRepository.findAll();
    }
}
