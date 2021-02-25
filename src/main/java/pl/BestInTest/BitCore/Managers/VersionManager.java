package pl.BestInTest.BitCore.Managers;

import pl.BestInTest.BitCore.Main;

public class VersionManager {
    private static String bitcore;
    private static String step;
    private static String antyproxy;
    private static String pinger;

    public static void setBitcoreVer(String ver) {
        bitcore = ver;
    }
    public static void setStepVer(String ver) {
        step = ver;
    }
    public static void setAntyproxyVer(String ver) {
        antyproxy = ver;
    }
    public static void setPingerVer(String ver) {
        pinger = ver;
    }

    public static String getBitCoreVer(){
        return bitcore;
    }
    public static String getStepVer(){
        return step;
    }
    public static String getAntyProxyVer(){
        return antyproxy;
    }
    public static String getPingerVer(){
        return pinger;
    }

    private final String installedbitcore = Main.instance.getVersion();
    private final String installedstep = pl.BestInTest.BitCore.Modules.Step.Version.getStepVer();
    private final String installedantyproxy = pl.BestInTest.BitCore.Modules.AntyProxy.Version.getAntyProxyVer();
    private final String installedpinger = pl.BestInTest.BitCore.Modules.Pinger.Version.getPingerVer();

    public String getInstalledBitCoreVer(){
        return installedbitcore;
    }
    public String getInstalledStepVer(){
        return installedstep;
    }
    public String getInstalledAntyproxyVer(){
        return installedantyproxy;
    }
    public String getInstalledPingerVer(){
        return installedpinger;
    }

}
