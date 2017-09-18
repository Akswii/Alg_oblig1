package oblig1;

import java.util.*;

/**
 *
 * Aksel Wiig s232324
 */
public class Oblig1 {

    public static void main(String... args) {
        int[] random = randPerm(10);
        int[] rekke = {1, 1, 1, 3, 3, 3, 5, 5, 5, 7, 7};
        System.out.println(Arrays.toString(rekke));
        System.out.println(modus2(rekke));
        System.out.println(Arrays.toString(rekke));
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
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

    public static int min(int[] a) { //må finne antall sammenligninger 
        if (a.length == 0) {
            throw new NoSuchElementException("Tabellen er tom!");
        }

        int m = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[m] > a[i]) {
                bytt(a, m, i);
            }
        }
        return a[0];
    }

    public static int ombyttinger(int[] a) { //mer eller mindre effektiv?
        if (a.length == 0) {
            throw new NoSuchElementException("Tabellen er tom!");
        }

        int m = 0, ant = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[m] > a[i]) {
                bytt(a, m, i);
                ant++;
            }
        }
        return ant;
    }

    public static int modus(int[] a) {
        if (a.length < 0) {
            throw new IllegalStateException("Arrayen er tom.");
        }

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] < a[i]) {
                throw new IllegalStateException("Tabellen er ikke sortert.");
            }
        }

        int antTall = 0, maks = 0, maksverdi = 0;

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1]) {
                antTall++;
                if (antTall >= maks) {
                    maks = antTall;
                    maksverdi = a[i];
                }
            } else {
                antTall = 0;
            }
        }
        return maksverdi;
    }

    public static int modus2(int[] a) {
        if (a.length < 0) {
            throw new IllegalStateException("Arrayen er tom.");
        }

        int antTall = 0, maks = 0, maksverdi = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[i] == a[j]) {
                    antTall++;
                    if (antTall >= maks) {
                        maks = antTall;
                        maksverdi = a[i];
                    }
                } else {
                    antTall = 0;
                }
            }
        }
        return maksverdi;
    }
    
    
    public static void delsortering(int[] a){
        
    }
}
