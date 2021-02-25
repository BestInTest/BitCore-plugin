package pl.BestInTest.BitCore.Modules.AntyProxy.Commands;

import com.google.common.net.InetAddresses;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.BestInTest.BitCore.Managers.data;
import pl.BestInTest.BitCore.Modules.AntyProxy.Data.Cache;
import pl.BestInTest.BitCore.Modules.AntyProxy.main;
import pl.BestInTest.BitCore.Utils.ChatFix;
import pl.BestInTest.BitCore.Utils.Settings;

import java.io.IOException;

public class antyproxy implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("antyproxy.zarzadzanie")) {
            if (Settings.isAntyProxyEnabled()) {
                if (args.length != 2) {
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("reload")) {
                            try {
                                main.start();
                            } catch (IOException e) {
                                e.printStackTrace();
                                sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &7Wystapil blad podczas przeladowania!"));
                            }
                            sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &aPrzeladowano"));
                        } else {
                            sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cNa pewno poprawnie wpisales komende? Sprawdz /antyproxy"));
                        }
                    } else {
                        sender.sendMessage(ChatFix.fixColor("&7&l----------------------"));
                        sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cUzycie:"));
                        sender.sendMessage(ChatFix.fixColor("&8/antyproxy &7zezwalaj &8<&eIP&8> - Zezwala na polaczenia z podanego IP"));
                        sender.sendMessage(ChatFix.fixColor("&8/antyproxy &7blokuj &8<&eIP&8> - Blokuje polaczenia z podanego IP"));
                        sender.sendMessage(ChatFix.fixColor("&8/antyproxy &7sprawdz &8<&eIP&8> - Sprawdzanie stanu blokady IP"));
                        sender.sendMessage(ChatFix.fixColor("&8/antyproxy &7reload &8- Przeladowuje dane z pamieci"));
                        sender.sendMessage(ChatFix.fixColor("&7&l----------------------"));
                    }
                } else {
                    String IP = args[1].replaceAll("\\.", "-");
                    String clearIP = args[1];
                    boolean isValidIP = InetAddresses.isInetAddress(args[1]);
                    if (args[0].equalsIgnoreCase("zezwalaj")) {
                        if (isValidIP) {
                            Cache.removeFromWyjatki(IP + ": false");
                            Cache.addToWyjatki(IP + ": true");
                            try {
                                data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/wyjatki.yml", args[1].replaceAll("\\.", "-"), true);
                                sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cDodano adres IP " + clearIP + "&c do wyjatkow."));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cBlad! Adres " + clearIP + "&c nie moze zostac sprawdzony (prawdopodobnie jest bledny)"));
                        }
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("blokuj")) {
                        if (isValidIP) {
                            Cache.removeFromWyjatki(IP + ": true");
                            Cache.addToWyjatki(IP + ": false");
                            try {
                                data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/wyjatki.yml", args[1].replaceAll("\\.", "-"), false);
                                sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cDodano adres IP " + clearIP + "&c do adresow blokowanych."));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cBlad! Adres " + clearIP + "&c nie moze zostac sprawdzony (prawdopodobnie jest bledny)"));
                        }
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("sprawdz")) {
                        if (isValidIP) {
                            boolean isAllowed = Cache.getFromWyjatki(IP + ": true");
                            boolean isBlocked = Cache.getFromWyjatki(IP + ": false");
                            if (isAllowed) {
                                sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cStatus dla adresu " + clearIP + ": &azezwolono"));
                                return true;
                            }
                            if (isBlocked) {
                                sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cStatus dla adresu " + clearIP + ": &4zablokowano"));
                                return true;
                            }
                            sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cStatus dla adresu " + clearIP + ": &abrak danych"));
                        } else {
                            sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cBlad! Adres " + clearIP + "&c nie moze zostac sprawdzony (prawdopodobnie jest bledny)"));
                        }
                        return true;
                    } else {
                        sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cNa pewno poprawnie wpisales komende? Sprawdz /antyproxy"));
                    }
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
