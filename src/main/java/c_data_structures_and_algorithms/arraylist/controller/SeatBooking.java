package c_data_structures_and_algorithms.arraylist.controller;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 07-Oct-24
 */


import c_data_structures_and_algorithms.arraylist.model.Seat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SeatBooking {
    // List to store bookings
    private List<Seat> bookedSeatsList;
    // Constructor
    public SeatBooking() {
        // Initialize the list of booked seats
        // 1 : this.bookedSeatsList = ?
        this.bookedSeatsList = new ArrayList<>();
    }
    // Method to add a new seat booking
    public void addNewBooking(String seatNumber) {
        // 2: check if the seat is already booked and not canceled
        for (Seat seat : bookedSeatsList) {
            if (seat.getSeatNumber().equals(seatNumber) && seat.isBooked() && !seat.isCanceled()){
                    System.out.println("Cannot book seat: " + seat.getSeatNumber());
                }
        }

        // 3 create a new Seat object for the booking,
        // mark the seat as booked,
        // set the current date as the booking date
        Seat seatToAdd = new Seat(seatNumber);
        seatToAdd.setBooked(true);
        seatToAdd.setBookingDate(LocalDate.now());
        // 4: add the new seat to the bookedSeatsList
        bookedSeatsList.add(seatToAdd);
        // 5: confirm the booking to the user
        System.out.println("Seat: " + seatNumber + " has been successfully added!");
    }
    // Method to cancel a booking
    public void cancelBooking(String seatNumber) {
        // 6: iterate through the list of booked seats
        // 7: check if the seat number matches and is not already canceled
        // mark the seat as canceled
        // mark the seat as not booked
        // confirm the cancellation to the user
        // 8: inform the user if no booking was found for the seat number
        for (Seat seat : bookedSeatsList) {
            if (seat.getSeatNumber().equals(seatNumber) && seat.isBooked() && !seat.isCanceled()){
                seat.setCanceled(true);
                seat.setBooked(false);
                System.out.println("Canceled seat: " + seat.getSeatNumber());
                break;
            }
        }
        System.out.println("No booking found for seat: " + seatNumber);

    }
    // Method to update a booking seat number
    public void updateBooking(String oldSeatNumber, String newSeatNumber) {
        // 9: iterate through the list of booked seats
        // 10: check if the seat number matches the old seat number and is not canceled
        // 11: update the seat number to the new seat number
        // confirm the update to the user
        // 12: inform the user if no booking was found for the old seat number
        for (Seat seat : bookedSeatsList) {
            if (seat.getSeatNumber().equals(oldSeatNumber) && seat.isBooked() && !seat.isCanceled()){
                seat.setSeatNumber(newSeatNumber);
                System.out.println("Seat " + oldSeatNumber + " has been updated to " + newSeatNumber + "!");
                break;
            }
        }
        System.out.println("No booking found for seat: " + oldSeatNumber);
    }
    // Method to display all bookings
    public void displayBookings() {
        // 13: check if the bookedSeatsList is empty, inform the user that no bookings have been made yet
        if(bookedSeatsList.isEmpty()){
            System.out.println("No bookings made yet.");
            return;
        }
        // 14: iterate through the list of booked seats, Check if the seat is booked and not canceled
        for (Seat seat : bookedSeatsList) {
            if (seat.isBooked() && !seat.isCanceled()) {
                System.out.println("Seat: " + seat.getSeatNumber() + ", Booking Date: " + seat.getBookingDate());
            }
        }
        // 15: display the seat number and booking date

    }
}
