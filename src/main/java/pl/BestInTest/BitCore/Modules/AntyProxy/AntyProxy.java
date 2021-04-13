package pl.BestInTest.BitCore.Modules.AntyProxy;

import pl.BestInTest.BitCore.Managers.data;
import pl.BestInTest.BitCore.Modules.AntyProxy.Data.Cache;
import pl.BestInTest.BitCore.Modules.AntyProxy.Data.Settings;
import pl.BestInTest.BitCore.Utils.ChatFix;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AntyProxy {
    public static void start() throws FileNotFoundException {
        if (pl.BestInTest.BitCore.Utils.Settings.isAntyProxyEnabled()) {
            System.out.println((ChatFix.fixColor("&9&l[AntyProxy] &7Sprawdzam pliki...")));
            try {
                if (!data.exists("plugins/BitCore/Modules/AntyProxy/Settings.yml")) {
                    data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/Settings.yml", "Enabled", true);
                    data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/Settings.yml", "cache-country-ips", true);
                    data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/Settings.yml", "cache-proxy-ips", true);
                    data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/Settings.yml", "Proxy-check", true);
                    data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/Settings.yml", "Country-check", true);
                    data.ymlSave("plugins/BitCore/Modules/AntyProxy/Settings.yml", "api-provider", "ipapi"); // ipapi, ip-api, geoip-db
                }
                if (!data.exists("plugins/BitCore/Modules/AntyProxy/lang.yml")) {
                    data.ymlSave("plugins/BitCore/Modules/AntyProxy/lang.yml", "Kontakt", "&a<NL>discord.com");
                }
                if (!data.exists("plugins/BitCore/Modules/AntyProxy/wyjatki.yml")) {
                    data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/wyjatki.yml", "127-0-0-1", true);
                }
                if (!data.exists("plugins/BitCore/Modules/AntyProxy/cache/country.yml")) {
                    data.createFile("plugins/BitCore/Modules/AntyProxy/cache/country.yml");
                }
                if (!data.exists("plugins/BitCore/Modules/AntyProxy/cache/proxy.yml")) {
                    data.createFile("plugins/BitCore/Modules/AntyProxy/cache/proxy.yml");
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(ChatFix.fixColor("&9&l[AntyProxy] &cNie mozna odczytac lub zapisac plikow konfiguracyjnych! Sprawdz czy uprawnienia dostepu do plikow zostaly poprawnie ustawione."));
            }
            System.out.println(ChatFix.fixColor("&9&l[AntyProxy] &7Ladowanie cache..."));
            long timerStart = System.currentTimeMillis();
            Settings.reloadConfig();
            byte n = 1;
            byte p = 0;
            if (Settings.getcacheCountry()) {
                n++;
            }
            if (Settings.getcacheProxy()) {
                n++;
            }
            if (Settings.getcacheCountry()) {
                p++;
                System.out.println(ChatFix.fixColor("&9&l[AntyProxy] &7Ladowanie cache (" + p + "/" + n + ")"));
                Cache.LoadCountryNew();
            }
            if (Settings.getcacheProxy()) {
                p++;
                System.out.println(ChatFix.fixColor("&9&l[AntyProxy] &7Ladowanie cache (" + p + "/" + n + ")"));
                Cache.LoadProxyNew();
            }
            p++;
            System.out.println(ChatFix.fixColor("&9&l[AntyProxy] &7Ladowanie wyjatkow (" + p + "/" + n + ")"));
            Cache.LoadWyjatkiNew();
            System.out.println(ChatFix.fixColor("&9&l[AntyProxy] &7Zakonczono ladowanie cache (" + (System.currentTimeMillis() - timerStart) + " ms)"));
            System.out.println(ChatFix.fixColor("&9&l[AntyProxy] &aWlaczono modul AntyProxy"));
        }
    }
}
