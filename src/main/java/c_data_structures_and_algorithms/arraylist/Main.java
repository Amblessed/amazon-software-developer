package c_data_structures_and_algorithms.arraylist;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 07-Oct-24
 */


import c_data_structures_and_algorithms.arraylist.controller.SeatBooking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Take input using Scanner class
        Scanner keyboard = new Scanner(System.in);
        // Create an object of SeatBooking class
        SeatBooking bookingManager = new SeatBooking();

        while (true) {
            System.out.println("\n1. Add Booking\n2. Cancel Booking\n3. Update Booking\n4. Display Bookings\n5. Exit");
            System.out.print("Choose an option: ");
            // Choose an option
            int choice = -1;
            try {
                choice = keyboard.nextInt();
                keyboard.nextLine(); // Consume newline character
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                keyboard.nextLine(); // Clear invalid input
                continue; // Skip the rest of the loop iteration
            }

            switch (choice) {
                case 1 -> {
                    // 16: add New Seats
                    // use a print statement to instruct the user to enter a seat number for booking.
                    // take the seat number input from the user.
                    // pass the seat number to the addNewBooking method to add the
                    System.out.print("Enter a seat number for booking: ");
                    try {
                        String seatNumber = keyboard.nextLine();
                        bookingManager.addNewBooking(seatNumber);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        keyboard.nextLine(); // Clear invalid input
                    }

                }

                case 2 -> {
                    // 17: remove Booking
                    // print a message instructing the user to enter the seat number they wish to cancel.
                    // take the seat number input from the user.
                    // call the cancelBooking method with the provided seat number to cancel the booking.
                    System.out.print("Enter a seat number for cancellation: ");
                    try {
                        String seatNumber = keyboard.nextLine();
                        bookingManager.cancelBooking(seatNumber);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        keyboard.nextLine(); // Clear invalid input
                    }

                }

                case 3 -> {
                    // 18: update booking
                    // prompt users to enter the old seat number they want to update.
                    // take the old seat number input from the user.
                    // prompt the user to enter the new seat number.
                    // take the new seat number input from the user.
                    // call the updateBooking method with the old and new seat numbers to update the booking.
                    try {
                        System.out.println("Enter the old seat number to update: ");
                        String oldSeatNumber = keyboard.nextLine();
                        System.out.println("Enter the new seat number: ");
                        String newSeatNumber = keyboard.nextLine();
                        bookingManager.updateBooking(oldSeatNumber, newSeatNumber);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        keyboard.nextLine(); // Clear invalid input
                    }
                }

                case 4 -> // display the all bookings
                    // check if the bookedSeatsList is empty, inform the user that no bookings have been made yet
                    // iterate through the list of booked seats, Check if the seat is booked and not cancelled
                    // display the seat number and booking date
                    bookingManager.displayBookings();
                case 5 ->{
                    System.out.println("Exiting program.");
                    keyboard.close();
                    return;
                }
                default ->   System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
