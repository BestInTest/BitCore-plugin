package pl.BestInTest.BitCore;

import org.bukkit.plugin.java.JavaPlugin;
import pl.BestInTest.BitCore.Commands.BitCoreCommand;
import pl.BestInTest.BitCore.Listeners.GuiListener;
import pl.BestInTest.BitCore.Managers.Update;
import pl.BestInTest.BitCore.Modules.AntyProxy.Commands.SprawdzIP;
import pl.BestInTest.BitCore.Modules.AntyProxy.Commands.antyproxy;
import pl.BestInTest.BitCore.Modules.AntyProxy.Listeners.Connect;
import pl.BestInTest.BitCore.Modules.AntyProxy.AntyProxy;
import pl.BestInTest.BitCore.Modules.Step.Commands.Login;
import pl.BestInTest.BitCore.Modules.Step.Commands.StepCmd;
import pl.BestInTest.BitCore.Modules.Step.Listeners.*;
import pl.BestInTest.BitCore.Modules.Step.Step;
import pl.BestInTest.BitCore.Utils.Settings;

import java.io.FileNotFoundException;

public class Main extends JavaPlugin {
    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        // BitCore
        saveDefaultConfig();
        Settings.create();
        getCommand("bitcore").setExecutor(new BitCoreCommand());
        getServer().getPluginManager().registerEvents(new GuiListener(), this);
        // AntyProxy
        getCommand("antyproxy").setExecutor(new antyproxy());
        getCommand("sprawdzip").setExecutor(new SprawdzIP());
        getServer().getPluginManager().registerEvents(new Connect(), this);
        try {
            AntyProxy.start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            getLogger().warning("Nie mozna zaladowac AntyProxy!");
        }
        // 2Step
        getCommand("2step").setExecutor(new StepCmd());
        getCommand("2login").setExecutor(new Login());
        getServer().getPluginManager().registerEvents(new JoinAndQuitListener(), this);
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        getServer().getPluginManager().registerEvents(new BlockPlace(), this);
        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
        getServer().getPluginManager().registerEvents(new CommandListener(), this);
        Step.start();

        new Update().runTaskTimerAsynchronously(this, 20, 3600 * 20L);

    }
    public static Main getInstance() {
        return instance;
    }

    public String getVersion(){
        return this.getDescription().getVersion();
    }

}
