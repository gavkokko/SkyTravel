package com.code.ergasia.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="flights")
@EntityListeners(AuditingEntityListener.class)
public class Flights implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idflights")
    private String idflights;

    @Column(name = "from")
    @NotEmpty(message = "*Please provide departure location")
    private String from;

    @Column(name = "to")
    @NotEmpty(message = "*Please provide destination")
    private String to;

    @Column(name = "stop")
    private String stop;

    @Column(name = "seats")
    @NotEmpty(message = "*Please provide number of seats")
    private int seats;

    @Column(name = "departure")
    @NotEmpty(message = "*Please provide departure time")
    private String departure;

    @Column(name = "arrival")
    @NotEmpty(message = "*Please provide arrival time")
    private String arrival;

    @Column(name = "price")
    @NotEmpty(message = "*Please provide price of flight")
    private double price;

    @Column(name = "days")
    @Length(max = 7, message = "*Days are maximum 7!!!")
    @NotEmpty(message = "*Please provide available flight days")
    private String days;

    @Column(name = "airline")
    @NotEmpty(message = "*Please provide airline name")
    private String airline;

    @Column(name = "duration")
    @NotEmpty(message = "*Please provide flight duration")
    private String duration;

    public Flights(){

    }

    public String getIdflights() {
        return idflights;
    }

    public void setIdflights(String idflights) {
        this.idflights = idflights;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
