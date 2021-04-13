package pl.BestInTest.BitCore.GUIs;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import pl.BestInTest.BitCore.Modules.AntyProxy.Data.Settings;
import pl.BestInTest.BitCore.Utils.ChatFix;
import pl.BestInTest.BitCore.Utils.ItemBuilder;

import java.util.Arrays;

public class antyproxy {
    public static void AntyProxyGUI(Player p) {
        Inventory Inventory = Bukkit.createInventory(p, 9, ChatFix.fixColor("&a&lBC &7&l&m&o|&e&l zarzadzanie &7&l&m&o|&9 AntyProxy"));
        if (Settings.getCountryCheck()) {
            ItemBuilder sprLokalizacji = (new ItemBuilder(Material.REDSTONE_TORCH_ON, 1)).setTitle(ChatFix.fixColor("&aSprawdzanie lokalizacji")).addLores(Arrays.asList(" ", ChatFix.fixColor("&8[&aWlaczone&8]"))).addEnchantment(Enchantment.DURABILITY,1);
            Inventory.setItem(0, sprLokalizacji.build());
        } else {
            ItemBuilder sprLokalizacji = (new ItemBuilder(Material.REDSTONE_TORCH_ON, 1)).setTitle(ChatFix.fixColor("&aSprawdzanie lokalizacji")).addLores(Arrays.asList(" ", ChatFix.fixColor("&8[&cWylaczone&8]")));
            Inventory.setItem(0, sprLokalizacji.build());
        }
        if (Settings.getcacheProxy()) {
            ItemBuilder saveProxy = (new ItemBuilder(Material.CHEST, 1)).setTitle(ChatFix.fixColor("&bZapisywanie sprawdzonych adresow (proxy)")).addLores(Arrays.asList(ChatFix.fixColor("&7Przyspiesza proces sprawdzania IP"), ChatFix.fixColor("&7(moze zwiekszyc zuzycie pamieci)"), " ", ChatFix.fixColor("&8[&aWlaczone&8]"))).addEnchantment(Enchantment.DURABILITY,1);
            Inventory.setItem(1, saveProxy.build());
        } else {
            ItemBuilder saveProxy = (new ItemBuilder(Material.CHEST, 1)).setTitle(ChatFix.fixColor("&bZapisywanie sprawdzonych adresow (proxy)")).addLores(Arrays.asList(ChatFix.fixColor("&7Przyspiesza proces sprawdzania IP"), ChatFix.fixColor("&7(moze zwiekszyc zuzycie pamieci)"), " ", ChatFix.fixColor("&8[&cWylaczone&8]")));
            Inventory.setItem(1, saveProxy.build());
        }
        if (Settings.getcacheCountry()) {
            ItemBuilder saveCountry = (new ItemBuilder(Material.CHEST, 1)).setTitle(ChatFix.fixColor("&bZapisywanie sprawdzonych adresow")).addLores(Arrays.asList(ChatFix.fixColor("&7Przyspiesza proces sprawdzania IP"), ChatFix.fixColor("&7(moze zwiekszyc zuzycie pamieci)"), " ", ChatFix.fixColor("&8[&aWlaczone&8]"))).addEnchantment(Enchantment.DURABILITY,1);
            Inventory.setItem(2, saveCountry.build());
        } else {
            ItemBuilder saveCountry = (new ItemBuilder(Material.CHEST, 1)).setTitle(ChatFix.fixColor("&bZapisywanie sprawdzonych adresow")).addLores(Arrays.asList(ChatFix.fixColor("&7Przyspiesza proces sprawdzania IP"), ChatFix.fixColor("&7(moze zwiekszyc zuzycie pamieci)"), " ", ChatFix.fixColor("&8[&cWylaczone&8]")));
            Inventory.setItem(2, saveCountry.build());
        }
        if (Settings.getProvider().equalsIgnoreCase("geoip-db")) {
            ItemBuilder geoipdbProvider = (new ItemBuilder(Material.STRING, 1)).setTitle(ChatFix.fixColor("&a&lGeoip-db")).addLores(Arrays.asList(ChatFix.fixColor("&8Jezeli doswiadczasz bledow podczas wykrywania"), ChatFix.fixColor("&8lokalizacji adresu IP to zmien na innego dostawce uslugi."))).addEnchantment(Enchantment.DURABILITY,1);
            Inventory.setItem(3, geoipdbProvider.build());
        } else {
            ItemBuilder geoipdbProvider = (new ItemBuilder(Material.STRING, 1)).setTitle(ChatFix.fixColor("&a&lGeoip-db")).addLores(Arrays.asList(ChatFix.fixColor("&8Jezeli doswiadczasz bledow podczas wykrywania"), ChatFix.fixColor("&8lokalizacji adresu IP to zmien na innego dostawce uslugi.")));
            Inventory.setItem(3, geoipdbProvider.build());
        }
        if (Settings.getProvider().equalsIgnoreCase("ipapi")) {
            ItemBuilder IPapiProvider = (new ItemBuilder(Material.STRING, 1)).setTitle(ChatFix.fixColor("&e&lIPapi")).addLores(Arrays.asList(ChatFix.fixColor("&8&lSzybki i sprawny dostawca."), ChatFix.fixColor("&cPosiada limit 1000 dostarczen na dzien wiec zalecany"), ChatFix.fixColor("&cjest on tylko na mniejsze i srednie serwery oraz"), ChatFix.fixColor("&ctylko do sprawdzania adresow IP przez antyproxy."))).addEnchantment(Enchantment.DURABILITY,1);
            Inventory.setItem(4, IPapiProvider.build());
        } else {
            ItemBuilder IPapiProvider = (new ItemBuilder(Material.STRING, 1)).setTitle(ChatFix.fixColor("&e&lIPapi")).addLores(Arrays.asList(ChatFix.fixColor("&8&lSzybki i sprawny dostawca."), ChatFix.fixColor("&cPosiada limit 1000 dostarczen na dzien wiec zalecany"), ChatFix.fixColor("&cjest on tylko na mniejsze i srednie serwery oraz"), ChatFix.fixColor("&ctylko do sprawdzania adresow IP przez antyproxy.")));
            Inventory.setItem(4, IPapiProvider.build());
        }
        if (Settings.getProvider().equalsIgnoreCase("ip-api")) {
            ItemBuilder ipapiProvider = (new ItemBuilder(Material.STRING, 1)).setTitle(ChatFix.fixColor("&9&lIP-api")).addLores(Arrays.asList(ChatFix.fixColor("&8&lSzybki i sprawny dostawca."), ChatFix.fixColor("&cPosiada limit 45 dostarczen na &nminute&r&c wiec zalecany"), ChatFix.fixColor("&cjest on tylko na mniejsze i srednie serwery oraz"), ChatFix.fixColor("&ctylko do sprawdzania adresow IP przez antyproxy."))).addEnchantment(Enchantment.DURABILITY,1);
            Inventory.setItem(5, ipapiProvider.build());
        } else {
            ItemBuilder ipapiProvider = (new ItemBuilder(Material.STRING, 1)).setTitle(ChatFix.fixColor("&9&lIP-api")).addLores(Arrays.asList(ChatFix.fixColor("&8&lSzybki i sprawny dostawca."), ChatFix.fixColor("&cPosiada limit 45 dostarczen na &nminute&r&c wiec zalecany"), ChatFix.fixColor("&cjest on tylko na mniejsze i srednie serwery oraz"), ChatFix.fixColor("&ctylko do sprawdzania adresow IP przez antyproxy.")));
            Inventory.setItem(5, ipapiProvider.build());
        }
        if (Settings.getProxyCheck()) {
            ItemBuilder sprProxy = (new ItemBuilder(Material.REDSTONE_TORCH_ON, 1)).setTitle(ChatFix.fixColor("&9Sprawdzanie statusu proxy")).addLores(Arrays.asList(ChatFix.fixColor("&8Blokuje polaczenia, ktore pochodza od"), ChatFix.fixColor("&8proxy, VPN i TORa (nawet jezeli IP jest polskie)."))).addEnchantment(Enchantment.DURABILITY,1);
            Inventory.setItem(6, sprProxy.build());
        } else {
            ItemBuilder sprProxy = (new ItemBuilder(Material.REDSTONE_TORCH_ON, 1)).setTitle(ChatFix.fixColor("&9Sprawdzanie statusu proxy")).addLores(Arrays.asList(ChatFix.fixColor("&8Blokuje polaczenia, ktore pochodza od"), ChatFix.fixColor("&8proxy, VPN i TORa (nawet jezeli IP jest polskie).")));
            Inventory.setItem(6, sprProxy.build());
        }
        ItemBuilder wylaczenie = (new ItemBuilder(Material.LEVER, 1)).setTitle(ChatFix.fixColor("&7Wylacz modul"));
        Inventory.setItem(7, wylaczenie.build());
        ItemBuilder cofnij = (new ItemBuilder(Material.BARRIER, 1)).setTitle(ChatFix.fixColor("&cCofnij"));
        Inventory.setItem(8,cofnij.build());
        p.openInventory(Inventory);
    }
}
