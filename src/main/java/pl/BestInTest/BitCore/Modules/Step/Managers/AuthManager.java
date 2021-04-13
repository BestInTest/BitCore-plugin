package pl.BestInTest.BitCore.Modules.Step.Managers;

import org.bukkit.entity.Player;
import pl.BestInTest.BitCore.Managers.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AuthManager {
    //static List<String> Players = new ArrayList<>();
    static List<String> Logged = new ArrayList<>();
    static List<String> Perms = new ArrayList<>();
    static List<String> WlCmds = new ArrayList<>();
    static List<String> WlPlayers = new ArrayList<>();

    public static boolean isLogged(String player) {
        for (String p : Logged) {
            if (p.equals(player)) {
                return true;
            }
        }
        return false;
    }

    public static void login(String player) {
        Logged.add(player);
    }
    public static void removeFromLogged(String player) {
        Logged.remove(player);
    }

    /*public static void addToPlayers(String player) {
        Players.add(player);
    }
    public static boolean mustLogin(String player) {
        for (String s : Players) {
            if (s.equals(player)) {
                return true;
            }
        }
        return false;
    }*/
    public static void loadPermissions() {
        if (!Perms.isEmpty()) {
            Perms.clear();
        }
        Perms = data.getList("plugins/BitCore/Modules/2Step/permissions.yml", "permissions");
    }
    public static boolean checkPerms(Player player) {
        for (String s: Perms) {
            if (player.hasPermission(s)) {
                return true;
            }
        }
        return false;
    }
    public static void loadWhitelist() {
        if (!WlCmds.isEmpty()) {
            WlCmds.clear();
        }
        WlCmds = data.getList("plugins/BitCore/Modules/2Step/whitelist.yml", "Commands");

        if (!WlPlayers.isEmpty()) {
            WlPlayers.clear();
        }
        WlPlayers = data.getList("plugins/BitCore/Modules/2Step/whitelist.yml", "Players");
    }
    public static List getWlCmds() {
        return WlCmds;
    }
    public static List getWlPlayers() {
        return WlPlayers;
    }

    private static final String[] charCategories = new String[] {
            "abcdefghijklmnopqrstuvwxyz",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "0123456789"
    };

    public static String generatePassword(int length) {
        StringBuilder password = new StringBuilder(length);
        Random random = new Random(System.nanoTime());

        for (int i = 0; i < length; i++) {
            String charCategory = charCategories[random.nextInt(charCategories.length)];
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }

        return new String(password);
    }
}
