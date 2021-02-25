package pl.BestInTest.BitCore.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.BestInTest.BitCore.GUIs.GUI;
import pl.BestInTest.BitCore.GUIs.antyproxy;
import pl.BestInTest.BitCore.Modules.AntyProxy.main;
import pl.BestInTest.BitCore.Utils.ChatFix;
import pl.BestInTest.BitCore.Utils.Settings;

import java.io.IOException;

public class GuiListener implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onGuiOpen(InventoryClickEvent event) throws IOException {
        if (event.getWhoClicked() instanceof Player) {
            if (ChatFix.fixColor("&e&lBitCore").equalsIgnoreCase(event.getView().getTitle())) {
                event.setCancelled(true);
                Player player = (Player) event.getWhoClicked();
                if(event.getCurrentItem() != null) {
                    if (ChatFix.fixColor("&4Zamknij").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
                        player.closeInventory();
                        return;
                    }
                    if (ChatFix.fixColor("&c2Step &8(&c&lX&8)").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {

                        player.closeInventory();
                        //to do
                        GUI.bitcore(player);
                        return;
                    }
                    if (ChatFix.fixColor("&c2Step &8(&a&lV&8)").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {

                        player.closeInventory();
                        //to do
                        GUI.bitcore(player);
                        return;
                    }
                    if (ChatFix.fixColor("&6AntyProxy &8(&c&lX&8)").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {

                        player.closeInventory();
                        Settings.setAntyProxyEnabled(true);
                        main.start();
                        antyproxy.AntyProxyGUI(player);
                        return;
                    }
                    if (ChatFix.fixColor("&6AntyProxy &8(&a&lV&8)").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {

                        player.closeInventory();
                        antyproxy.AntyProxyGUI(player);
                        return;
                    }
                    if (ChatFix.fixColor("&bPinger &8(&c&lX&8)").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {

                        player.closeInventory();
                        //to do
                        GUI.bitcore(player);
                        return;
                    }
                    if (ChatFix.fixColor("&bPinger &8(&a&lV&8)").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {

                        player.closeInventory();
                        //to do
                        GUI.bitcore(player);
                    }
                }
            }
            if (ChatFix.fixColor("&a&lBC &7&l&m&o|&e&l zarzadzanie &7&l&m&o|&9 AntyProxy").equalsIgnoreCase(event.getView().getTitle())) {
                event.setCancelled(true);
                Player player = (Player) event.getWhoClicked();
                if(event.getCurrentItem() != null) {
                    if (ChatFix.fixColor("&cCofnij").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
                        player.closeInventory();
                        GUI.bitcore(player);
                        return;
                    }
                    if (ChatFix.fixColor("&7Wylacz modul").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
                        player.closeInventory();
                        Settings.setAntyProxyEnabled(false);
                        GUI.bitcore(player);
                        return;
                    }
                    if (ChatFix.fixColor("&aSprawdzanie lokalizacji").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
                        player.closeInventory();
                        if (pl.BestInTest.BitCore.Modules.AntyProxy.Data.Settings.getCountryCheck()) {
                            pl.BestInTest.BitCore.Modules.AntyProxy.Data.Settings.setCountryCheck(false);
                        } else {
                            pl.BestInTest.BitCore.Modules.AntyProxy.Data.Settings.setCountryCheck(true);
                        }
                        antyproxy.AntyProxyGUI(player);
                        return;
                    }
                    if (ChatFix.fixColor("&bZapisywanie sprawdzonych adresow (proxy)").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
                        player.closeInventory();
                        if (pl.BestInTest.BitCore.Modules.AntyProxy.Data.Settings.getcacheProxy()) {
                            pl.BestInTest.BitCore.Modules.AntyProxy.Data.Settings.setcacheProxy(false);
                        } else {
                            pl.BestInTest.BitCore.Modules.AntyProxy.Data.Settings.setcacheProxy(true);
                        }
                        antyproxy.AntyProxyGUI(player);
                        return;
                    }
                    if (ChatFix.fixColor("&bZapisywanie sprawdzonych adresow").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
                        player.closeInventory();
                        if (pl.BestInTest.BitCore.Modules.AntyProxy.Data.Settings.getcacheCountry()) {
                            pl.BestInTest.BitCore.Modules.AntyProxy.Data.Settings.setcacheCountry(false);
                        } else {
                            pl.BestInTest.BitCore.Modules.AntyProxy.Data.Settings.setcacheCountry(true);
                        }
                        antyproxy.AntyProxyGUI(player);
                        return;
                    }
                    if (ChatFix.fixColor("&a&lGeoip-db").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
                        player.closeInventory();
                        pl.BestInTest.BitCore.Modules.AntyProxy.Data.Settings.setProvider("geoip-db");
                        antyproxy.AntyProxyGUI(player);
                        return;
                    }
                    if (ChatFix.fixColor("&e&lIPapi").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
                        player.closeInventory();
                        pl.BestInTest.BitCore.Modules.AntyProxy.Data.Settings.setProvider("ipapi");
                        antyproxy.AntyProxyGUI(player);
                        return;
                    }
                    if (ChatFix.fixColor("&9&lIP-api").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
                        player.closeInventory();
                        pl.BestInTest.BitCore.Modules.AntyProxy.Data.Settings.setProvider("ip-api");
                        antyproxy.AntyProxyGUI(player);
                        return;
                    }
                    if (ChatFix.fixColor("&9Sprawdzanie statusu proxy").equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
                        player.closeInventory();
                        if (pl.BestInTest.BitCore.Modules.AntyProxy.Data.Settings.getProxyCheck()) {
                            pl.BestInTest.BitCore.Modules.AntyProxy.Data.Settings.setProxyCheck(false);
                        } else {
                            pl.BestInTest.BitCore.Modules.AntyProxy.Data.Settings.setProxyCheck(true);
                        }
                        antyproxy.AntyProxyGUI(player);
                    }

                }
            }
        }
    }
}
