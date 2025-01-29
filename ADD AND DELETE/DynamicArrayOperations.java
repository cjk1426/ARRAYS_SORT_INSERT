import java.util.ArrayList;

public class DynamicArrayOperations {

    // Function to add an element to a dynamic array (ArrayList)
    public static void addElement(ArrayList<Integer> list, int element) {
        // Adds element to the ArrayList
        list.add(element);
        System.out.println("Added " + element + " to the array.");
    }

    // Function to delete an element at a specific index in the dynamic array
    public static void deleteElement(ArrayList<Integer> list, int index) {
        // Check if the index is valid
        if (index >= 0 && index < list.size()) {
            // Removes the element at the given index
            list.remove(index);
            System.out.println("Deleted element at index " + index + " from the array.");
        } else {
            System.out.println("Invalid index. Cannot delete element.");
        }
    }

    public static void main(String[] args) {
        // Create a dynamic array using ArrayList
        ArrayList<Integer> list = new ArrayList<>();

        // Adding elements to the array
        addElement(list, 10);  // Add 10
        addElement(list, 20);  // Add 20
        addElement(list, 30);  // Add 30

        // Print the current array
        System.out.println("Current Array: " + list);

        // Deleting an element from the array
        deleteElement(list, 1);  // Delete element at index 1 (value 20)

        // Print the array after deletion
        System.out.println("Array after deletion: " + list);
    }
}
