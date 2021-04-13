package pl.BestInTest.BitCore.Managers;

import pl.BestInTest.BitCore.Main;

public class VersionManager {
    private static String bitcore;

    public static void setBitcoreVer(String ver) {
        bitcore = ver;
    }

    public static String getBitCoreVer(){
        return bitcore;
    }

    private final String installedbitcore = Main.instance.getVersion();

    public String getInstalledBitCoreVer(){
        return installedbitcore;
    }

}
