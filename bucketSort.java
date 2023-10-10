import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    public static void bucketSort(double[] array) {
        int n = array.length;
        
        if (n <= 0) {
            return;
        }

        // Create buckets
        ArrayList<Double>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Put array elements in different buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * array[i]);
            buckets[bucketIndex].add(array[i]);
        }

        // Sort individual buckets
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // Concatenate all the buckets back into the original array
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                array[index++] = buckets[i].get(j);
            }
        }
    }

    public static void printArray(double[] array) {
        for (double num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        double[] array = {0.42, 0.32, 0.33, 0.52, 0.37, 0.47, 0.51};
        
        System.out.println("Original array:");
        printArray(array);

        bucketSort(array);

        System.out.println("Sorted array:");
        printArray(array);
    }
}
