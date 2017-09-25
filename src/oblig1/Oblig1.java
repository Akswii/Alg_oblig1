package oblig1;

import java.util.*;

/**
 *
 * Aksel Wiig s232324
 */
public class Oblig1 {

    public static void main(String... args) {
        int[]a = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(sumX(a, 5)));
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

    public static int antPlasser(int t) {
        int ant = 0;
        if (t > 0) {
            while (t > 0) {
                if (ant == 10) {
                    ant = 0;
                }
                ant++;
                t--;
            }
        } else {
            while (t < 0) {
                if (ant == 10) {
                    ant = 0;
                }
                ant++;
                t++;
            }
        }
        if (ant == 10) {
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

    public static int[] randPerm(int n) {
        Random r = new Random();
        int[] a = new int[n];

        Arrays.setAll(a, i -> i + 1);

        for (int k = n - 1; k > 0; k--) {

            int i = r.nextInt(k + 1);
            bytt(a, k, i);
        }

        return a;
    }

    public static int min(int[]a){
        int n = a.length;
        if(n < 0){
            throw new NoSuchElementException("Tom array");
        }
      
        for (int i = n-1; i > 0; i--) {
            if (a[i] < a[i-1]) {
                bytt(a, i, i-1);
            }
        }
        return a[0];
        
    }

    public static int ombyttinger(int[] a) {
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
        int nyK = antPlasser(k);
        if (a.length != 0) {
            int lengde = a.length - 1;
            char mellomholder;
            int antganger = 0;

            if (nyK >= 0) {
                while (antganger < nyK) {

                    mellomholder = a[lengde];
                    for (int j = lengde; j > 0; j--) {
                        a[j] = a[j - 1];
                    }
                    a[0] = mellomholder;
                    antganger++;
                }
            } else {
                while (antganger > nyK) {
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
    //Effektivitetstesting
    public static int min(int[] a, int fra, int til) { //minsteverdi i et utvalgt snitt av en array
        fratilKontroll(a.length, fra, til);
        int m = fra;
        int minsteverdi = a[fra];

        for (int i = fra + 1; i < til; i++) {
            if (a[i] < minsteverdi) {
                m = i;
                minsteverdi = a[m];
            }
        }
        return m;
    }

    public static void utvalgssortering(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            bytt(a, i, min(a, i, a.length));
        }
    }

    public static void innsettingssortering(int[] a) {
        for (int i = 1; i < a.length; i++) // starter med i = 1
        {
            int verdi = a[i], j = i - 1;      // verdi er et tabellelemnet, j er en indeks
            for (; j >= 0 && verdi < a[j]; j--) {
                a[j + 1] = a[j];  // sammenligner og flytter
            }
            a[j + 1] = verdi;                 // j + 1 er rett sortert plass
        }
    }

    private static int parter0(int[] a, int v, int h, int skilleverdi) {
        while (true) // stopper når v > h
        {
            while (v <= h && a[v] < skilleverdi) {
                v++;   // h er stoppverdi for v
            }
            while (v <= h && a[h] >= skilleverdi) {
                h--;  // v er stoppverdi for h      
            }
            if (v < h) {
                bytt(a, v++, h--);                 // bytter om a[v] og a[h]
            } else {
                return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
            }
        }
    }

    public static void fratilKontroll(int tablengde, int fra, int til) { //teste gyldigheten av et tabellintervall
        if (fra < 0) // fra er negativ
        {
            throw new ArrayIndexOutOfBoundsException("fra(" + fra + ") er negativ!");
        }

        if (til > tablengde) // til er utenfor tabellen
        {
            throw new ArrayIndexOutOfBoundsException("til(" + til + ") > tablengde(" + tablengde + ")");
        }

        if (fra > til) // fra er større enn til
        {
            throw new IllegalArgumentException("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
        }

        if (fra == til) { //fra er den samme verdien som til
            throw new NoSuchElementException("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
        }
    }

    private static int sParter0(int[] a, int v, int h, int indeks) {
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h − 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }

    private static void kvikksortering0(int[] a, int v, int h) // en privat metode
    {
        if (v >= h) {
            return;  // a[v:h] er tomt eller har maks ett element
        }
        int k = sParter0(a, v, h, (v + h) / 2);  // bruker midtverdien
        kvikksortering0(a, v, k - 1);     // sorterer intervallet a[v:k-1]
        kvikksortering0(a, k + 1, h);     // sorterer intervallet a[k+1:h]
    }

    public static void kvikksortering(int[] a, int fra, int til) // a[fra:til>
    {
        fratilKontroll(a.length, fra, til);  // sjekker når metoden er offentlig
        kvikksortering0(a, fra, til - 1);  // v = fra, h = til - 1
    }

    public static void kvikksortering(int[] a) // sorterer hele tabellen
    {
        kvikksortering0(a, 0, a.length - 1);
    }

    private static void flett(int[] a, int[] b, int fra, int m, int til) {
        int n = m - fra;                // antall elementer i a[fra:m>
        System.arraycopy(a, fra, b, 0, n);  // kopierer a[fra:m> over i b[0:n>

        int i = 0, j = m, k = fra;      // løkkeST0r og indekser

        while (i < n && j < til) // fletter b[0:n> og a[m:til> og
        {                               // legger resultatet i a[fra:til>
            a[k++] = b[i] <= a[j] ? b[i++] : a[j++];
        }

        while (i < n) {
            a[k++] = b[i++];  // tar med resten av b[0:n>
        }
    }

    private static void flettesortering(int[] a, int[] b, int fra, int til) {
        if (til - fra <= 1) {
            return;   // a[fra:til> har maks ett element
        }
        int m = (fra + til) / 2;        // midt mellom fra og til

        flettesortering(a, b, fra, m);   // sorterer a[fra:m>
        flettesortering(a, b, m, til);   // sorterer a[m:til>

        if (a[m - 1] > a[m]) {
            flett(a, b, fra, m, til);  // fletter a[fra:m> og a[m:til>
        }
    }

    public static void flettesortering(int[] a) {
        int[] b = Arrays.copyOf(a, a.length / 2);   // en hjelpetabell for flettingen
        flettesortering(a, b, 0, a.length);          // kaller metoden over
    }

    public static void tidSorteringer(int[] a) {
        long tid = System.currentTimeMillis();
        utvalgssortering(a);
        tid = System.currentTimeMillis() - tid;
        System.out.println("Utvalgssorteing: " + tid);

        a = randPerm(100000);

        tid = System.currentTimeMillis();
        innsettingssortering(a);
        tid = System.currentTimeMillis() - tid;
        System.out.println("Innsettingssortering: " + tid);

        a = randPerm(100000);

        tid = System.currentTimeMillis();
        kvikksortering(a);
        tid = System.currentTimeMillis() - tid;
        System.out.println("Kvikksortering: " + tid);

        a = randPerm(100000);

        tid = System.currentTimeMillis();
        flettesortering(a);
        tid = System.currentTimeMillis() - tid;
        System.out.println("Flettesortering: " + tid);
    }
    
     public static int[] sumX(int[] a, int x){
         for (int i = 0; i < 10; i++) {
             for (int j = 0; j < 10; j++) {
                 if((a[i] + a[j]) == x){
                     return new int[]{a[i],a[j]};
                 }
             }
         }
         return null;
     }
}
