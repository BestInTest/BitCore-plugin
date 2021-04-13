package pl.BestInTest.BitCore.GUIs;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import pl.BestInTest.BitCore.Modules.AntyProxy.Data.Settings;
import pl.BestInTest.BitCore.Modules.Step.Managers.Checks;
import pl.BestInTest.BitCore.Utils.ChatFix;
import pl.BestInTest.BitCore.Utils.FillSlots;
import pl.BestInTest.BitCore.Utils.ItemBuilder;

import java.util.Arrays;

public class step {
    public static void StepGUI(Player p) {
        Inventory Inventory = Bukkit.createInventory(p, 9, ChatFix.fixColor("&a&lBC &7&l&m&o|&e&l zarzadzanie &7&l&m&o|&9 2Step"));
        if (Checks.getChat()) {
            ItemBuilder sprChatu = (new ItemBuilder(Material.BOOK, 1)).setTitle(ChatFix.fixColor("&aSprawdzanie chatu")).addLores(Arrays.asList(" ", ChatFix.fixColor("&8[&aWlaczone&8]"))).addEnchantment(Enchantment.DURABILITY,1);
            Inventory.setItem(0, sprChatu.build());
        } else {
            ItemBuilder sprChatu = (new ItemBuilder(Material.BOOK, 1)).setTitle(ChatFix.fixColor("&aSprawdzanie chatu")).addLores(Arrays.asList(" ", ChatFix.fixColor("&8[&cWylaczone&8]")));
            Inventory.setItem(0, sprChatu.build());
        }
        if (Checks.getBlockPlace()) {
            ItemBuilder stawianieblokow = (new ItemBuilder(Material.COBBLESTONE, 1)).setTitle(ChatFix.fixColor("&aSprawdzanie stawiania blokow")).addLores(Arrays.asList(" ", ChatFix.fixColor("&8[&aWlaczone&8]"))).addEnchantment(Enchantment.DURABILITY,1);
            Inventory.setItem(1, stawianieblokow.build());
        } else {
            ItemBuilder stawianieblokow = (new ItemBuilder(Material.COBBLESTONE, 1)).setTitle(ChatFix.fixColor("&aSprawdzanie stawiania blokow")).addLores(Arrays.asList(" ", ChatFix.fixColor("&8[&cWylaczone&8]")));
            Inventory.setItem(1, stawianieblokow.build());
        }
        if (Checks.getBlockBreak()) {
            ItemBuilder niszczenieblokow = (new ItemBuilder(Material.STONE, 1)).setTitle(ChatFix.fixColor("&aSprawdzanie niszczenia blokow")).addLores(Arrays.asList(" ", ChatFix.fixColor("&8[&aWlaczone&8]"))).addEnchantment(Enchantment.DURABILITY,1);
            Inventory.setItem(2, niszczenieblokow.build());
        } else {
            ItemBuilder niszczenieblokow = (new ItemBuilder(Material.STONE, 1)).setTitle(ChatFix.fixColor("&aSprawdzanie niszczenia blokow")).addLores(Arrays.asList(" ", ChatFix.fixColor("&8[&cWylaczone&8]")));
            Inventory.setItem(2, niszczenieblokow.build());
        }
        if (Checks.getUseCommands()) {
            ItemBuilder uzywaniekomend = (new ItemBuilder(Material.COMMAND_CHAIN, 1)).setTitle(ChatFix.fixColor("&aSprawdzanie komend")).addLores(Arrays.asList(" ", ChatFix.fixColor("&8[&aWlaczone&8]"))).addEnchantment(Enchantment.DURABILITY,1);
            Inventory.setItem(3, uzywaniekomend.build());
        } else {
            ItemBuilder uzywaniekomend = (new ItemBuilder(Material.COMMAND_CHAIN, 1)).setTitle(ChatFix.fixColor("&aSprawdzanie komend")).addLores(Arrays.asList(" ", ChatFix.fixColor("&8[&cWylaczone&8]")));
            Inventory.setItem(3, uzywaniekomend.build());
        }
        ItemBuilder border = (new ItemBuilder(Material.THIN_GLASS, 1)).setTitle(" ");
        FillSlots.fillSlots(4,7, border,Inventory);
        ItemBuilder wylaczenie = (new ItemBuilder(Material.LEVER, 1)).setTitle(ChatFix.fixColor("&7Wylacz modul"));
        Inventory.setItem(7, wylaczenie.build());
        ItemBuilder cofnij = (new ItemBuilder(Material.BARRIER, 1)).setTitle(ChatFix.fixColor("&cCofnij"));
        Inventory.setItem(8,cofnij.build());
        p.openInventory(Inventory);
    }
}
