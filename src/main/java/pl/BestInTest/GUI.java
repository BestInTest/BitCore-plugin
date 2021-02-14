package pl.BestInTest;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import pl.BestInTest.Utils.ChatFix;
import pl.BestInTest.Utils.FillSlots;
import pl.BestInTest.Utils.ItemBuilder;
import pl.BestInTest.Utils.data;

import java.util.Arrays;
import java.util.Objects;

public class GUI {
    public static void bitcore(Player p) {
        Inventory Inventory = Bukkit.createInventory(p, 18, ChatFix.fixColor("&e&lBitCore"));
        ItemBuilder border = (new ItemBuilder(Material.THIN_GLASS, 1)).setTitle(" ");

        //String bitcorewersja = Web.checkContent("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja-BitCore.txt");
        String bitcorewersja = data.ymlLoad("plugins/Bitcore/data/cache.yml", "version-cache.bitcore");
        String stepwersja = data.ymlLoad("plugins/Bitcore/data/cache.yml", "version-cache.step");
        String antyproxywersja = data.ymlLoad("plugins/Bitcore/data/cache.yml", "version-cache.antyproxy");
        String pingerwersja = data.ymlLoad("plugins/Bitcore/data/cache.yml", "version-cache.pinger");

        ItemBuilder informacje = (new ItemBuilder(Material.BOOK, 1)).setTitle(ChatFix.fixColor("&aInformacje o BitCore:"))
                .addLores(Arrays.asList(ChatFix.fixColor("&7BitCore to narzedzie stworzone")
                        , ChatFix.fixColor("&7do ochrony serwera przed roznymi atakami.")
                        , ""
                        , ChatFix.fixColor("&aWersja zainstalowana&7: {@Wersja}")
                        , ChatFix.fixColor("&bDane z serwera online&7:")
                        , ""
                        , ChatFix.fixColor("&aBitCore: &7" + bitcorewersja)
                        , ChatFix.fixColor("&c2Step&8: &7" + stepwersja)
                        , ChatFix.fixColor("&6AntyProxy&8: &7" + antyproxywersja)
                        , ChatFix.fixColor("&bPinger: &7" + pingerwersja)
                        , ""
                        , ChatFix.fixColor("&8[&aKliknij aby zobaczyc ustawienia&8]")));
        ItemBuilder zamknij = (new ItemBuilder(Material.BARRIER, 1)).setTitle(ChatFix.fixColor("&4Zamknij"));
        ItemBuilder odinstalujdodatki = (new ItemBuilder(Material.GLOWSTONE, 1)).setTitle(ChatFix.fixColor("&eOdinstaluj dodatki"));
        //if (!data.exists("plugins/Skript/scripts/-2step.sk")) {
        if (Objects.requireNonNull(data.ymlLoad("plugins/Bitcore/config.yml", "Moduly.2Step")).equalsIgnoreCase("true")) {
            ItemBuilder ab = (new ItemBuilder(Material.NAME_TAG, 1)).setTitle(ChatFix.fixColor("&c2Step &8(&a&lV&8)"))
                    .addLores(Arrays.asList(ChatFix.fixColor("&7Wersja: " + stepwersja)
                            , ""
                            , ChatFix.fixColor("&8Opis:")
                            , ChatFix.fixColor("&8Zabezpiecz swoj serwer podwojnie!")
                            , ChatFix.fixColor("&8Skuteczny anty wlam ale nie ograniczajacy")
                            , ChatFix.fixColor("&8dzialan administracji Twojego serwera.")
                            , ChatFix.fixColor("")
                            , ChatFix.fixColor("&9Komendy:")
                            , ChatFix.fixColor("&9/2login - logowanie")
                            , ChatFix.fixColor("&9/2Step - pomoc")
                            , ""
                            , ChatFix.fixColor("&8[&6Kliknij aby wylaczc&8]")));
                Inventory.setItem(12, ab.build());
        }
        else {
            ItemBuilder ab = (new ItemBuilder(Material.NAME_TAG, 1)).setTitle(ChatFix.fixColor("&c2Step &8(&c&lX&8)"))
                    .addLores(Arrays.asList(ChatFix.fixColor("&7Wersja: " + stepwersja)
                            , ""
                            , ChatFix.fixColor("&8Opis:")
                            , ChatFix.fixColor("&8Zabezpiecz swoj serwer podwojnie!")
                            , ChatFix.fixColor("&8Skuteczny anty wlam ale nie ograniczajacy")
                            , ChatFix.fixColor("&8dzialan administracji Twojego serwera.")
                            , ChatFix.fixColor("")
                            , ChatFix.fixColor("&9Komendy:")
                            , ChatFix.fixColor("&9/2login - logowanie")
                            , ChatFix.fixColor("&9/2Step - pomoc")
                            , ""
                            , ChatFix.fixColor("&8[&aKliknij aby wlaczyc&8]")));
            Inventory.setItem(12, ab.build());
        }
        if (!data.exists("plugins/Skript/scripts/-antyproxy.sk")) {
            if (!data.exists("plugins/Skript/scripts/antyproxy.sk")) {
                ItemBuilder antyproxy = (new ItemBuilder(Material.FLINT_AND_STEEL, 1)).setTitle(ChatFix.fixColor("&6AntyProxy &8(&c&lX&8)"))
                        .addLores(Arrays.asList(ChatFix.fixColor("&7Wersja: " + antyproxywersja)
                                , ""
                                , ChatFix.fixColor("&8Opis:")
                                , ChatFix.fixColor("&8Zabezpiecz swoj serwer przed")
                                , ChatFix.fixColor("&8proxy, VPN i torem.")
                                , ChatFix.fixColor("&8Blokuje wszystkie IP ktore nie sa polskie.")
                                , ChatFix.fixColor("")
                                , ChatFix.fixColor("&9Komendy:")
                                , ChatFix.fixColor("&9/antyproxy")
                                , ""
                                , ChatFix.fixColor("&8[&aKliknij aby zainstalowac&8]")));
                Inventory.setItem(13, antyproxy.build());
            }
            else {
                ItemBuilder antyproxy = (new ItemBuilder(Material.FLINT_AND_STEEL, 1)).setTitle(ChatFix.fixColor("&6AntyProxy &8(&a&lV&8)"))
                        .addLores(Arrays.asList(ChatFix.fixColor("&7Wersja: " + antyproxywersja)
                                , ""
                                , ChatFix.fixColor("&8Opis:")
                                , ChatFix.fixColor("&8Zabezpiecz swoj serwer przed")
                                , ChatFix.fixColor("&8proxy, VPN i torem.")
                                , ChatFix.fixColor("&8Blokuje wszystkie IP ktore nie sa polskie.")
                                , ChatFix.fixColor("")
                                , ChatFix.fixColor("&9Komendy:")
                                , ChatFix.fixColor("&9/antyproxy")
                                , ""
                                , ChatFix.fixColor("&8[&aZainstalowano&8]")));
                Inventory.setItem(13, antyproxy.build());
            }
        }
        else {
            ItemBuilder antyproxy = (new ItemBuilder(Material.FLINT_AND_STEEL, 1)).setTitle(ChatFix.fixColor("&6AntyProxy &8(&6&l-&8)"))
                    .addLores(Arrays.asList(ChatFix.fixColor("&7Wersja: " + antyproxywersja)
                            , ""
                            , ChatFix.fixColor("&8Opis:")
                            , ChatFix.fixColor("&8Zabezpiecz swoj serwer przed")
                            , ChatFix.fixColor("&8proxy, VPN i torem.")
                            , ChatFix.fixColor("&8Blokuje wszystkie IP ktore nie sa polskie.")
                            , ChatFix.fixColor("")
                            , ChatFix.fixColor("&9Komendy:")
                            , ChatFix.fixColor("&9/antyproxy")
                            , ""
                            , ChatFix.fixColor("&8[&aKliknij aby wlaczyc&8]")));
            Inventory.setItem(13, antyproxy.build());
        }
        if (!data.exists("plugins/Skript/scripts/-Pinger.sk")) {
            if (!data.exists("plugins/Skript/scripts/Pinger.sk")) {
                ItemBuilder pinger = (new ItemBuilder(Material.COMPASS, 1)).setTitle(ChatFix.fixColor("&bPinger &8(&c&lX&8)"))
                        .addLores(Arrays.asList(ChatFix.fixColor("&7Wersja: " + pingerwersja)
                                , ""
                                , ChatFix.fixColor("&8Opis:")
                                , ChatFix.fixColor("&8Sprawdz czy twoj serwer")
                                , ChatFix.fixColor("&8jest pingowany i z jakiego")
                                , ChatFix.fixColor("&8kraju oraz adresu IP.")
                                , ChatFix.fixColor("")
                                , ChatFix.fixColor("&9Komendy:")
                                , ChatFix.fixColor("&9Brak")
                                , ""
                                , ChatFix.fixColor("&8[&aKliknij aby zainstalowac&8]")));
                Inventory.setItem(14, pinger.build());
            }
            else {
                ItemBuilder pinger = (new ItemBuilder(Material.COMPASS, 1)).setTitle(ChatFix.fixColor("&bPinger &8(&a&lV&8)"))
                        .addLores(Arrays.asList(ChatFix.fixColor("&7Wersja: " + pingerwersja)
                                , ""
                                , ChatFix.fixColor("&8Opis:")
                                , ChatFix.fixColor("&8Sprawdz czy twoj serwer")
                                , ChatFix.fixColor("&8jest pingowany i z jakiego")
                                , ChatFix.fixColor("&8kraju oraz adresu IP.")
                                , ChatFix.fixColor("")
                                , ChatFix.fixColor("&9Komendy:")
                                , ChatFix.fixColor("&9Brak")
                                , ""
                                , ChatFix.fixColor("&8[&aZainstalowano&8]")));
                Inventory.setItem(14, pinger.build());
            }
        }
        else {
            ItemBuilder pinger = (new ItemBuilder(Material.COMPASS, 1)).setTitle(ChatFix.fixColor("&bPinger &8(&6&l-&8)"))
                    .addLores(Arrays.asList(ChatFix.fixColor("&7Wersja: " + pingerwersja)
                            , ""
                            , ChatFix.fixColor("&8Opis:")
                            , ChatFix.fixColor("&8Sprawdz czy twoj serwer")
                            , ChatFix.fixColor("&8jest pingowany i z jakiego")
                            , ChatFix.fixColor("&8kraju oraz adresu IP.")
                            , ChatFix.fixColor("")
                            , ChatFix.fixColor("&9Komendy:")
                            , ChatFix.fixColor("&9Brak")
                            , ""
                            , ChatFix.fixColor("&8[&aKliknij aby wlaczyc&8]")));
            Inventory.setItem(14, pinger.build());
        }
        //ItemBuilder antyproxy = (new ItemBuilder(Material.FLINT_AND_STEEL, 1)).setTitle(ChatFix.fixColor("&6AntyProxy"));
        //ItemBuilder pinger = (new ItemBuilder(Material.NAME_TAG, 1)).setTitle(ChatFix.fixColor("&bPinger"));
        //Inventory.setItem(0, border.build());
        FillSlots.fillSlots(0,4, border, Inventory);
        Inventory.setItem(4, informacje.build());
        FillSlots.fillSlots(5,8, border, Inventory);
        Inventory.setItem(8, zamknij.build());
        Inventory.setItem(9, odinstalujdodatki.build());
        //Inventory.setItem(12, ab.build());
        //Inventory.setItem(13, antyproxy.build());
        //Inventory.setItem(14, pinger.build());
        FillSlots.fillSlots(10,12, border, Inventory);
        FillSlots.fillSlots(15,18, border, Inventory);
        p.openInventory(Inventory);
    }
}
