package com.socialsystems.problem5;

import java.util.*;

public class AnalyticsDashboard {
    private List<Integer> data = new ArrayList<>();

    public void addData(int value) {
        data.add(value);
    }

    public double average() {
        return data.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AnalyticsDashboard dashboard = new AnalyticsDashboard();

        System.out.print("Enter number of data points: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value: ");
            dashboard.addData(sc.nextInt());
        }

        System.out.println("Average: " + dashboard.average());
    }
}