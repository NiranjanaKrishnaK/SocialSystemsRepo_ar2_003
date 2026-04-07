import java.util.*;

class Trade {
    String id;
    int volume;

    Trade(String id, int volume) {
        this.id = id;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return id + ": " + volume;
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of trades: ");
        int n = sc.nextInt();
        Trade[] trades = new Trade[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter tradeId and volume (e.g. trade1 100): ");
            String id = sc.next();
            int vol = sc.nextInt();
            trades[i] = new Trade(id, vol);
        }

        // Merge Sort ascending
        Trade[] mergeSorted = trades.clone();
        mergeSort(mergeSorted, 0, n - 1);
        System.out.println("MergeSort (ascending volume):");
        for (Trade t : mergeSorted) {
            System.out.println(t);
        }

        // Quick Sort descending
        Trade[] quickSorted = trades.clone();
        quickSort(quickSorted, 0, n - 1);
        System.out.println("QuickSort (descending volume):");
        for (Trade t : quickSorted) {
            System.out.println(t);
        }

        // Merge two lists (simulate morning + afternoon sessions)
        System.out.print("Enter number of morning trades: ");
        int m = sc.nextInt();
        Trade[] morning = new Trade[m];
        for (int i = 0; i < m; i++) {
            System.out.print("Enter tradeId and volume: ");
            String id = sc.next();
            int vol = sc.nextInt();
            morning[i] = new Trade(id, vol);
        }

        System.out.print("Enter number of afternoon trades: ");
        int a = sc.nextInt();
        Trade[] afternoon = new Trade[a];
        for (int i = 0; i < a; i++) {
            System.out.print("Enter tradeId and volume: ");
            String id = sc.next();
            int vol = sc.nextInt();
            afternoon[i] = new Trade(id, vol);
        }

        Trade[] merged = mergeTwoLists(morning, afternoon);
        int totalVolume = 0;
        for (Trade t : merged) {
            totalVolume += t.volume;
        }
        System.out.println("Merged morning+afternoon trades:");
        for (Trade t : merged) {
            System.out.println(t);
        }
        System.out.println("Total volume: " + totalVolume);
    }

    // Merge Sort
    static void mergeSort(Trade[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(Trade[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Trade[] L = new Trade[n1];
        Trade[] R = new Trade[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].volume <= R[j].volume) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Quick Sort (descending)
    static void quickSort(Trade[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(Trade[] arr, int low, int high) {
        int pivot = arr[high].volume;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].volume >= pivot) { // descending
                i++;
                Trade temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Trade temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Merge two sorted lists
    static Trade[] mergeTwoLists(Trade[] morning, Trade[] afternoon) {
        Trade[] merged = new Trade[morning.length + afternoon.length];
        int i = 0, j = 0, k = 0;
        while (i < morning.length && j < afternoon.length) {
            if (morning[i].volume <= afternoon[j].volume) {
                merged[k++] = morning[i++];
            } else {
                merged[k++] = afternoon[j++];
            }
        }
        while (i < morning.length) merged[k++] = morning[i++];
        while (j < afternoon.length) merged[k++] = afternoon[j++];
        return merged;
    }
}