package pl.BestInTest.BitCore.Utils;

import pl.BestInTest.BitCore.Main;
import pl.BestInTest.BitCore.Managers.data;

import java.io.IOException;

public class Settings {
    public static void create(){

        if (!data.exists("plugins/BitCore/Modules/Settings.yml")) {
            try {
                Main.getInstance().getLogger().info("Tworze nowe pliki konfiguracyjne...");
                data.ymlSaveBoolean("plugins/Bitcore/Modules/Settings.yml", "Moduly.2Step", true);
                data.ymlSaveBoolean("plugins/Bitcore/Modules/Settings.yml", "Moduly.AntyProxy", true);
                data.ymlSaveBoolean("plugins/Bitcore/Modules/Settings.yml", "Moduly.Pinger", true);
            } catch (IOException e) {
                e.printStackTrace();
                Main.getInstance().getLogger().warning("Nie mozna odczytac lub zapisac plikow konfiguracyjnych! Sprawdz czy uprawnienia dostepu do plikow zostaly poprawnie ustawione.");
            }
        }
    }
    public static boolean is2StepEnabled() {
        return Boolean.parseBoolean(data.ymlLoad("plugins/Bitcore/Modules/Settings.yml", "Moduly.2Step"));
    }
    public static boolean isAntyProxyEnabled() {
        return Boolean.parseBoolean(data.ymlLoad("plugins/Bitcore/Modules/Settings.yml", "Moduly.AntyProxy"));
    }
    public static boolean isPingerEnabled() {
        return Boolean.parseBoolean(data.ymlLoad("plugins/Bitcore/Modules/Settings.yml", "Moduly.Pinger"));
    }
    public static void set2StepEnabled(boolean Boolean) throws IOException {
        data.ymlSaveBoolean("plugins/Bitcore/Modules/Settings.yml", "Moduly.2Step", Boolean);
    }
    public static void setAntyProxyEnabled(boolean Boolean) throws IOException {
        data.ymlSaveBoolean("plugins/Bitcore/Modules/Settings.yml", "Moduly.AntyProxy", Boolean);
    }
    public static void setPingerEnabled(boolean Boolean) throws IOException {
        data.ymlSaveBoolean("plugins/Bitcore/Modules/Settings.yml", "Moduly.Pinger", Boolean);
    }
}
