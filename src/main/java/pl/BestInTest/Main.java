package pl.BestInTest;

import org.bukkit.plugin.java.JavaPlugin;
import pl.BestInTest.Commands.BitCoreCommand;
import pl.BestInTest.Listeners.GuiListener;
import pl.BestInTest.Managers.Version;
import pl.BestInTest.Utils.Web;
import pl.BestInTest.Utils.data;

import java.io.IOException;

public class Main extends JavaPlugin {
    public static Main instance;
    @Override
    public void onEnable() {
        getCommand("bitcore").setExecutor(new BitCoreCommand());
        getServer().getPluginManager().registerEvents(new GuiListener(), this);
        try {
            if (!data.exists("plugins/BitCore/config.yml")) {
                getLogger().info("Tworze nowe pliki konfiguracyjne...");
                data.ymlSaveBoolean("plugins/Bitcore/config.yml", "Moduly.2Step", true);
                data.ymlSaveBoolean("plugins/Bitcore/config.yml", "Moduly.AntyProxy", true);
                data.ymlSaveBoolean("plugins/Bitcore/config.yml", "Moduly.Pinger", true);
                data.ymlSaveBoolean("plugins/Bitcore/config.yml", "Aktualizacje.Sprawdzaj-aktualizacje", true);
                data.ymlSaveBoolean("plugins/Bitcore/config.yml", "Aktualizacje.Aktualizuj-automatycznie", true);
            }
        } catch (IOException e) {
            getLogger().warning("Nie mozna odczytac lub zapisac plikow konfiguracyjnych! Sprawdz czy uprawnienia dostepu do plikow zostaly poprawnie ustawione.");
            e.printStackTrace();
            getServer().getPluginManager().disablePlugin(this);
        }
        try {
            if (!data.exists("plugins/BitCore/data/cache.yml")) {
                getLogger().info("Tworze nowe pliki tymczasowe...");
                data.ymlSave("plugins/Bitcore/data/cache.yml", "version-cache.bitcore", "-");
                data.ymlSave("plugins/Bitcore/data/cache.yml", "version-cache.step", "-");
                data.ymlSave("plugins/Bitcore/data/cache.yml", "version-cache.antyproxy", "-");
                data.ymlSave("plugins/Bitcore/data/cache.yml", "version-cache.pinger", "-");
                getLogger().info("Tworzenie plikow zakonczone.");
            }
        } catch (IOException e) {
            getLogger().warning("Nie mozna odczytac lub zapisac plikow cache! Sprawdz czy uprawnienia dostepu do plikow zostaly poprawnie ustawione.");
            e.printStackTrace();
            getServer().getPluginManager().disablePlugin(this);
        }
        try {
            // Z powodu sprawdzania czy pliki zostaly poprawnie utworzone, pod !data.exists("plugins/BitCore/data/cache.yml") nie ma else
            if (data.exists("plugins/BitCore/data/cache.yml")) {
                data.ymlSave("plugins/Bitcore/data/cache.yml", "version-cache.bitcore", Web.get("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja-BitCore.txt"));
                data.ymlSave("plugins/Bitcore/data/cache.yml", "version-cache.step", Web.checkContent("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja.txt"));
                data.ymlSave("plugins/Bitcore/data/cache.yml", "version-cache.antyproxy", Web.checkContent("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja-Antyproxy.txt"));
                data.ymlSave("plugins/Bitcore/data/cache.yml", "version-cache.pinger", Web.checkContent("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja-Pinger.txt"));
            } else {
                getLogger().warning("Nie mozna utworzyc plikow! Sprawdz czy nadano uprawnienia do zapisu.");
            }
        } catch (IOException e) {
            getLogger().warning("Nie mozna odczytac lub zapisac plikow. Sprawdz czy uprawnienia dostepu do plikow zostaly poprawnie ustawione.");
            e.printStackTrace();
        }
        checkUpdates();
    }
    public static Main getInstance() {
        return instance;
    }
    private void checkUpdates() {
        Version version = new Version();
        getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
            version.check();
            /*try {
                if (data.exists("plugins/BitCore/data/cache.yml")) {
                    getLogger().info("Sprawdzanie aktualizacji");
                    data.ymlSave("plugins/Bitcore/data/cache.yml", "version-cache.bitcore", Web.checkContent("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja-BitCore.txt"));
                    data.ymlSave("plugins/Bitcore/data/cache.yml", "version-cache.step", Web.checkContent("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja.txt"));
                    data.ymlSave("plugins/Bitcore/data/cache.yml", "version-cache.antyproxy", Web.checkContent("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja-Antyproxy.txt"));
                    data.ymlSave("plugins/Bitcore/data/cache.yml", "version-cache.pinger", Web.checkContent("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja-Pinger.txt"));
                    getLogger().info("Sprawdzanie zakonczone");
                } else {
                    getLogger().warning("Nie znaleziono plikow! Tworze nowe pliki...");
                    data.ymlSave("plugins/Bitcore/data/cache.yml", "version-cache.bitcore", "-");
                    data.ymlSave("plugins/Bitcore/data/cache.yml", "version-cache.step", "-");
                    data.ymlSave("plugins/Bitcore/data/cache.yml", "version-cache.antyproxy", "-");
                    data.ymlSave("plugins/Bitcore/data/cache.yml", "version-cache.pinger", "-");
                    getLogger().info("Tworzenie plikow zakonczone.");

                }
            } catch (IOException e) {
                this.getLogger().warning("Nie mozna sprawdzic informacji o aktualizacji!");
                e.printStackTrace();
            }*/
        }, 0/*60*20*/,60 * 20L);
    }
}
