package oblig1;

import java.util.*;

/**
 * Aksel Wiig s232324 Tommy Tran s315573
 */
public class Oblig1 {

    public static void main(String... args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        rotasjon(a, 5)
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int antPlasser(int t, int a) {
        int ant = 0;
        if (t > 0) {
            while (t > 0) {
                if (ant == a) {
                    ant = 0;
                }
                ant++;
                t--;
            }
        } else {
            while (t < 0) {
                if (ant == a) {
                    ant = 0;
                }
                ant++;
                t++;
            }
            ant *= -1;
        }
        if (ant == a) {
            return 0;
        }
        return ant;
    }

    public static int maks(int[] a, int fra, int til) {

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

    /*
        Det blir gjort n-1 sammenligniner i min-metoden vår.
        Det blir gjort flest ombyttninger når tabellen er sortert synkende, ettersom vi begynner bakerst og flytter det minste tallet til framst i tabellen.
        Det blir gjort færrest ombyttinger når tabellen er sortert stigende.
    
        Hvis alle verdiene er forskjellige, blir det en 
        ombytting hver gang det kommer en verdi som er mindre enn den minste du har funnet tidligere i tabellen. 
        Av de n - 1 verdiene som kommer etter den første, er det i gjennomsnitt H(n) - 1 stykker som er mindre 
        enn den minste foran. Dermed blir svaret n - 1 - (H(n) - 1) =
        n - H(n) der H(n) er det n-te harmoniske tallet.
     */
    public static int min(int[] a) {
        int n = a.length;
        if (n <= 0) {
            throw new NoSuchElementException("Tom array");
        }

        for (int i = n - 1; i > 0; i--) {
            if (a[i] < a[i - 1]) {
                bytt(a, i, i - 1);
            }
        }
        return a[0];

    }

    public static int ombyttinger(int[] a) {
        if (a.length == 0) {
            throw new NoSuchElementException("Tabellen er tom!");
        }

        int m = 0, ant = 0;

        for (int i = a.length - 1; i > 0; i--) {
            if (a[i] < a[i - 1]) {
                bytt(a, i, i - 1);
                ant++;
            }
        }
        return ant;
    }

    public static int modus1(int[] a) {
        if (a.length <= 0) {
            throw new IllegalStateException("Arrayen er tom.");
        }

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] < a[i]) {
                throw new IllegalStateException("Tabellen er ikke sortert.");
            }
        }
        int antTall = 0, maks = 0, maksverdi = 0;
        if (a.length > 1) {
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
        } else {
            return a[0];
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

        while (v <= h) {
            if (((a[v] % 2) == 0) && !((a[h] % 2) == 0)) {
                bytt(a, v++, h--);
            } else if ((a[v] % 2) == 0) {
                h--;
            } else if (!((a[h] % 2) == 0)) {
                v++;
            } else if (!((a[v] % 2) == 0) && ((a[h] % 2) == 0)) {
                v++;
                h--;
            }
        }
        Arrays.sort(a, 0, v);
        Arrays.sort(a, v, lengde);
    }

    public static void rotasjon(char[] a) {
        if (a.length != 0) {
            int lengde = a.length - 1;
            char mellomholder = a[lengde];

            for (int i = lengde; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = mellomholder;
        }
    }

    public static void rotasjon(char[] a, int k) {
        int n = a.length;

        if (n < 2) {
            return;
        }

        k %= n;

        char[] tmp = new char[Math.abs(k)];
        int c = 0;

        // Mot høyre
        if (k > 0) {
            for (int i = n - k; i < n; i++) {
                tmp[c++] = a[i];
            }

            for (int i = n - k - 1; i >= 0; i--) {
                a[k + i] = a[i];
                if (i < k) {
                    a[i] = tmp[i];
                }
            }
            // Mot venstre
        } else if (k < 0) {
            k = Math.abs(k);

            for (int i = 0; i < k; i++) {
                tmp[i] = a[i];
            }

            for (int i = 0; i <= n - k - 1; i++) {
                a[i] = a[k + i];
            }

            for (int i = 0; i < tmp.length; i++) {
                a[n - i - 1] = tmp[k - i - 1];
            }
        }
    }

    public static String flett(String... s) {
        String r = "";
        int l = 0;

        for (String x : s) {
            l += x.length();
        }

        int[] c = new int[s.length];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < s.length; j++) {
                if (c[j] < s[j].length()) {
                    r += s[j].toCharArray()[c[j]];
                    c[j]++;
                }
            }
        }

        return r;
    }
}
