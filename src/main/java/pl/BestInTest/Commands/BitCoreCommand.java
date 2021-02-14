package pl.BestInTest.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.BestInTest.GUI;
import pl.BestInTest.Utils.ChatFix;

public class BitCoreCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            GUI.bitcore(p);
        }
        else {
            sender.sendMessage(ChatFix.fixColor("&a&lBitCore &6&l> &c&lBLAD! &aSkorzystaj z GUI &o;)"));
        }
        return false;
    }
}
