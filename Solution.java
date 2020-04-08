import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class Solution {

    /**
     * Check for close numbers.
     * Using Arrays method(s). O(n^2)
     */
    static boolean containsCloseNums1(Integer[] arr, int k) {
    
        // **** get a list of the array ****
        List<Integer> lst = Arrays.asList(arr);

        // **** traverse the list of integers O(n) ****
        for (int i = 0; i < lst.size() - 1; i++) {

            // **** get index of last occurrance of this integer O(n) ****
            int j = lst.lastIndexOf(lst.get(i));

            // **** check if requirements match ****
            if ((i != j) && (Math.abs(i - j) <= k)) {
                return true;
            }
        }

        // **** not found ****
        return false;
    }


    /**
     * Check for close numbers.
     * Using hash map. O(n)
     */
    static boolean containsCloseNums2(Integer[] arr, int k) {

        // **** ****
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        // **** traverse array O(n) ****
        for (int i = 0; i < arr.length; i++) {

            // **** check if integer is not in the hash map O(1) ****
            if (!hm.containsKey(arr[i])) {
                hm.put(arr[i], i);
            } else {
                
                // **** get index ****
                int j = hm.get(arr[i]);

                // **** check if requirements match ****
                if ((i != j) && (Math.abs(i - j) <= k)) {
                    return true;
                } else {

                    // **** update hash map ****
                    hm.put(arr[i], i);
                }
            }
        }

        // **** not found ****
        return false;
    }


    /**
     * Test scaffolding
     */
    public static void main(String[] args) {
        
        // **** open scanner ****
        Scanner sc = new Scanner(System.in);

        // **** read line with integers ****
        String[] is = sc.nextLine().trim().split(" ");

        // **** create array of integers ****
        Integer[] arr = new Integer[is.length];

        // **** populate array of integers ****
        for (int i = 0; i < is.length; i++) {
            arr[i] = Integer.parseInt(is[i]);
        }

        // **** read k ****
        int k = Integer.parseInt(sc.nextLine().trim());

        // **** check and return result ****
        System.out.println(containsCloseNums1(arr, k));
        System.out.println(containsCloseNums2(arr, k));

        // **** close scanner ****
        sc.close();
    }
}