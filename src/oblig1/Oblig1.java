package oblig1;

import java.util.*;

/**
 *
 * Aksel Wiig s232324
 */
public class Oblig1 {
    
    public static void main(String... args){
        int[] random = randPerm(10);
        System.out.println(Arrays.toString(random));
        System.out.println(min(random));
        System.out.println(Arrays.toString(random));
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int min(int[] a) {
        if(a.length == 0){
            throw new NoSuchElementException("Tabellen er tom!");
        }
        
        int min = a[0];
        int m = 0;
        for (int i = 0; i < a.length-1; i++) {
            if(a[i] > a[i+1]){
                bytt(a,i,i+1);
                System.out.println(Arrays.toString(a));
            }
        }
        return min;
    }
    
    public static int[] randPerm(int n) { //genererer en tilfeldig array med tall
        Random r = new Random();
        int[] a = new int[n];

        Arrays.setAll(a, i -> i + 1);

        for (int k = n - 1; k > 0; k--) {

            int i = r.nextInt(k + 1);
            bytt(a, k, i);
        }

        return a;
    }
}
