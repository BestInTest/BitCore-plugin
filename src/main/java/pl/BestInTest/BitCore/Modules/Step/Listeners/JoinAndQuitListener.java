package pl.BestInTest.BitCore.Modules.Step.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import pl.BestInTest.BitCore.Modules.Step.Managers.AuthManager;
import pl.BestInTest.BitCore.Utils.Settings;

public class JoinAndQuitListener implements Listener {
    /*@EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (Settings.is2StepEnabled()) {
            Player p = e.getPlayer();
            String playerName = p.getName();
            if (AuthManager.checkPerms(p)) {
                AuthManager.addToPlayers(playerName);
            }
        }
    }*/
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if (Settings.is2StepEnabled()) {
            AuthManager.removeFromLogged(e.getPlayer().getName());
        }
    }
}
