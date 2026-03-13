package com.socialsystems.problem2;

import java.util.*;

public class InventoryManager {
    private Map<String, Integer> inventory = new HashMap<>();

    public void addItem(String item, int quantity) {
        inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
    }

    public boolean purchaseItem(String item, int quantity) {
        int current = inventory.getOrDefault(item, 0);
        if (current >= quantity) {
            inventory.put(item, current - quantity);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();

        System.out.print("Enter item name: ");
        String item = sc.nextLine();
        System.out.print("Enter quantity to add: ");
        int qty = sc.nextInt();
        manager.addItem(item, qty);

        System.out.print("Enter quantity to purchase: ");
        int buyQty = sc.nextInt();
        System.out.println("Purchase successful? " + manager.purchaseItem(item, buyQty));
    }
}