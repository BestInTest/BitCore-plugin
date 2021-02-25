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
    boolean cacheCountry = Settings.getcacheCountry();
    boolean cacheProxy = Settings.getcacheProxy();
    boolean ProxyCheck = Settings.getProxyCheck();
    boolean CountryCheck = Settings.getCountryCheck();
    String API = Settings.getProvider();
    String kontakt = Settings.getKontakt();

    @EventHandler
    public void onConnect(AsyncPlayerPreLoginEvent e) throws IOException {
        if (Settings.isEnabled()) {

            String IP = e.getAddress().getHostAddress().replaceAll("\\.", "-");
            boolean isBlocked = Cache.getFromWyjatki(IP + ": false");
            boolean isAllowed = Cache.getFromWyjatki(IP + ": true");
            boolean isCountryCached = Cache.getFromCountryCache(IP + ": true");
            boolean isProxyCached = Cache.getFromProxyCache(IP + ": true");

            if (isBlocked) {
                e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatFix.fixColor("&7Polaczenie z serwerem zostalo przerwane z powodu zablokowania Twojego IP w module."));
                return;
            }
            if (isAllowed) {
                return;
            }
            if (cacheCountry) {
                if (isCountryCached) {
                    return;
                }
            }
            if (ProxyCheck) {
                if (cacheProxy) {
                    if (!isProxyCached) {
                        e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatFix.fixColor("&7Twoj adres IP zostal uznany za proxy. Jezli uwazasz, ze to blad zglos to do nas: " + kontakt));
                    }
                    return;
                }
                if (Web.get("https://blackbox.ipinfo.app/lookup/%player's ip%").equalsIgnoreCase("Y")) {
                    e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatFix.fixColor("&7Twoj adres IP zostal uznany za proxy. Jezli uwazasz, ze to blad zglos to do nas: " + kontakt));
                    if (cacheProxy) {
                        data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/cache/proxy.yml", IP, false);
                        Cache.addToProxyCache(IP + ": false");
                    }
                    return;
                } else {
                    if (cacheProxy) {
                        data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/cache/proxy.yml", IP, true);
                        Cache.addToProxyCache(IP + ": true");
                    }
                }
            }
            if (CountryCheck) {
                String clearIP = e.getAddress().getHostAddress();
                if (API.equalsIgnoreCase("ipapi")) {
                    if (Web.get("https://ipapi.co/" + clearIP + "/country/").equalsIgnoreCase("PL")) {
                        if (cacheCountry) {
                            data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/cache/country.yml", IP, true);
                            Cache.addToCountryCache(IP + ": true");
                        }
                    } else {
                        e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatFix.fixColor("&7Twoj adres IP zostal uznany za proxy. Jezli uwazasz, ze to blad zglos to do nas: " + kontakt));
                    }
                    return;
                }
                if (API.equalsIgnoreCase("ip-api")) {
                    if (Web.get("http://ip-api.com/json/" + clearIP + "?fields=country").equalsIgnoreCase("{\"country\":\"Poland\"}")) {
                        if (cacheCountry) {
                            data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/cache/country.yml", IP, true);
                            Cache.addToCountryCache(IP + ": true");
                        }
                    } else {
                        e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatFix.fixColor("&7Twoj adres IP zostal uznany za proxy. Jezli uwazasz, ze to blad zglos to do nas: " + kontakt));
                    }
                    return;
                }
                if (API.equalsIgnoreCase("geoip-db")) {
                    if (Web.get("http://geolocation-db.com/jsonp/" + clearIP).contains("Poland")) {
                        if (cacheCountry) {
                            data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/cache/country.yml", IP, true);
                            Cache.addToCountryCache(IP + ": true");
                        }
                    } else {
                        e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatFix.fixColor("&7Twoj adres IP zostal uznany za proxy. Jezli uwazasz, ze to blad zglos to do nas: " + kontakt));
                    }
                }
            }
        }
    }
}
