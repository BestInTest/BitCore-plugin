package pl.BestInTest.BitCore.Modules.AntyProxy.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Cache {

    //------------------//|  //------------------//|  //------------------//|
    // Nowy system cache//|  // Nowy system cache//|  // Nowy system cache//|
    //------------------//|  //------------------//|  //------------------//|

    static HashMap<String,String> WyjatkiIPNew = new HashMap<>();
    static HashMap<String,String> WyjatkiGraczeNew = new HashMap<>();
    static HashMap<String,String> Proxy = new HashMap<>();
    static HashMap<String,String> Country = new HashMap<>();

                                //------------//|
                                // Wyjatki IP //|
                                //------------//|

    public static void LoadWyjatkiIPNew() throws FileNotFoundException {
        Scanner s = new Scanner(new File("plugins/BitCore/Modules/AntyProxy/whitelist/IP.yml")).useDelimiter(System.lineSeparator());
        if (!WyjatkiIPNew.isEmpty()) {
            WyjatkiIPNew.clear();
        }
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if (line.contains("true")) {
                WyjatkiIPNew.put(line.replaceAll(": true",""),"true");
            }
            if (line.contains("false")) {
                WyjatkiIPNew.put(line.replaceAll(": false", ""),"false");
            }
        }
    }

                             //------------------//|
                             //Zapytania do cache//|
                             //------------------//|
    public static String getFromWyjatkiIPNew(String s) {
        return WyjatkiIPNew.get(s);
    }

                             //------------------//|
                             // Usuwanie z cache //|
                             //------------------//|
    public static void removeFromWyjatkiIPNew(String s) {
        WyjatkiIPNew.remove(s);
    }

                             //------------------//|
                             //Dodawanie do cache//|
                             //------------------//|
    public static void addToWyjatkiIPNew(String s, String value) {
        WyjatkiIPNew.put(s,value);
    }




                            //----------------//|
                            // Wyjatki Gracze //|
                            //----------------//|

    public static void LoadWyjatkiGraczeNew() throws FileNotFoundException {
        Scanner s = new Scanner(new File("plugins/BitCore/Modules/AntyProxy/whitelist/players.yml")).useDelimiter(System.lineSeparator());
        if (!WyjatkiGraczeNew.isEmpty()) {
            WyjatkiGraczeNew.clear();
        }
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if (line.contains("true")) {
                WyjatkiGraczeNew.put(line.replaceAll(": true",""),"true");
            }
            if (line.contains("false")) {
                WyjatkiGraczeNew.put(line.replaceAll(": false", ""),"false");
            }
        }
    }

                            //------------------//|
                            //Zapytania do cache//|
                            //------------------//|
    public static String getFromWyjatkiGraczeNew(String s) {
        return WyjatkiGraczeNew.get(s);
    }

                            //------------------//|
                            // Usuwanie z cache //|
                            //------------------//|
    public static void removeFromWyjatkiGraczeNew(String s) {
        WyjatkiGraczeNew.remove(s);
    }

                            //------------------//|
                            //Dodawanie do cache//|
                            //------------------//|
    public static void addToWyjatkiGraczeNew(String s, String value) {
        WyjatkiGraczeNew.put(s,value);
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
