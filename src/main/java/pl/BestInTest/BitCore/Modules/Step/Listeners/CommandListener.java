package pl.BestInTest.BitCore.Modules.Step.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import pl.BestInTest.BitCore.Modules.Step.Managers.AuthManager;
import pl.BestInTest.BitCore.Modules.Step.Managers.Checks;
import pl.BestInTest.BitCore.Modules.Step.Managers.ConfigManager;
import pl.BestInTest.BitCore.Utils.ChatFix;
import pl.BestInTest.BitCore.Utils.Settings;

import java.util.Arrays;
import java.util.List;

public class CommandListener implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        if (Settings.is2StepEnabled()) {
            if (Checks.getUseCommands()) {
                Player p = e.getPlayer();
                String msg = e.getMessage().toLowerCase();
                String[] arr = msg.split(" ", 2);
                List<String> list = Arrays.asList(arr);
                String cmd = list.get(0);
                if (AuthManager.getWlCmds().toString().contains(cmd)) {
                    return;
                }
                if (AuthManager.getWlPlayers().toString().contains(p.getName())) {
                    return;
                }
                if (AuthManager.checkPerms(p)) {
                    if (!AuthManager.isLogged(p.getName())) {
                        e.setCancelled(true);
                        String kickMessage = ConfigManager.KickMessage;
                        p.kickPlayer(ChatFix.fixColor(kickMessage));
                    }
                }
            }
        }
    }
}
