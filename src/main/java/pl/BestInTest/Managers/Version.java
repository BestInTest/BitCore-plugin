package pl.BestInTest.Managers;

import pl.BestInTest.Utils.Web;

public class Version {
    private String bitcore;
    private String step;
    private String antyproxy;
    private String pinger;

    public String getBitCoreVer(){
        return bitcore;
    }
    public String getStepVer(){
        return step;
    }
    public String getAntyproxyVer(){
        return antyproxy;
    }
    public String getPingerVer(){
        return pinger;
    }
    public void setBitcoreVer(String ver) {
        bitcore = ver;
    }
    public void setStepVer(String ver) {
        step = ver;
    }
    public void setAntyproxyVer(String ver) {
        antyproxy = ver;
    }
    public void setPingerVer(String ver) {
        pinger = ver;
    }
    public void check() {
        bitcore = Web.get("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja-BitCore.txt");
        step = Web.get("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja.txt");
        antyproxy = Web.get("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja-Antyproxy.txt");
        pinger = Web.get("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja-Pinger.txt");
    }
}
