import java.util.*;

class Transaction {
    String id;
    double fee;
    String timestamp;

    Transaction(String id, double fee, String ts) {
        this.id = id;
        this.fee = fee;
        this.timestamp = ts;
    }

    @Override
    public String toString() {
        return id + ": " + fee + "@" + timestamp;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Transaction> transactions = new ArrayList<>();

        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter id, fee, timestamp (e.g. id1 10.5 10:00): ");
            String id = sc.next();
            double fee = sc.nextDouble();
            String ts = sc.next();
            transactions.add(new Transaction(id, fee, ts));
        }

        if (n <= 100) {
            bubbleSort(transactions);
            System.out.println("BubbleSort (fees ascending):");
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        } else if (n <= 1000) {
            insertionSort(transactions);
            System.out.println("InsertionSort (fee + timestamp ascending):");
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }

        // Flag high-fee outliers
        System.out.println("High-fee outliers (> $50):");
        boolean found = false;
        for (Transaction t : transactions) {
            if (t.fee > 50) {
                System.out.println(t);
                found = true;
            }
        }
        if (!found) {
            System.out.println("None");
        }
    }

    // Bubble Sort by fee
    static void bubbleSort(List<Transaction> list) {
        int n = list.size();
        boolean swapped;
        int passes = 0, swaps = 0;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            passes++;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Collections.swap(list, j, j + 1);
                    swapped = true;
                    swaps++;
                }
            }
            if (!swapped) break;
        }
        System.out.println("// Passes: " + passes + ", Swaps: " + swaps);
    }

    // Insertion Sort by fee, then timestamp
    static void insertionSort(List<Transaction> list) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            Transaction key = list.get(i);
            int j = i - 1;
            while (j >= 0 && (list.get(j).fee > key.fee ||
                    (list.get(j).fee == key.fee && list.get(j).timestamp.compareTo(key.timestamp) > 0))) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }
}