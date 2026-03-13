package com.socialsystems.problem7;

import java.util.*;

public class AutocompleteSystem {
    private List<String> dictionary = new ArrayList<>();

    public void addWord(String word) {
        dictionary.add(word);
    }

    public List<String> suggest(String prefix) {
        List<String> results = new ArrayList<>();
        for (String word : dictionary) {
            if (word.startsWith(prefix)) {
                results.add(word);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AutocompleteSystem system = new AutocompleteSystem();

        System.out.print("Enter number of words: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter word: ");
            system.addWord(sc.nextLine());
        }

        System.out.print("Enter prefix: ");
        String prefix = sc.nextLine();
        System.out.println("Suggestions: " + system.suggest(prefix));
    }
}