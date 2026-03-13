package com.socialsystems.problem8;

import java.util.Scanner;

public class ParkingLot {
    private int capacity;
    private int occupied;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.occupied = 0;
    }

    public boolean parkCar() {
        if (occupied < capacity) {
            occupied++;
            return true;
        }
        return false;
    }

    public boolean leaveCar() {
        if (occupied > 0) {
            occupied--;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter parking lot capacity: ");
        int cap = sc.nextInt();

        ParkingLot lot = new ParkingLot(cap);
        System.out.println("Car parked? " + lot.parkCar());
        System.out.println("Car left? " + lot.leaveCar());
    }
}