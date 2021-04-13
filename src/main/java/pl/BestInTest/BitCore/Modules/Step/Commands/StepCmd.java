package pl.BestInTest.BitCore.Modules.Step.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import pl.BestInTest.BitCore.Managers.data;
import pl.BestInTest.BitCore.Modules.Step.Managers.AuthManager;
import pl.BestInTest.BitCore.Modules.Step.Managers.ConfigManager;
import pl.BestInTest.BitCore.Modules.Step.Security.Passwords;
import pl.BestInTest.BitCore.Utils.ChatFix;
import pl.BestInTest.BitCore.Utils.Settings;

import java.io.IOException;

public class StepCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        String prefix = ConfigManager.Prefix;
        if (!(prefix != null && !prefix.equals(""))) {
            prefix = "&8[&c2Step&8]";
        }
        if (Settings.is2StepEnabled()) {
            if (sender instanceof ConsoleCommandSender) {
                if (args.length != 2) {
                    sender.sendMessage(ChatFix.fixColor("&8-------[&fPomoc&8]-------"));
                    sender.sendMessage(ChatFix.fixColor("&8/2Step &e<Gracz> &a<Haslo>"));
                    sender.sendMessage(ChatFix.fixColor("&8-------[&fPomoc&8]-------"));
                } else {
                    Player p = Bukkit.getServer().getPlayer(args[0]);
                    if (p != null) {
                        AuthManager.removeFromLogged(p.getName());
                        Passwords pass = new Passwords();
                        try {
                            pass.setPassword(args[1], args[0]);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (p.isOnline()) {
                            String kickMessage = ConfigManager.PasswordSetKick;
                            p.kickPlayer(ChatFix.fixColor(kickMessage));
                        }
                        sender.sendMessage(ChatFix.fixColor(prefix + " " + ConfigManager.PasswordChanged));
                    } else {
                        String OfflinePlayer = data.ymlLoad("plugins/BitCore/Modules/2Step/lang.yml", "Player-is-offline");
                        sender.sendMessage(ChatFix.fixColor(prefix + " " + OfflinePlayer));
                    }
                }
            } else {
                sender.sendMessage(ChatFix.fixColor(prefix + " " + ConfigManager.OnlyConsole));
            }
        } else {
            sender.sendMessage(ChatFix.fixColor(prefix + " &cModul jest wylaczony!"));
        }
        return false;
    }
}
