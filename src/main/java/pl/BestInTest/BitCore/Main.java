package pl.BestInTest.BitCore;

import org.bukkit.plugin.java.JavaPlugin;
import pl.BestInTest.BitCore.Commands.BitCoreCommand;
import pl.BestInTest.BitCore.Listeners.GuiListener;
import pl.BestInTest.BitCore.Managers.Update;
import pl.BestInTest.BitCore.Modules.AntyProxy.Commands.antyproxy;
import pl.BestInTest.BitCore.Modules.AntyProxy.Listeners.Connect;
import pl.BestInTest.BitCore.Modules.AntyProxy.main;
import pl.BestInTest.BitCore.Utils.Settings;

import java.io.FileNotFoundException;

public class Main extends JavaPlugin {
    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        Update update = new Update();
        saveDefaultConfig();
        // BitCore
        getCommand("bitcore").setExecutor(new BitCoreCommand());
        getServer().getPluginManager().registerEvents(new GuiListener(), this);
        // AntyProxy
        getCommand("antyproxy").setExecutor(new antyproxy());
        getServer().getPluginManager().registerEvents(new Connect(), this);
        try {
            main.start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            getLogger().warning("Nie mozna zaladowac AntyProxy!");
        }

        Settings.create();
        getServer().getScheduler().scheduleSyncRepeatingTask(this, update::checkAll, 0/*60*20*/,3600 * 20L);

    }
    public static Main getInstance() {
        return instance;
    }

    public String getVersion(){
        return this.getDescription().getVersion();
    }

}
