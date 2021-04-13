package pl.BestInTest.BitCore.Modules.Step.Managers;

import pl.BestInTest.BitCore.Managers.data;

public class ConfigManager {
    public static String Prefix;
    public static String LoginCommand;
    public static String KickMessage;
    public static String SuccessfulLogin;
    public static String AlreadyLoggedIn;
    public static String IncorrectPassword;
    public static String PasswordSetKick;
    public static String PasswordChanged;
    public static String NoPermission;
    public static String OnlyPlayer;
    public static String OnlyConsole;

    public static String defaultPassword;


    public void loadConfig() {
        Prefix = data.ymlLoad("plugins/BitCore/Modules/2Step/lang.yml", "Prefix");
        LoginCommand = data.ymlLoad("plugins/BitCore/Modules/2Step/lang.yml", "Login-command");
        KickMessage = data.ymlLoad("plugins/BitCore/Modules/2Step/lang.yml", "Kick-message");
        SuccessfulLogin = data.ymlLoad("plugins/BitCore/Modules/2Step/lang.yml", "Successful-login");
        AlreadyLoggedIn = data.ymlLoad("plugins/BitCore/Modules/2Step/lang.yml", "Already-logged-in");
        IncorrectPassword = data.ymlLoad("plugins/BitCore/Modules/2Step/lang.yml", "Incorrect-password");
        PasswordSetKick = data.ymlLoad("plugins/BitCore/Modules/2Step/lang.yml", "Password-set-kick");
        PasswordChanged = data.ymlLoad("plugins/BitCore/Modules/2Step/lang.yml", "Password-changed");
        NoPermission = data.ymlLoad("plugins/BitCore/Modules/2Step/lang.yml", "No-permission");
        OnlyPlayer = data.ymlLoad("plugins/BitCore/Modules/2Step/lang.yml", "Only-player");
        OnlyConsole = data.ymlLoad("plugins/BitCore/Modules/2Step/lang.yml", "Only-console");
        defaultPassword = data.ymlLoad("plugins/BitCore/Modules/2Step/Settings.yml", "Security.default-password");
    }
}
