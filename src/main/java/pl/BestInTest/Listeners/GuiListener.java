package pl.BestInTest.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.BestInTest.Utils.ChatFix;

public class GuiListener implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onGuiOpen(InventoryClickEvent event) {
        if (ChatFix.fixColor("&e&lBitCore").equalsIgnoreCase(event.getView().getTitle())) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            assert event.getCurrentItem().getItemMeta().getDisplayName() != null;
            if (ChatFix.fixColor("&4Zamknij").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
                player.closeInventory();
                return;
            }
            if (ChatFix.fixColor("&c2Step &8(&c&lX&8)").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
                //to do
                player.sendMessage("To do");
                player.closeInventory();
                //Wysylanie playertitle
                player.sendTitle(ChatFix.fixColor("&2&lSUKCES"), ChatFix.fixColor("&aZainstalowano 2Step"), 20, 60, 20);
            }
            if (ChatFix.fixColor("&c2Step &8(&6&l-&8)").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "skript enable 2step.sk");
                player.closeInventory();
                //Wysylanie playertitle
                player.sendTitle(ChatFix.fixColor("&2&lSUKCES"), ChatFix.fixColor("&aWlaczono 2Step"), 20, 60, 20);
            }
            if (ChatFix.fixColor("&6AntyProxy &8(&c&lX&8)").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
                //to do
                player.sendMessage("To do");
                player.closeInventory();
                //Wysylanie playertitle
                player.sendTitle(ChatFix.fixColor("&2&lSUKCES"), ChatFix.fixColor("&aZainstalowano AntyProxy"), 20, 60, 20);
            }
            if (ChatFix.fixColor("&6AntyProxy &8(&6&l-&8)").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "skript enable antyproxy.sk");
                player.closeInventory();
                //Wysylanie playertitle
                player.sendTitle(ChatFix.fixColor("&2&lSUKCES"), ChatFix.fixColor("&aWlaczono AntyProxy"), 20, 60, 20);
            }
            if (ChatFix.fixColor("&bPinger &8(&c&lX&8)").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
                //to do
                player.sendMessage("To do");
                player.closeInventory();
                //Wysylanie playertitle
                player.sendTitle(ChatFix.fixColor("&2&lSUKCES"), ChatFix.fixColor("&aZainstalowano Pinger"), 20, 60, 20);
            }
            if (ChatFix.fixColor("&bPinger &8(&6&l-&8)").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "skript enable Pinger.sk");
                player.closeInventory();
                //Wysylanie playertitle
                player.sendTitle(ChatFix.fixColor("&2&lSUKCES"), ChatFix.fixColor("&aWlaczono AntyProxy"), 20, 60, 20);
            }
        }
    }
}
