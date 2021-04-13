package pl.BestInTest.BitCore.GUIs;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import pl.BestInTest.BitCore.Managers.VersionManager;
import pl.BestInTest.BitCore.Managers.data;
import pl.BestInTest.BitCore.Utils.ChatFix;
import pl.BestInTest.BitCore.Utils.FillSlots;
import pl.BestInTest.BitCore.Utils.ItemBuilder;

import java.util.Arrays;

public class GUI {
    public static void bitcore(Player p) {
        Inventory Inventory = Bukkit.createInventory(p, 18, ChatFix.fixColor("&e&lBitCore"));
        ItemBuilder border = (new ItemBuilder(Material.THIN_GLASS, 1)).setTitle(" ");
        VersionManager version = new VersionManager();

        String bitcorewersja = version.getInstalledBitCoreVer();

        ItemBuilder informacje = (new ItemBuilder(Material.BOOK, 1)).setTitle(ChatFix.fixColor("&aInformacje o BitCore:"))
                .addLores(Arrays.asList(ChatFix.fixColor("&7BitCore to narzedzie stworzone")
                        , ChatFix.fixColor("&7do ochrony serwera przed roznymi atakami.")
                        , ""
                        , ChatFix.fixColor("&aWersja zainstalowana&7: " + bitcorewersja)
                        , ChatFix.fixColor("&bDane z serwera online&7: " + VersionManager.getBitCoreVer())
                        , ""
                        , ChatFix.fixColor("&8[&aKliknij aby zobaczyc ustawienia&8]")));
        ItemBuilder zamknij = (new ItemBuilder(Material.BARRIER, 1)).setTitle(ChatFix.fixColor("&4Zamknij"));

        if (Boolean.parseBoolean(data.ymlLoad("plugins/BitCore/Modules/Settings.yml", "Moduly.2Step"))) {
            ItemBuilder step = (new ItemBuilder(Material.NAME_TAG, 1)).setTitle(ChatFix.fixColor("&c2Step &8(&a&lV&8)"))
                    .addLores(Arrays.asList(""
                            , ChatFix.fixColor("&8Opis:")
                            , ChatFix.fixColor("&8Zabezpiecz swoj serwer podwojnie!")
                            , ChatFix.fixColor("&8Skuteczny anty wlam ale nie ograniczajacy")
                            , ChatFix.fixColor("&8dzialan administracji Twojego serwera.")
                            , ChatFix.fixColor("")
                            , ChatFix.fixColor("&9Komendy:")
                            , ChatFix.fixColor("&9/2login (/2l) - logowanie")
                            , ChatFix.fixColor("&9/2Step - pomoc")
                            , ""
                            , ChatFix.fixColor("&8[&bKliknij aby zarzadzac&8]"))).addEnchantment(Enchantment.DURABILITY,1);
                Inventory.setItem(12, step.build());
        }
        else {
            ItemBuilder step = (new ItemBuilder(Material.NAME_TAG, 1)).setTitle(ChatFix.fixColor("&c2Step &8(&c&lX&8)"))
                    .addLores(Arrays.asList(""
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
            Inventory.setItem(12, step.build());
        }
        if (!Boolean.parseBoolean(data.ymlLoad("plugins/BitCore/Modules/Settings.yml", "Moduly.AntyProxy"))) {
            ItemBuilder antyproxy = (new ItemBuilder(Material.FLINT_AND_STEEL, 1)).setTitle(ChatFix.fixColor("&6AntyProxy &8(&c&lX&8)"))
                    .addLores(Arrays.asList(""
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
        else {
                ItemBuilder antyproxy = (new ItemBuilder(Material.FLINT_AND_STEEL, 1)).setTitle(ChatFix.fixColor("&6AntyProxy &8(&a&lV&8)"))
                        .addLores(Arrays.asList(""
                                , ChatFix.fixColor("&8Opis:")
                                , ChatFix.fixColor("&8Zabezpiecz swoj serwer przed")
                                , ChatFix.fixColor("&8proxy, VPN i torem.")
                                , ChatFix.fixColor("&8Blokuje wszystkie IP ktore nie sa polskie.")
                                , ChatFix.fixColor("")
                                , ChatFix.fixColor("&9Komendy:")
                                , ChatFix.fixColor("&9/antyproxy")
                                , ""
                                , ChatFix.fixColor("&8[&bKliknij aby zarzadzac&8]"))).addEnchantment(Enchantment.DURABILITY,1);
                Inventory.setItem(13, antyproxy.build());
        }

        if (!Boolean.parseBoolean(data.ymlLoad("plugins/BitCore/Modules/Settings.yml", "Moduly.Pinger"))) {
            ItemBuilder pinger = (new ItemBuilder(Material.COMPASS, 1)).setTitle(ChatFix.fixColor("&bPinger &8(&c&lX&8)"))
                    .addLores(Arrays.asList(""
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
                        .addLores(Arrays.asList(""
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



        FillSlots.fillSlots(0,4, border, Inventory);
        Inventory.setItem(4, informacje.build());
        FillSlots.fillSlots(5,8, border, Inventory);
        Inventory.setItem(8, zamknij.build());



        FillSlots.fillSlots(9,12, border, Inventory);
        FillSlots.fillSlots(15,18, border, Inventory);
        p.openInventory(Inventory);
    }
}
