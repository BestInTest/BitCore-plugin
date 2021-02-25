package pl.BestInTest.BitCore.Managers;

import org.bukkit.Bukkit;
import pl.BestInTest.BitCore.Main;
import pl.BestInTest.BitCore.Utils.Web;

public class Update {

    public void checkAll() {
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), () -> {
            Main.getInstance().getLogger().info("Sprawdzam aktualizacje");
            VersionManager.setBitcoreVer(Web.get("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja-BitCore.txt"));
            VersionManager.setStepVer(Web.get("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja.txt"));
            VersionManager.setAntyproxyVer(Web.get("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja-Antyproxy.txt"));
            VersionManager.setPingerVer(Web.get("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja-Pinger.txt"));
            Main.getInstance().getLogger().info("Zakonczono sprawdzanie");
        });
    }
    public void checkBitCore() {
        VersionManager.setBitcoreVer(Web.get("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja-BitCore.txt"));
    }
    public void checkStep() {
        VersionManager.setStepVer(Web.get("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja.txt"));
    }
    public void checkAntyproxy() {
        VersionManager.setAntyproxyVer(Web.get("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja-Antyproxy.txt"));
    }
    public void checkPinger() {
        VersionManager.setPingerVer(Web.get("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja-Pinger.txt"));
    }
}
