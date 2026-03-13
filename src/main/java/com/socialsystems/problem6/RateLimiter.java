package com.socialsystems.problem6;

import java.util.Scanner;

public class RateLimiter {
    private int limit;
    private int count;

    public RateLimiter(int limit) {
        this.limit = limit;
        this.count = 0;
    }

    public boolean allowRequest() {
        if (count < limit) {
            count++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter request limit: ");
        int limit = sc.nextInt();

        RateLimiter limiter = new RateLimiter(limit);
        for (int i = 0; i < limit + 2; i++) {
            System.out.println("Request " + (i+1) + ": " + limiter.allowRequest());
        }
    }
}