package pl.BestInTest.BitCore.Managers;

import org.bukkit.Bukkit;
import pl.BestInTest.BitCore.Main;
import pl.BestInTest.BitCore.Utils.Web;

public class Update {

    public void check() {
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), () -> {
            Main.getInstance().getLogger().info("Sprawdzam aktualizacje");
            VersionManager.setBitcoreVer(Web.get("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja-BitCore.txt"));
            Main.getInstance().getLogger().info("Zakonczono sprawdzanie");
        });
    }
}
