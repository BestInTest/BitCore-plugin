package pl.BestInTest.BitCore.Modules.AntyProxy.Data;

import pl.BestInTest.BitCore.Managers.data;

import java.io.IOException;

public class Settings {

    private static boolean ProxyCheck;
    private static boolean CountryCheck;
    private static boolean cacheCountry;
    private static boolean cacheProxy;
    private static String Provider;
    private static String Kontakt;
    private static boolean enable;

    public static void reloadConfig() {
        ProxyCheck = Boolean.parseBoolean(data.ymlLoad("plugins/Bitcore/Modules/AntyProxy/Settings.yml", "Proxy-check"));
        CountryCheck = Boolean.parseBoolean(data.ymlLoad("plugins/Bitcore/Modules/AntyProxy/Settings.yml", "Country-check"));
        cacheCountry = Boolean.parseBoolean(data.ymlLoad("plugins/Bitcore/Modules/AntyProxy/Settings.yml", "cache-country-ips"));
        cacheProxy = Boolean.parseBoolean(data.ymlLoad("plugins/Bitcore/Modules/AntyProxy/Settings.yml", "cache-proxy-ips"));
        Provider = data.ymlLoad("plugins/Bitcore/Modules/AntyProxy/Settings.yml", "api-provider");
        Kontakt = data.ymlLoad("plugins/Bitcore/Modules/AntyProxy/lang.yml", "Kontakt");
        enable = pl.BestInTest.BitCore.Utils.Settings.isAntyProxyEnabled();
    }
    public static boolean getProxyCheck() {
        return ProxyCheck;
    }
    public static boolean getCountryCheck() {
        return CountryCheck;
    }
    public static boolean getcacheCountry() {
        return cacheCountry;
    }
    public static boolean getcacheProxy() {
        return cacheProxy;
    }
    public static String getProvider() {
        return Provider;
    }
    public static String getKontakt() {
        return Kontakt;
    }
    public static boolean isEnabled() {
        return enable;
    }

    public static void setCountryCheck(boolean bool) throws IOException {
        data.ymlSaveBoolean("plugins/Bitcore/Modules/AntyProxy/Settings.yml", "Country-check",bool);
        CountryCheck = bool;
    }
    public static void setProxyCheck(boolean bool) throws IOException {
        data.ymlSaveBoolean("plugins/Bitcore/Modules/AntyProxy/Settings.yml", "Proxy-check",bool);
        ProxyCheck = bool;
    }
    public static void setcacheProxy(boolean bool) throws IOException {
        data.ymlSaveBoolean("plugins/Bitcore/Modules/AntyProxy/Settings.yml", "cache-proxy-ips",bool);
        cacheProxy = bool;
    }
    public static void setcacheCountry(boolean bool) throws IOException {
        data.ymlSaveBoolean("plugins/Bitcore/Modules/AntyProxy/Settings.yml", "cache-country-ips",bool);
        cacheCountry = bool;
    }
    public static void setProvider(String s) throws IOException {
        data.ymlSave("plugins/Bitcore/Modules/AntyProxy/Settings.yml", "api-provider",s);
        Provider = s;
    }
}
