package pl.BestInTest.BitCore.Modules.Step.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.BestInTest.BitCore.Managers.data;
import pl.BestInTest.BitCore.Modules.Step.Managers.AuthManager;
import pl.BestInTest.BitCore.Modules.Step.Managers.ConfigManager;
import pl.BestInTest.BitCore.Modules.Step.Security.Passwords;
import pl.BestInTest.BitCore.Utils.ChatFix;
import pl.BestInTest.BitCore.Utils.Settings;

public class Login implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (Settings.is2StepEnabled()) {
            String prefix = ConfigManager.Prefix;
            if (sender instanceof Player) {
                if (args.length != 1) {
                    sender.sendMessage(ChatFix.fixColor(prefix + " " + ConfigManager.LoginCommand));
                } else {
                    if (!AuthManager.isLogged(sender.getName())) {
                        String password = args[0];
                        Passwords passMgr = new Passwords();
                        if (passMgr.isValidPassword(password, sender.getName())) {
                            AuthManager.login(sender.getName());
                            String success = ConfigManager.SuccessfulLogin;
                            sender.sendMessage(ChatFix.fixColor(prefix + " " + success));
                        } else {
                            String incorrect = data.ymlLoad("plugins/BitCore/Modules/2Step/lang.yml", "Incorrect-password");
                            sender.sendMessage(ChatFix.fixColor(prefix + " " + incorrect));
                        }
                    } else {
                        sender.sendMessage(ChatFix.fixColor(prefix + " " + ConfigManager.AlreadyLoggedIn));
                    }
                }
            } else {
                sender.sendMessage(ChatFix.fixColor(prefix + " " + ConfigManager.OnlyPlayer));
            }
        } else {
            String prefix = ConfigManager.Prefix;
            if (!(prefix != null && !prefix.equals(""))) {
                prefix = "&8[&c2Step&8]";
            }
            sender.sendMessage(ChatFix.fixColor(prefix + " &cModul jest wylaczony!"));
        }
        return false;
    }
}
