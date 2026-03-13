package com.socialsystems.problem10;

import java.util.*;

public class MultiLevelCache {
    private Map<String, String> level1 = new HashMap<>();
    private Map<String, String> level2 = new HashMap<>();

    public void put(String key, String value) {
        // Always put into level1
        level1.put(key, value);
    }

    public String get(String key) {
        // First check level1, then level2
        if (level1.containsKey(key)) {
            return level1.get(key);
        } else if (level2.containsKey(key)) {
            // Promote to level1 when found in level2
            String value = level2.get(key);
            level1.put(key, value);
            return value;
        }
        return "Not Found";
    }

    public void moveToLevel2(String key) {
        if (level1.containsKey(key)) {
            level2.put(key, level1.remove(key));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MultiLevelCache cache = new MultiLevelCache();

        while (true) {
            System.out.println("\n--- MultiLevel Cache Menu ---");
            System.out.println("1. Put key-value");
            System.out.println("2. Get value by key");
            System.out.println("3. Move key from Level1 to Level2");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    String key = sc.nextLine();
                    System.out.print("Enter value: ");
                    String value = sc.nextLine();
                    cache.put(key, value);
                    System.out.println("Stored in Level1.");
                    break;
                case 2:
                    System.out.print("Enter key to fetch: ");
                    String fetchKey = sc.nextLine();
                    System.out.println("Value: " + cache.get(fetchKey));
                    break;
                case 3:
                    System.out.print("Enter key to move: ");
                    String moveKey = sc.nextLine();
                    cache.moveToLevel2(moveKey);
                    System.out.println("Moved to Level2 if existed.");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}