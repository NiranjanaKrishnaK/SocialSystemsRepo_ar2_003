import java.util.*;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of transaction logs: ");
        int n = sc.nextInt();
        String[] logs = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter accountId: ");
            logs[i] = sc.next();
        }

        System.out.print("Enter target accountId to search: ");
        String target = sc.next();

        // Linear Search
        linearSearch(logs, target);

        // Sort logs for Binary Search
        Arrays.sort(logs);
        System.out.println("Sorted logs: " + Arrays.toString(logs));

        // Binary Search
        binarySearch(logs, target);
    }

    // Linear Search for first and last occurrence
    static void linearSearch(String[] arr, String target) {
        int first = -1, last = -1, comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                if (first == -1) first = i;
                last = i;
            }
        }
        System.out.println("Linear Search:");
        if (first != -1) {
            System.out.println("First occurrence of " + target + " at index " + first);
            System.out.println("Last occurrence of " + target + " at index " + last);
        } else {
            System.out.println(target + " not found");
        }
        System.out.println("Comparisons: " + comparisons);
    }

    // Binary Search for exact match + count occurrences
    static void binarySearch(String[] arr, String target) {
        int comparisons = 0;
        int low = 0, high = arr.length - 1;
        int foundIndex = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;
            if (arr[mid].equals(target)) {
                foundIndex = mid;
                break;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Binary Search:");
        if (foundIndex != -1) {
            System.out.println("Found " + target + " at index " + foundIndex);
            // Count occurrences
            int count = 1;
            int left = foundIndex - 1;
            while (left >= 0 && arr[left].equals(target)) {
                count++;
                left--;
            }
            int right = foundIndex + 1;
            while (right < arr.length && arr[right].equals(target)) {
                count++;
                right++;
            }
            System.out.println("Occurrences: " + count);
        } else {
            System.out.println(target + " not found");
        }
        System.out.println("Comparisons: " + comparisons);
    }
}