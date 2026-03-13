package com.socialsystems.problem3;

import java.util.*;

public class DNSCache {
    private Map<String, String> cache = new HashMap<>();

    public void addRecord(String domain, String ip) {
        cache.put(domain, ip);
    }

    public String resolve(String domain) {
        return cache.getOrDefault(domain, "Not Found");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DNSCache dns = new DNSCache();

        System.out.print("Enter domain: ");
        String domain = sc.nextLine();
        System.out.print("Enter IP: ");
        String ip = sc.nextLine();
        dns.addRecord(domain, ip);

        System.out.print("Enter domain to resolve: ");
        String query = sc.nextLine();
        System.out.println("Resolved IP: " + dns.resolve(query));
    }
}