package pl.BestInTest.BitCore.Modules.AntyProxy.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import pl.BestInTest.BitCore.Managers.data;
import pl.BestInTest.BitCore.Modules.AntyProxy.Data.Cache;
import pl.BestInTest.BitCore.Modules.AntyProxy.Data.Settings;
import pl.BestInTest.BitCore.Utils.ChatFix;
import pl.BestInTest.BitCore.Utils.Web;

import java.io.IOException;

public class Connect implements Listener {


    @EventHandler
    public void onConnect(AsyncPlayerPreLoginEvent e) throws IOException {
        if (Settings.isEnabled()) {

            boolean cacheCountry = Settings.getcacheCountry();
            boolean cacheProxy = Settings.getcacheProxy();
            boolean ProxyCheck = Settings.getProxyCheck();
            boolean CountryCheck = Settings.getCountryCheck();
            String API = Settings.getProvider();
            String kontakt = Settings.getKontakt();

            String IP = e.getAddress().getHostAddress().replaceAll("\\.", "-");
            boolean isBlocked = Cache.getFromWyjatki(IP + ": false");
            boolean isAllowed = Cache.getFromWyjatki(IP + ": true");
            boolean CountryCache_isAllowed = Cache.getFromCountryCache(IP + ": false");
            boolean CountryCache_isBlocked = Cache.getFromCountryCache(IP + ": true");
            boolean ProxyCache_isAllowed = Cache.getFromProxyCache(IP + ": false");
            boolean ProxyCache_isBlocked = Cache.getFromProxyCache(IP + ": true");
            //System.out.println(isBlocked);
            //System.out.println(isAllowed);
            System.out.println(CountryCache_isAllowed);
            //System.out.println(CountryCache_isBlocked);
            System.out.println(ProxyCache_isAllowed);
            //System.out.println(ProxyCache_isBlocked);

            if (isBlocked) {
                e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatFix.fixColor("&7Polaczenie z serwerem zostalo przerwane z powodu zablokowania Twojego IP w module."));
                return;
            }
            if (isAllowed) {
                return;
            }
            if (ProxyCache_isBlocked) {
                e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatFix.fixColor("&7Twoj adres IP zostal uznany za proxy. Jezli uwazasz, ze to blad zglos to do nas: " + kontakt));
                return;
            }
            if (CountryCache_isBlocked) {
                e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatFix.fixColor("&7Polaczenie z serwerem zostalo przerwane z powodu wykrycia polaczenia niepochodzacego z Polski.\nJezli uwazasz, ze to blad zglos to do nas: " + kontakt));
                return;
            }
            String clearIP = e.getAddress().getHostAddress();
            if (ProxyCheck) {
                if (!ProxyCache_isAllowed) {
                    if (Web.get("https://blackbox.ipinfo.app/lookup/" + clearIP).equalsIgnoreCase("Y")) {
                        e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatFix.fixColor("&7Twoj adres IP zostal uznany za proxy. Jezli uwazasz, ze to blad zglos to do nas: " + kontakt));
                        if (cacheProxy) {
                            data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/cache/proxy.yml", IP, true);
                            Cache.addToProxyCache(IP + ": true");
                        }
                        return;
                    } else {
                        if (cacheProxy) {
                            data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/cache/proxy.yml", IP, false);
                            Cache.addToProxyCache(IP + ": false");
                        }
                    }
                }
            }
            if (CountryCheck) {
                if (cacheCountry && CountryCache_isAllowed) {
                    return;
                }
                if (API.equalsIgnoreCase("ipapi")) {
                    if (Web.get("https://ipapi.co/" + clearIP + "/country/").equalsIgnoreCase("PL")) {
                        if (cacheCountry) {
                            data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/cache/country.yml", IP, false);
                            Cache.addToCountryCache(IP + ": false");
                        }
                    } else {
                        e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatFix.fixColor("&7Polaczenie z serwerem zostalo przerwane z powodu wykrycia polaczenia niepochodzacego z Polski.\nJezli uwazasz, ze to blad zglos to do nas: " + kontakt));
                        if (cacheCountry) {
                            data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/cache/country.yml", IP, true);
                            Cache.addToCountryCache(IP + ": true");
                        }
                    }
                    return;
                }
                if (API.equalsIgnoreCase("ip-api")) {
                    if (Web.get("http://ip-api.com/json/" + clearIP + "?fields=country").equalsIgnoreCase("{\"country\":\"Poland\"}")) {
                        if (cacheCountry) {
                            data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/cache/country.yml", IP, false);
                            Cache.addToCountryCache(IP + ": false");
                        }
                    } else {
                        e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatFix.fixColor("&7Polaczenie z serwerem zostalo przerwane z powodu wykrycia polaczenia niepochodzacego z Polski.\nJezli uwazasz, ze to blad zglos to do nas: " + kontakt));
                        if (cacheCountry) {
                            data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/cache/country.yml", IP, true);
                            Cache.addToCountryCache(IP + ": true");
                        }
                    }
                    return;
                }
                if (API.equalsIgnoreCase("geoip-db")) {
                    if (Web.get("http://geolocation-db.com/jsonp/" + clearIP).contains("Poland")) {
                        if (cacheCountry) {
                            data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/cache/country.yml", IP, false);
                            Cache.addToCountryCache(IP + ": false");
                        }
                    } else {
                        e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatFix.fixColor("&7Polaczenie z serwerem zostalo przerwane z powodu wykrycia polaczenia niepochodzacego z Polski.\nJezli uwazasz, ze to blad zglos to do nas: " + kontakt));
                        if (cacheCountry) {
                            data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/cache/country.yml", IP, true);
                            Cache.addToCountryCache(IP + ": true");
                        }
                    }
                }
            }
        }
    }
}
