package pl.BestInTest.BitCore.Modules.Step;

import pl.BestInTest.BitCore.Managers.data;
import pl.BestInTest.BitCore.Modules.Step.Managers.AuthManager;
import pl.BestInTest.BitCore.Modules.Step.Managers.Checks;
import pl.BestInTest.BitCore.Modules.Step.Managers.ConfigManager;
import pl.BestInTest.BitCore.Utils.ChatFix;
import pl.BestInTest.BitCore.Utils.Settings;

import java.io.IOException;
import java.util.ArrayList;

public class Step {
    public static void start() {
        if (Settings.is2StepEnabled()) {
            System.out.println(ChatFix.fixColor("&8[&c2Step&8] &7Sprawdzanie plikow"));
            if (!data.exists("plugins/BitCore/Modules/2Step/Settings.yml")) {
                try {
                    String password = AuthManager.generatePassword(10);
                    data.ymlSave("plugins/BitCore/Modules/2Step/Settings.yml", "Security.default-password", password);
                    data.ymlSaveBoolean("plugins/BitCore/Modules/2Step/Settings.yml", "Checks.Chat", false);
                    data.ymlSaveBoolean("plugins/BitCore/Modules/2Step/Settings.yml", "Checks.Commands", false);
                    data.ymlSaveBoolean("plugins/BitCore/Modules/2Step/Settings.yml", "Checks.Block-break", false);
                    data.ymlSaveBoolean("plugins/BitCore/Modules/2Step/Settings.yml", "Checks.Block-place", false);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println(ChatFix.fixColor("&8[&c2Step&8] &cNie mozna odczytac lub zapisac plikow konfiguracyjnych! Sprawdz czy uprawnienia dostepu do plikow zostaly poprawnie ustawione."));
                }
            }
            if (!data.exists("plugins/BitCore/Modules/2Step/lang.yml")) {
                try {
                    data.ymlSave("plugins/BitCore/Modules/2Step/lang.yml", "Prefix", "&8[&c2Step&8]");
                    data.ymlSave("plugins/BitCore/Modules/2Step/lang.yml", "Login-command", "&7Logowanie: &a/2login <haslo>");
                    data.ymlSave("plugins/BitCore/Modules/2Step/lang.yml", "Kick-message", "&7Nie zalogowales sie dwuetapowo");
                    data.ymlSave("plugins/BitCore/Modules/2Step/lang.yml", "Successful-login", "&aPoprawnie zalogowano");
                    data.ymlSave("plugins/BitCore/Modules/2Step/lang.yml", "Already-logged-in", "&aJestes juz zalogowany");
                    data.ymlSave("plugins/BitCore/Modules/2Step/lang.yml", "Incorrect-password", "&cNiepoprawne haslo");
                    data.ymlSave("plugins/BitCore/Modules/2Step/lang.yml", "Password-set-kick", "&aWejdz ponownie");
                    data.ymlSave("plugins/BitCore/Modules/2Step/lang.yml", "Password-changed", "&aZmieniono haslo");
                    data.ymlSave("plugins/BitCore/Modules/2Step/lang.yml", "No-permission", "&cOdmowa dostepu");
                    data.ymlSave("plugins/BitCore/Modules/2Step/lang.yml", "Only-player", "&cTej komendy moze uzywac tylko gracz.");
                    data.ymlSave("plugins/BitCore/Modules/2Step/lang.yml", "Only-console", "&cTej komendy moze uzywac tylko konsola.");
                    data.ymlSave("plugins/BitCore/Modules/2Step/lang.yml", "Player-is-offline", "&cNie odnaleziono gracza.");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println(ChatFix.fixColor("&8[&c2Step&8] &cNie mozna odczytac lub zapisac plikow konfiguracyjnych! Sprawdz czy uprawnienia dostepu do plikow zostaly poprawnie ustawione."));
                }
            }
            if (!data.exists("plugins/BitCore/Modules/2Step/permissions.yml")) {
                try {
                    ArrayList<String> a = new ArrayList<>();
                    a.add("essentials.ban");
                    a.add("worldedit.*");
                    data.saveList("plugins/BitCore/Modules/2Step/permissions.yml", "permissions", a);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (!data.exists("plugins/BitCore/Modules/2Step/whitelist.yml")) {
                try {
                    ArrayList<String> c = new ArrayList<>();
                    c.add("/2login");
                    c.add("/2l");
                    c.add("/login");
                    c.add("/l");
                    c.add("/register");
                    c.add("/reg");
                    data.saveList("plugins/BitCore/Modules/2Step/whitelist.yml", "Commands", c);
                    ArrayList<String> p = new ArrayList<>();
                    p.add("JakasNazwaGracza123");
                    data.saveList("plugins/BitCore/Modules/2Step/whitelist.yml", "Players", p);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(ChatFix.fixColor("&8[&c2Step&8] &7Ladowanie ustawien"));
            AuthManager.loadPermissions();
            AuthManager.loadWhitelist();
            Checks.reload();
            ConfigManager config = new ConfigManager();
            config.loadConfig();
            System.out.println(ChatFix.fixColor("&8[&c2Step&8] &7Poprawnie zaladowano"));
        }
    }
}
