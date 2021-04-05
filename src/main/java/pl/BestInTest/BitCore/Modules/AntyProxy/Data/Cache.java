package pl.BestInTest.BitCore.Modules.AntyProxy.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Cache {
    static ArrayList<String> ProxyCache = new ArrayList<>();
    static ArrayList<String> CountryCache = new ArrayList<>();
    static ArrayList<String> Wyjatki = new ArrayList<>();
    public static void LoadProxyCache() throws FileNotFoundException {
        Scanner s = new Scanner(new File("plugins/BitCore/Modules/AntyProxy/cache/proxy.yml")).useDelimiter(System.lineSeparator());
        if (!ProxyCache.isEmpty()) {
            ProxyCache.clear();
        }
        while (s.hasNextLine()){
            ProxyCache.add(s.nextLine());
        }
        s.close();
        System.out.println(ProxyCache);
    }
    public static boolean getFromProxyCache(String s) {
        for(int i = 1; i < ProxyCache.size(); i++) {
            if (ProxyCache.get(i).equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }
    public static void addToProxyCache(String s) {
        ProxyCache.add(s);
    }
    public static void LoadCountryCache() throws FileNotFoundException {
        Scanner s = new Scanner(new File("plugins/BitCore/Modules/AntyProxy/cache/country.yml")).useDelimiter(System.lineSeparator());
        if (!CountryCache.isEmpty()) {
            CountryCache.clear();
        }
        while (s.hasNextLine()){
            CountryCache.add(s.nextLine());
        }
        s.close();
        System.out.println(CountryCache);
    }
    public static boolean getFromCountryCache(String s) {
        for(int i = 1; i < CountryCache.size(); i++) {
            if (CountryCache.get(i).equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }
    public static void addToCountryCache(String s) {
        CountryCache.add(s);
    }
    public static void LoadWyjatki() throws FileNotFoundException {
        Scanner s = new Scanner(new File("plugins/BitCore/Modules/AntyProxy/wyjatki.yml")).useDelimiter(System.lineSeparator());
        if (!Wyjatki.isEmpty()) {
            Wyjatki.clear();
        }
        while (s.hasNextLine()){
            Wyjatki.add(s.nextLine());
        }
        s.close();
    }
    public static boolean getFromWyjatki(String s) {
        for (String ln : Wyjatki) {
            if (ln.contains(s)) {
                return true;
            }
        }
        return false;
    }

    public static void addToWyjatki(String s) {
        Wyjatki.add(s);
    }
    public static void removeFromWyjatki(String s) {
        Wyjatki.removeAll(Collections.singleton(s));
    }


    //------------------//|  //------------------//|  //------------------//|
    // Nowy system cache//|  // Nowy system cache//|  // Nowy system cache//|
    //------------------//|  //------------------//|  //------------------//|

    static HashMap<String,String> WyjatkiNew = new HashMap<>();
    static HashMap<String,String> Proxy = new HashMap<>();
    static HashMap<String,String> Country = new HashMap<>();

                                //---------//|
                                // Wyjatki //|
                                //---------//|

    public static void LoadWyjatkiNew() throws FileNotFoundException {
        Scanner s = new Scanner(new File("plugins/BitCore/Modules/AntyProxy/wyjatki.yml")).useDelimiter(System.lineSeparator());
        if (!WyjatkiNew.isEmpty()) {
            WyjatkiNew.clear();
        }
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if (line.contains("true")) {
                WyjatkiNew.put(line.replaceAll(": true",""),"true");
            }
            if (line.contains("false")) {
                WyjatkiNew.put(line.replaceAll(": false", ""),"false");
            }
        }
    }

                             //------------------//|
                             //Zapytania do cache//|
                             //------------------//|
    public static String getFromWyjatkiNew(String s) {
        return WyjatkiNew.get(s);
    }

                             //------------------//|
                             // Usuwanie z cache //|
                             //------------------//|
    public static void removeFromWyjatkiNew(String s) {
        WyjatkiNew.remove(s);
    }

                             //------------------//|
                             //Dodawanie do cache//|
                             //------------------//|
    public static void addToWyjatkiNew(String s, String value) {
        WyjatkiNew.put(s,value);
    }




                            //---------//|
                            //  Proxy  //|
                            //---------//|

    public static void LoadProxyNew() throws FileNotFoundException {
        Scanner s = new Scanner(new File("plugins/BitCore/Modules/AntyProxy/cache/proxy.yml")).useDelimiter(System.lineSeparator());
        if (!Proxy.isEmpty()) {
            Proxy.clear();
        }
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if (line.contains("true")) {
                Proxy.put(line.replaceAll(": true",""),"true");
            }
            if (line.contains("false")) {
                Proxy.put(line.replaceAll(": false", ""),"false");
            }
        }
    }

    //------------------//|
    //Zapytania do cache//|
    //------------------//|
    public static String getFromProxyNew(String s) {
        return Proxy.get(s);
    }

    //------------------//|
    // Usuwanie z cache //|
    //------------------//|
    public static void removeFromProxyNew(String s) {
        Proxy.remove(s);
    }

    //------------------//|
    //Dodawanie do cache//|
    //------------------//|
    public static void addToProxyNew(String s, String value) {
        Proxy.put(s,value);
    }




                            //---------//|
                            // Country //|
                            //---------//|

    public static void LoadCountryNew() throws FileNotFoundException {
        Scanner s = new Scanner(new File("plugins/BitCore/Modules/AntyProxy/cache/country.yml")).useDelimiter(System.lineSeparator());
        if (!Country.isEmpty()) {
            Country.clear();
        }
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if (line.contains("true")) {
                Country.put(line.replaceAll(": true",""),"true");
            }
            if (line.contains("false")) {
                Country.put(line.replaceAll(": false", ""),"false");
            }
        }
    }

    //------------------//|
    //Zapytania do cache//|
    //------------------//|
    public static String getFromCountryNew(String s) {
        return Country.get(s);
    }

    //------------------//|
    // Usuwanie z cache //|
    //------------------//|
    public static void removeFromCountryNew(String s) {
        Country.remove(s);
    }

    //------------------//|
    //Dodawanie do cache//|
    //------------------//|
    public static void addToCountryNew(String s, String value) {
        Country.put(s,value);
    }
}
