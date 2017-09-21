package oblig1;

import java.util.*;

/**
 *
 * Aksel Wiig s232324
 */
public class Oblig1 {

    public static void main(String... args) {
        int[] random = randPerm(10);
        int[] rekke = {1, 10, 4, 9, 7, 2, 6, 5, 3, 8};
        char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        System.out.println(Arrays.toString(a));
        rotasjon(a, -2);
        System.out.println(Arrays.toString(a));
        oppgave6();
    }
    ///// Oppgave 6 //////////////////////////////////////

    public static int oppgave6() {
        int antallFeil = 0;

        char[] a = {};

        try {
            Oblig1.rotasjon(a, 1);  // kaller metoden
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Oppgave 6: a) Skal ikke kaste unntak for en tom tabell!!");
            antallFeil++;
        }

        char[] b = {'A'};
        char[] b0 = {'A'};
        Oblig1.rotasjon(b, 0);
        if (!Arrays.equals(b, b0)) {
            System.out.println("Oppgave 6: b) Feil hvis tabellen har ett element!");
            antallFeil++;
        }

        Oblig1.rotasjon(b, 1);
        if (!Arrays.equals(b, b0)) {
            System.out.println("Oppgave 6: c) Feil hvis tabellen har ett element!");
            antallFeil++;
        }

        Oblig1.rotasjon(b, -1);
        if (!Arrays.equals(b, b0)) {
            System.out.println("Oppgave 6: d) Feil hvis tabellen har ett element!");
            antallFeil++;
        }

        char[] c = {'A', 'B'};
        char[] c0 = {'B', 'A'};
        Oblig1.rotasjon(c, 1);

        if (!Arrays.equals(c, c0)) {
            System.out.println("Oppgave 6: e) Feil hvis tabellen har to elementer!");
            antallFeil++;
        }

        c = new char[]{'A', 'B'};

        Oblig1.rotasjon(c, -1);
        if (!Arrays.equals(c, c0)) {
            System.out.println("Oppgave 6: f) Feil hvis tabellen har to elementer!");
            antallFeil++;
        }

        char[] d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        char[] d0 = {'G', 'H', 'I', 'J', 'A', 'B', 'C', 'D', 'E', 'F'};

        Oblig1.rotasjon(d, 4);
        if (!Arrays.equals(d, d0)) {
            System.out.println("Oppgave 6: g) Feil hvis tabellen har flere elementer!");
            antallFeil++;
        }

        d = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        Oblig1.rotasjon(d, -6);
        if (!Arrays.equals(d, d0)) {
            System.out.println("Oppgave 6: h) Feil hvis tabellen har flere elementer!");
            antallFeil++;
        }

        char[] x = new char[100_000];
        long tid = System.currentTimeMillis();
        Oblig1.rotasjon(x, 99_999);
        tid = System.currentTimeMillis() - tid;

        if (tid > 20) {
            System.out.println("Oppgave 6: i) Metoden "
                    + "er for ineffektiv. må forbedres!");
            antallFeil++;
        }

        tid = System.currentTimeMillis();
        Oblig1.rotasjon(x, 199_999);
        tid = System.currentTimeMillis() - tid;

        if (tid > 20) {
            System.out.println("Oppgave 6: j) Metoden "
                    + "er for ineffektiv. må forbedres!");
            antallFeil++;
        }

        tid = System.currentTimeMillis();
        Oblig1.rotasjon(x, 50_000);
        tid = System.currentTimeMillis() - tid;

        if (tid > 20) {
            System.out.println("Oppgave 6: k) Metoden "
                    + "er for ineffektiv. må forbedres!");
            antallFeil++;
        }

        tid = System.currentTimeMillis();
        Oblig1.rotasjon(x, -40_000);
        tid = System.currentTimeMillis() - tid;

        if (tid > 20) {
            System.out.println("Oppgave 6: l) Metoden "
                    + "er for ineffektiv. må forbedres!");
            antallFeil++;
        }

        return antallFeil;
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sortering(int[] a, int v, int h) {
        for (int i = h; i > v; i--) {
            int m = maks(a, v, i);
            System.out.print(m + ",");
            bytt(a, i - 1, m);
        }
    }

    public static int maks(int[] a, int fra, int til) { //størsteveri i et utvalgt snitt av en array
        //fratilKontroll(a.length, fra, til);

        if (a == null) {
            throw new NullPointerException("Tabellen er null!");
        }
        if (a == null) {
            throw new NullPointerException("Tabellen er null!");
        }

        int m = fra;
        int maksverdi = a[fra];

        for (int i = fra + 1; i < til; i++) {
            if (a[i] > maksverdi) {
                m = i;
                maksverdi = a[m];
            }
        }
        return m;
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

    public static void delsortering(int[] a) {
        int lengde = a.length;
        int v = 0, h = lengde - 1;

        while (v < h) {
            if (((a[v] % 2) == 0) && !((a[h] % 2) == 0)) {
                bytt(a, v, h);
                v++;
                h--;
            } else if ((a[v] % 2) == 0) {
                h--;
            } else if (!((a[h] % 2) == 0)) {
                v++;
            } else if (!((a[v] % 2) == 0) && ((a[h] % 2) == 0)) {
                v++;
                h--;
            }
        }
        //System.out.println(Arrays.toString(a) + " " + v + " " + h);
    }

    public static void rotasjon(char[] a) {
        if (a.length != 0) {
            int lengde = a.length - 1;
            char mellomholder = a[lengde];

            for (int i = lengde; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = mellomholder;
            System.out.println(Arrays.toString(a));
        }
    }

    public static void rotasjon(char[] a, int k) {
        if (a.length != 0) {
            int lengde = a.length - 1;
            char mellomholder;
            int antganger = 0;
            if (k >= 0) {
                while (antganger < k) {
                    mellomholder = a[lengde];
                    for (int j = lengde; j > 0; j--) {
                        a[j] = a[j - 1];
                    }
                    a[0] = mellomholder;
                    antganger++;
                }
            } else {
                while (antganger > k) {
                    mellomholder = a[0];
                    for (int j = 0; j < lengde; j++) {
                        a[j] = a[j + 1];
                    }
                    a[lengde] = mellomholder;
                    antganger--;
                }
            }
        }
    }
}
