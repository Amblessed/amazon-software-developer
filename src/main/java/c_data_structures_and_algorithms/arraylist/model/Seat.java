package data_structures_and_algorithms.arraylist.model;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 07-Oct-24
 */


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Seat {
    private String seatNumber;
    private boolean isBooked;
    private LocalDate bookingDate;
    private boolean isCanceled;


    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
        this.isCanceled = false;
    }


    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber='" + seatNumber + '\'' +
                ", isBooked=" + isBooked +
                ", bookingDate=" + bookingDate +
                ", isCanceled=" + isCanceled +
                '}';
    }
}
