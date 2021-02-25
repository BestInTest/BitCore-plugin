package pl.BestInTest.BitCore.Utils;

import org.bukkit.inventory.Inventory;

public class FillSlots {
    public static void fillSlots(int start, int end, ItemBuilder item, Inventory inv) {
        int slot = start;
        while (slot < end) {
            inv.setItem(slot, item.build());
            slot++;
        }
    }
}
