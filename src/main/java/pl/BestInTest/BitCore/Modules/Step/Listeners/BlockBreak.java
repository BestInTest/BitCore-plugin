package pl.BestInTest.BitCore.Modules.Step.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import pl.BestInTest.BitCore.Modules.Step.Managers.AuthManager;
import pl.BestInTest.BitCore.Modules.Step.Managers.Checks;
import pl.BestInTest.BitCore.Modules.Step.Managers.ConfigManager;
import pl.BestInTest.BitCore.Utils.ChatFix;
import pl.BestInTest.BitCore.Utils.Settings;

public class BlockBreak implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (Settings.is2StepEnabled()) {
            if (Checks.getBlockBreak()) {
                Player p = e.getPlayer();
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
