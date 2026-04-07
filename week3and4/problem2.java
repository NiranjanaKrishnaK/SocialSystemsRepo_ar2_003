import java.util.*;

class Client {
    String id;
    int riskScore;
    double accountBalance;

    Client(String id, int riskScore, double accountBalance) {
        this.id = id;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return id + ": risk=" + riskScore + ", balance=" + accountBalance;
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of clients: ");
        int n = sc.nextInt();
        Client[] clients = new Client[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter clientId, riskScore, accountBalance (e.g. clientA 20 1000.0): ");
            String id = sc.next();
            int risk = sc.nextInt();
            double balance = sc.nextDouble();
            clients[i] = new Client(id, risk, balance);
        }

        // Bubble Sort ascending by riskScore
        bubbleSort(clients.clone());

        // Insertion Sort descending by riskScore, then accountBalance
        insertionSort(clients.clone());

        // Identify top 10 highest risk clients
        System.out.println("Top 10 highest risk clients:");
        insertionSort(clients); // ensure sorted DESC
        for (int i = 0; i < Math.min(10, n); i++) {
            System.out.println(clients[i]);
        }
    }

    // Bubble Sort ascending riskScore
    static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }
        System.out.println("BubbleSort (asc riskScore):");
        for (Client c : arr) {
            System.out.println(c);
        }
        System.out.println("// Swaps: " + swaps);
    }

    // Insertion Sort descending riskScore, then accountBalance
    static void insertionSort(Client[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Client key = arr[i];
            int j = i - 1;
            while (j >= 0 && (arr[j].riskScore < key.riskScore ||
                    (arr[j].riskScore == key.riskScore && arr[j].accountBalance < key.accountBalance))) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println("InsertionSort (desc riskScore + balance):");
        for (Client c : arr) {
            System.out.println(c);
        }
    }
}