package com.socialsystems.problem4;

import java.util.Scanner;

public class PlagiarismDetector {
    public double similarity(String text1, String text2) {
        return text1.equalsIgnoreCase(text2) ? 1.0 : 0.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first text: ");
        String t1 = sc.nextLine();
        System.out.print("Enter second text: ");
        String t2 = sc.nextLine();

        PlagiarismDetector detector = new PlagiarismDetector();
        System.out.println("Similarity score: " + detector.similarity(t1, t2));
    }
}