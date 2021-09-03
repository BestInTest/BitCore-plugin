package pl.BestInTest.BitCore.Managers;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import pl.BestInTest.BitCore.Main;
import pl.BestInTest.BitCore.Utils.ChatFix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Update extends BukkitRunnable {

    /* Used:
    https://github.com/montlikadani/TabList/blob/77ab6ddb5d0808bb5ad88212ff85e44fabb84f7e/bukkit/src/main/java/hu/montlikadani/tablist/bukkit/utils/UpdateDownloader.java#L22
    */

    @Override
    public void run() {
        try {
            URL githubUrl = new URL(
                    "https://raw.githubusercontent.com/BestInTest/BitCore-plugin/master/src/main/resources/plugin.yml");
            String lineWithVersion = "";

            try (BufferedReader br = new BufferedReader(new InputStreamReader(githubUrl.openStream()))) {
                String s;

                while ((s = br.readLine()) != null) {
                    if (s.contains("version")) {
                        lineWithVersion = s;
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            String versionString = Pattern.compile(": ").split(lineWithVersion, 2)[1];
            Pattern integerVersionPattern = Pattern.compile("[^0-9]");
            Plugin plugin = Main.getInstance();
            Logger logger = Bukkit.getLogger();

            int newVersion = Integer.parseInt(integerVersionPattern.matcher(versionString).replaceAll(""));
            int currentVersion = Integer
                    .parseInt(integerVersionPattern.matcher(plugin.getDescription().getVersion()).replaceAll(""));

            VersionManager.setBitcoreVer(versionString);
            if (currentVersion >= newVersion) {
                logger.info(ChatFix.fixColor("&a&lBitCore &6&l> &aPosiadasz aktualna wersje!"));
                return;
            }

            logger.info(ChatFix.fixColor("&a&lBitCore &6&l> &9Posiadasz wersje " + plugin.getDescription().getVersion() + " natomiast najnowsza wersja to " + versionString));
            logger.info(ChatFix.fixColor("&a&lBitCore &6&l> &cNatychmiast zaktualizuj swoja wersje do " + versionString));
            logger.info(ChatFix.fixColor("&a&lBitCore &6&l> &9Link do pobrania: &7https://github.com/BestInTest/BitCore-plugin/releases"));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
