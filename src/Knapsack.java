/**
 * FibonacciMemoization
 * 
 * This class calculates the highest value that can be obtained by filling a knapsack of capacity W with 
 * items of different weights and values using a dynamic programming table.
 * 
 * Felipe Campelo
 * https://www.felipecampelo.com.br
*/

public class Knapsack {

    // Dynamic Programming approach to solve 0/1 Knapsack problem
    static int knapSack(int capacity, int weights[], int values[]) {
        int numItems = values.length;
        int itemPointer, currentCapacity, remainingCapacity;
        int dpTable[][] = new int[numItems+1][capacity+1];
        
        // Build table dpTable[][] in bottom-up manner
        // dpTable (numItems + 1) X (capacity + 1)

        for (itemPointer = 0; itemPointer <= numItems; itemPointer++) { // ip {0 ... numItems}, lines

            for (currentCapacity = 0; currentCapacity <= capacity; currentCapacity++) { // cp {0 ... capacity}, columns

                if (itemPointer == 0 || currentCapacity == 0) // First line and column with 0s
                    dpTable[itemPointer][currentCapacity] = 0;

                else if (weights[itemPointer-1] <= currentCapacity) { // Fits in the knapsack?

                    remainingCapacity = currentCapacity - weights[itemPointer-1]; // current capacity - item.weight

                    dpTable[itemPointer][currentCapacity] = Math.max(
                        values[itemPointer-1] + dpTable[itemPointer-1][remainingCapacity], // new value + the previous item at the remaining capacity
                        dpTable[itemPointer-1][currentCapacity] // value of the previous item at the same capacity
                    );

                }

                else // Doesn't fit 
                    dpTable[itemPointer][currentCapacity] = dpTable[itemPointer-1][currentCapacity]; // repeat the previous item

            }
            
        }

        return dpTable[numItems][capacity];
    }

    // Driver program to test above function
    public static void main(String args[]) {

        int values[] = new int[] {60, 100, 120};
        int weights[] = new int[] {10, 20, 30};
        int capacity = 50;
        
        int bestValue = knapSack(capacity, weights, values);

        System.out.println("Best value that can be obtained is: " + bestValue);
    }
}
