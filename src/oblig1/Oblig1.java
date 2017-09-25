package oblig1;

import java.util.*;

/**
 * Aksel Wiig s232324
 * Tommy Tran s315573
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
    public static int min(int[] a, int fra, int til) {
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
        for (int i = 1; i < a.length; i++)
        {
            int verdi = a[i], j = i - 1;
            for (; j >= 0 && verdi < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = verdi;
        }
    }

    private static int parter0(int[] a, int v, int h, int skilleverdi) {
        while (true)
        {
            while (v <= h && a[v] < skilleverdi) {
                v++;
            }
            while (v <= h && a[h] >= skilleverdi) {
                h--;    
            }
            if (v < h) {
                bytt(a, v++, h--);
            } else {
                return v;
            }
        }
    }

    public static void fratilKontroll(int tablengde, int fra, int til) {
        if (fra < 0)
        {
            throw new ArrayIndexOutOfBoundsException("fra(" + fra + ") er negativ!");
        }

        if (til > tablengde)
        {
            throw new ArrayIndexOutOfBoundsException("til(" + til + ") > tablengde(" + tablengde + ")");
        }

        if (fra > til)
        {
            throw new IllegalArgumentException("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
        }

        if (fra == til) {
            throw new NoSuchElementException("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
        }
    }

    private static int sParter0(int[] a, int v, int h, int indeks) {
        bytt(a, indeks, h);
        int pos = parter0(a, v, h - 1, a[h]);  
        bytt(a, pos, h);              
        return pos;                   
    }

    private static void kvikksortering0(int[] a, int v, int h)
    {
        if (v >= h) {
            return;
        }
        int k = sParter0(a, v, h, (v + h) / 2);
        kvikksortering0(a, v, k - 1);     
        kvikksortering0(a, k + 1, h);     
    }

    public static void kvikksortering(int[] a, int fra, int til)
    {
        fratilKontroll(a.length, fra, til);
        kvikksortering0(a, fra, til - 1);
    }

    public static void kvikksortering(int[] a)
    {
        kvikksortering0(a, 0, a.length - 1);
    }

    private static void flett(int[] a, int[] b, int fra, int m, int til) {
        int n = m - fra;
        System.arraycopy(a, fra, b, 0, n); 

        int i = 0, j = m, k = fra;

        while (i < n && j < til)
        {                       
            a[k++] = b[i] <= a[j] ? b[i++] : a[j++];
        }

        while (i < n) {
            a[k++] = b[i++];
        }
    }

    private static void flettesortering(int[] a, int[] b, int fra, int til) {
        if (til - fra <= 1) {
            return;
        }
        int m = (fra + til) / 2;       

        flettesortering(a, b, fra, m); 
        flettesortering(a, b, m, til); 

        if (a[m - 1] > a[m]) {
            flett(a, b, fra, m, til);  
        }
    }

    public static void flettesortering(int[] a) {
        int[] b = Arrays.copyOf(a, a.length / 2);
        flettesortering(a, b, 0, a.length);      
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
