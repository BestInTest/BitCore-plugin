package pl.BestInTest.Utils;

import java.io.IOException;

public class VersionCheck {
    public static String web (String arg) throws IOException {
        switch (arg) {
            case "bitcore":
                return Web.checkContent("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja-BitCore.txt");
            case "2step":
                return Web.checkContent("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja.txt");
            case "antyproxy":
                return Web.checkContent("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja-Antyproxy.txt");
            case "pinger":
                return Web.checkContent("https://raw.githubusercontent.com/BestInTest/BitCore/main/dl/Wersja-Pinger.txt");
        }
        return "-";
    }
}
