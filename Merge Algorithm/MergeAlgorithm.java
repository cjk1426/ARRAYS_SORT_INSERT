// GitHub Repository: Add this code to your repository if required.

public class MergeAlgorithm {
    /**
     * Merges two sorted arrays into a single sorted array.
     *
     * @param array1 The first sorted array.
     * @param array2 The second sorted array.
     * @return A new array containing all elements from array1 and array2 in sorted order.
     */
    public static int[] mergeSortedArrays(int[] array1, int[] array2) {
        // Create a new array to hold the merged result.
        int[] mergedArray = new int[array1.length + array2.length];
        
        // Initialize pointers for both input arrays and the result array.
        int i = 0, j = 0, k = 0;

        // Compare elements from both arrays and add the smaller one to the merged array.
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                mergedArray[k] = array1[i];
                i++; // Move the pointer in the first array forward.
            } else {
                mergedArray[k] = array2[j];
                j++; // Move the pointer in the second array forward.
            }
            k++; // Move the pointer in the merged array forward.
        }

        // Add any remaining elements from the first array (if any).
        while (i < array1.length) {
            mergedArray[k] = array1[i];
            i++;
            k++;
        }

        // Add any remaining elements from the second array (if any).
        while (j < array2.length) {
            mergedArray[k] = array2[j];
            j++;
            k++;
        }

        // Return the merged sorted array.
        return mergedArray;
    }

    public static void main(String[] args) {
        // Example input arrays (sorted).
        int[] array1 = {1, 3, 5, 7};
        int[] array2 = {2, 4, 6, 8};

        // Merge the arrays.
        int[] mergedArray = mergeSortedArrays(array1, array2);

        // Print the result.
        System.out.print("Merged Array: ");
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
    }
}
