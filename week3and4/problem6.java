import java.util.*;

public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of risk bands: ");
        int n = sc.nextInt();
        int[] risks = new int[n];

        System.out.println("Enter risk band values:");
        for (int i = 0; i < n; i++) {
            risks[i] = sc.nextInt();
        }

        System.out.print("Enter threshold to search: ");
        int target = sc.nextInt();

        // Linear Search (unsorted)
        linearSearch(risks, target);

        // Sort array for Binary Search
        Arrays.sort(risks);
        System.out.println("Sorted risks: " + Arrays.toString(risks));

        // Binary Search floor/ceiling
        binarySearchFloorCeiling(risks, target);
    }

    // Linear Search
    static void linearSearch(int[] arr, int target) {
        int comparisons = 0;
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear Search: Found threshold " + target + " at index " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Linear Search: Threshold " + target + " not found");
        }
        System.out.println("Comparisons: " + comparisons);
    }

    // Binary Search floor and ceiling
    static void binarySearchFloorCeiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;
        int floor = Integer.MIN_VALUE, ceiling = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;
            if (arr[mid] == target) {
                floor = arr[mid];
                ceiling = arr[mid];
                break;
            } else if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceiling = arr[mid];
                high = mid - 1;
            }
        }

        System.out.println("Binary Search:");
        if (floor != Integer.MIN_VALUE) {
            System.out.println("Floor (largest ≤ " + target + "): " + floor);
        } else {
            System.out.println("Floor not found");
        }
        if (ceiling != Integer.MAX_VALUE) {
            System.out.println("Ceiling (smallest ≥ " + target + "): " + ceiling);
        } else {
            System.out.println("Ceiling not found");
        }
        System.out.println("Comparisons: " + comparisons);
    }
}