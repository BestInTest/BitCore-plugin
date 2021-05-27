package pl.BestInTest.BitCore.Modules.AntyProxy.Commands;

import com.google.common.net.InetAddresses;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.json.JSONObject;
import pl.BestInTest.BitCore.Main;
import pl.BestInTest.BitCore.Utils.ChatFix;
import pl.BestInTest.BitCore.Utils.JsonReader;
import pl.BestInTest.BitCore.Utils.Settings;
import pl.BestInTest.BitCore.Utils.Web;

import java.io.IOException;

public class SprawdzIP implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender.hasPermission("antyproxy.sprawdzip")) {
            if (Settings.isAntyProxyEnabled()) {
                if (args.length == 1) {
                    Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), () -> {
                        String IP = args[0];
                        boolean isValidIP = InetAddresses.isInetAddress(IP);
                        if (isValidIP) {
                            String proxyResult = Web.get("https://blackbox.ipinfo.app/lookup/" + IP);
                            if (proxyResult.equalsIgnoreCase("N")) {
                                proxyResult = "&aNie";
                            } else if (proxyResult.equalsIgnoreCase("Y")) {
                                proxyResult = "&cTak";
                            }
                            try {
                                JSONObject otherInfo = JsonReader.readJsonFromUrl("http://ip-api.com/json/" + IP);
                                sender.sendMessage(ChatFix.fixColor("&aIP: &b" + IP));
                                sender.sendMessage(ChatFix.fixColor("&aProxy: " + proxyResult));
                                sender.sendMessage(ChatFix.fixColor("&aKraj: &f" + otherInfo.get("country")));
                                sender.sendMessage(ChatFix.fixColor("&aISP: &6" + otherInfo.get("isp")));
                                sender.sendMessage(ChatFix.fixColor("&aOrg: &b" + otherInfo.get("org")));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Player player = Bukkit.getPlayer(args[0]);
                            if (player != null) {
                                IP = player.getAddress().getAddress().getHostAddress();
                                String proxyResult = Web.get("https://blackbox.ipinfo.app/lookup/" + IP);
                                if (proxyResult.equalsIgnoreCase("N")) {
                                    proxyResult = "&aNie";
                                } else if (proxyResult.equalsIgnoreCase("Y")) {
                                    proxyResult = "&cTak";
                                }
                                try {
                                    JSONObject otherInfo = JsonReader.readJsonFromUrl("http://ip-api.com/json/" + IP);
                                    sender.sendMessage(ChatFix.fixColor("&aIP: &b" + IP));
                                    sender.sendMessage(ChatFix.fixColor("&aProxy: " + proxyResult));
                                    sender.sendMessage(ChatFix.fixColor("&aKraj: &f" + otherInfo.get("country")));
                                    sender.sendMessage(ChatFix.fixColor("&aISP: &6" + otherInfo.get("isp")));
                                    sender.sendMessage(ChatFix.fixColor("&aOrg: &b" + otherInfo.get("org")));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                sender.sendMessage(ChatFix.fixColor("&cPodany adres jest niepoprawny lub gracz jest offline"));
                            }
                        }
                    });
                } else {
                    sender.sendMessage(ChatFix.fixColor("&7Uzycie: &a/sprawdzIP <IP/Gracz>"));
                }
            } else {
                sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cModul jest wylaczony!"));
            }
        } else {
            sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cOdmowa dostepu."));
        }
        return false;
    }
}
