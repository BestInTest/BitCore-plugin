package pl.BestInTest.BitCore.Modules.AntyProxy.Commands;

import com.google.common.net.InetAddresses;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.BestInTest.BitCore.Managers.data;
import pl.BestInTest.BitCore.Modules.AntyProxy.Data.Cache;
import pl.BestInTest.BitCore.Modules.AntyProxy.AntyProxy;
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
                                AntyProxy.start();
                            } catch (IOException e) {
                                e.printStackTrace();
                                sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &7Wystapil blad podczas przeladowania! Sprawdz konsole."));
                            }
                            sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &aPrzeladowano"));
                        } else {
                            sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cNa pewno poprawnie wpisales komende? Sprawdz /antyproxy"));
                        }
                    } else {
                        sender.sendMessage(ChatFix.fixColor("&7&l----------------------"));
                        sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cUzycie:"));
                        sender.sendMessage(ChatFix.fixColor("&8/antyproxy &7zezwalaj &8<&eIP&8> - Zezwala na polaczenia z podanego IP"));
                        sender.sendMessage(ChatFix.fixColor("&8/antyproxy &7zezwalaj &8<&enick&8> - Zezwala na polaczenia dla danego gracza"));
                        sender.sendMessage(ChatFix.fixColor("&8/antyproxy &7blokuj &8<&eIP&8> - Blokuje polaczenia z podanego IP"));
                        sender.sendMessage(ChatFix.fixColor("&8/antyproxy &7blokuj &8<&enick&8> - Blokuje polaczenia dla danego gracza"));
                        sender.sendMessage(ChatFix.fixColor("&8/antyproxy &7sprawdz &8<&eIP&8> - Sprawdzanie stanu blokady IP"));
                        sender.sendMessage(ChatFix.fixColor("&8/antyproxy &7sprawdz &8<&enick&8> - Sprawdzanie stanu blokady danego gracza"));
                        sender.sendMessage(ChatFix.fixColor("&8/antyproxy &7reload &8- Przeladowuje dane z pamieci"));
                        sender.sendMessage(ChatFix.fixColor("&7&l----------------------"));
                    }
                } else {
                    String IP = args[1].replaceAll("\\.", "-");
                    String clearIP = args[1];
                    boolean isValidIP = InetAddresses.isInetAddress(args[1]);
                    if (args[0].equalsIgnoreCase("zezwalaj")) {
                        if (isValidIP) {
                            Cache.addToWyjatkiIPNew(IP,"true");
                            try {
                                data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/whitelist/IP.yml", args[1].replaceAll("\\.", "-"), true);
                                sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cDodano adres IP " + clearIP + "&c do wyjatkow."));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            //sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cBlad! Adres " + clearIP + "&c nie moze zostac sprawdzony (prawdopodobnie jest bledny)"));
                            Cache.addToWyjatkiGraczeNew(IP,"true");
                            try {
                                data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/whitelist/players.yml", args[1], true);
                                sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cDodano gracza " + args[1] + "&c do wyjatkow."));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("blokuj")) {
                        if (isValidIP) {
                            Cache.addToWyjatkiIPNew(IP,"false");
                            try {
                                data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/whitelist/IP.yml", args[1].replaceAll("\\.", "-"), false);
                                sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cDodano adres IP " + clearIP + "&c do adresow blokowanych."));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            //sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cBlad! Adres " + clearIP + "&c nie moze zostac sprawdzony (prawdopodobnie jest bledny)"));
                            Cache.addToWyjatkiGraczeNew(IP,"false");
                            try {
                                data.ymlSaveBoolean("plugins/BitCore/Modules/AntyProxy/whitelist/players.yml", args[1], false);
                                sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cDodano gracza " + args[1] + "&c do blokowanych."));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("sprawdz")) {
                        String playerInfo = Cache.getFromWyjatkiGraczeNew(args[1]);
                        if (playerInfo.equalsIgnoreCase("true")) {
                            sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cStatus dla gracza " + args[1] + ": &azezwolono"));
                            return true;
                        }
                        if (playerInfo.equalsIgnoreCase("false")) {
                            sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cStatus dla gracza " + args[1] + ": &4zablokowano"));
                            return true;
                        }
                        if (isValidIP) {
                            String ipInfo = Cache.getFromWyjatkiIPNew(IP);
                            if (ipInfo.equalsIgnoreCase("true")) {
                                sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cStatus dla adresu " + clearIP + ": &azezwolono"));
                                return true;
                            }
                            if (ipInfo.equalsIgnoreCase("false")) {
                                sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cStatus dla adresu " + clearIP + ": &4zablokowano"));
                                return true;
                            }
                            sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cStatus dla zapytania " + clearIP + ": &abrak danych"));
                        }
                        sender.sendMessage(ChatFix.fixColor("&9&l[AntyProxy] &cBlad! Nie znaleziono danych dla zapytania " + args[1] + "&c (sprawdz czy nie ma bledu)"));
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
