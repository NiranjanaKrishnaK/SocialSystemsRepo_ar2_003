package com.socialsystems.problem9;

import java.util.*;

public class TransactionAnalyzer {
    public int countTransactionsAbove(List<Integer> transactions, int threshold) {
        int count = 0;
        for (int t : transactions) {
            if (t > threshold) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> transactions = new ArrayList<>();

        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter transaction amount: ");
            transactions.add(sc.nextInt());
        }

        System.out.print("Enter threshold: ");
        int threshold = sc.nextInt();

        TransactionAnalyzer analyzer = new TransactionAnalyzer();
        System.out.println("Count above threshold: " + analyzer.countTransactionsAbove(transactions, threshold));
    }
}
