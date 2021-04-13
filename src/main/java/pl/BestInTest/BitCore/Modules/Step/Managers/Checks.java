package pl.BestInTest.BitCore.Modules.Step.Managers;

import pl.BestInTest.BitCore.Managers.data;

import java.io.IOException;

public class Checks {
    static boolean Chat;
    static boolean BlockPlace;
    static boolean BlockBreak;
    static boolean UseCommands;
    public static void reload() {
        Chat = Boolean.parseBoolean(data.ymlLoad("plugins/BitCore/Modules/2Step/Settings.yml", "Checks.Chat"));
        BlockPlace = Boolean.parseBoolean(data.ymlLoad("plugins/BitCore/Modules/2Step/Settings.yml", "Checks.Block-place"));
        BlockBreak = Boolean.parseBoolean(data.ymlLoad("plugins/BitCore/Modules/2Step/Settings.yml", "Checks.Block-break"));
        UseCommands = Boolean.parseBoolean(data.ymlLoad("plugins/BitCore/Modules/2Step/Settings.yml", "Checks.Commands"));
    }
    public static boolean getChat() {
        return Chat;
    }
    public static boolean getBlockPlace() {
        return BlockPlace;
    }
    public static boolean getBlockBreak() {
        return BlockBreak;
    }
    public static boolean getUseCommands() {
        return UseCommands;
    }

    public static void setChat(boolean bool) throws IOException {
        data.ymlSaveBoolean("plugins/BitCore/Modules/2Step/Settings.yml", "Checks.Chat", bool);
        Chat = bool;
    }
    public static void setBlockPlace(boolean bool) throws IOException {
        data.ymlSaveBoolean("plugins/BitCore/Modules/2Step/Settings.yml", "Checks.Block-place", bool);
        BlockPlace = bool;
    }
    public static void setBlockBreak(boolean bool) throws IOException {
        data.ymlSaveBoolean("plugins/BitCore/Modules/2Step/Settings.yml", "Checks.Block-break", bool);
        BlockBreak = bool;
    }
    public static void setUseCommands(boolean bool) throws IOException {
        data.ymlSaveBoolean("plugins/BitCore/Modules/2Step/Settings.yml", "Checks.Commands", bool);
        UseCommands = bool;
    }
}
