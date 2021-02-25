package pl.BestInTest.BitCore.Modules.AntyProxy.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Cache {
    static ArrayList<String> ProxyCache = new ArrayList<>();
    static ArrayList<String> CountryCache = new ArrayList<>();
    static ArrayList<String> Wyjatki = new ArrayList<>();
    public static void LoadProxyCache() throws FileNotFoundException {
        Scanner s = new Scanner(new File("plugins/Bitcore/Modules/AntyProxy/cache/proxy.yml")).useDelimiter(System.lineSeparator());
        if (!ProxyCache.isEmpty()) {
            ProxyCache.clear();
        }
        while (s.hasNextLine()){
            ProxyCache.add(s.nextLine());
        }
        s.close();
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
        Scanner s = new Scanner(new File("plugins/Bitcore/Modules/AntyProxy/cache/country.yml")).useDelimiter(System.lineSeparator());
        if (!CountryCache.isEmpty()) {
            CountryCache.clear();
        }
        while (s.hasNextLine()){
            CountryCache.add(s.nextLine());
        }
        s.close();
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
        Scanner s = new Scanner(new File("plugins/Bitcore/Modules/AntyProxy/wyjatki.yml")).useDelimiter(System.lineSeparator());
        if (!Wyjatki.isEmpty()) {
            Wyjatki.clear();
        }
        while (s.hasNextLine()){
            Wyjatki.add(s.nextLine());
        }
        s.close();
    }
    public static boolean getFromWyjatki(String s) {
        for(int i = 1; i < Wyjatki.size(); i++) {
            if (Wyjatki.get(i).equalsIgnoreCase(s)) {
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
}
