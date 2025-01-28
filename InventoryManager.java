import java.util.Arrays;
import java.util.Date;

// Stock class with relevant fields
class Stock {
    String brand;
    Date dateEntered;
    String status;
    String engineNumber;

    // Constructor to initialize a stock item
    public Stock(String brand, Date dateEntered, String status, String engineNumber) {
        this.brand = brand;
        this.dateEntered = dateEntered;
        this.status = status;
        this.engineNumber = engineNumber;
    }

    // Method to print Stock details (for displaying)
    public void printStock() {
        System.out.println("Brand: " + this.brand + ", Date Entered: " + this.dateEntered + ", Status: " + this.status + ", Engine Number: " + this.engineNumber);
    }
}

public class InventoryManager {
    
    // Method to sort the array of Stock by Brand, DateEntered, and Status
    public static void sortStocks(Stock[] stocks) {
        // Using Arrays.sort with a custom Comparator for sorting by Brand, DateEntered, and Status
        Arrays.sort(stocks, (s1, s2) -> {
            // First sort by brand
            int brandCompare = s1.brand.compareTo(s2.brand);
            if (brandCompare != 0) {
                return brandCompare;
            }
            // If brands are the same, sort by DateEntered
            int dateCompare = s1.dateEntered.compareTo(s2.dateEntered);
            if (dateCompare != 0) {
                return dateCompare;
            }
            // If both brand and DateEntered are the same, sort by Status
            return s1.status.compareTo(s2.status);
        });
    }

    // Method to perform binary search based on engine number (assuming the array is sorted)
    public static Stock searchStockByEngineNumber(Stock[] stocks, String engineNumber) {
        int left = 0;
        int right = stocks.length - 1;
        
        // Binary search logic for sorted array by engine number
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (stocks[mid].engineNumber.equals(engineNumber)) {
                return stocks[mid];  // Found the stock with the matching engine number
            } else if (stocks[mid].engineNumber.compareTo(engineNumber) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Stock not found
    }

    public static void main(String[] args) {
        // Creating sample stock data
        @SuppressWarnings("deprecation")
        Stock[] stocks = new Stock[]{
            new Stock("Honda", new Date(2023, 1, 2), "On-hand", "142QVTSIUR"),
            new Stock("Kawasaki", new Date(2023, 2, 3), "Sold", "483QHIM661"),
            new Stock("Yamaha", new Date(2023, 2, 8), "On-hand", "TMZCTALNDL"),
            new Stock("Honda", new Date(2023, 3, 5), "On-hand", "W2UYM0EIRS")
        };
        
        // Printing unsorted stocks
        System.out.println("Unsorted Stocks:");
        for (Stock stock : stocks) {
            stock.printStock();
        }

        // Sorting the stocks by brand, date, and status
        sortStocks(stocks);
        
        // Printing sorted stocks
        System.out.println("\nSorted Stocks:");
        for (Stock stock : stocks) {
            stock.printStock();
        }

        // Searching for a stock by engine number
        String engineNumberToSearch = "W2UYM0EIRS";
        Stock foundStock = searchStockByEngineNumber(stocks, engineNumberToSearch);
        
        // Printing search result
        if (foundStock != null) {
            System.out.println("\nFound Stock:");
            foundStock.printStock();
        } else {
            System.out.println("\nStock with engine number " + engineNumberToSearch + " not found.");
        }
    }
}
