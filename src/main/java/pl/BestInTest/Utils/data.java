package pl.BestInTest.Utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class data {
    public static void ymlSave(String Path, String DataName, String Value) throws IOException {
        File f = new File(Path);
        FileConfiguration conf = YamlConfiguration.loadConfiguration(f);
        if (!f.exists()) {
            if (createFile(Path)) {
                PrintWriter pw = new PrintWriter(new FileWriter(f));
                pw.println(DataName);

                conf.set(DataName, Value);
                conf.save(f);
            }
        } else {
            //FileConfiguration conf = YamlConfiguration.loadConfiguration(f);
            conf.set(DataName, Value);
            conf.save(f);
        }
    }
    public static void ymlSaveBoolean(String Path, String DataName, Boolean Boolean) throws IOException {
        File f = new File(Path);
        FileConfiguration conf = YamlConfiguration.loadConfiguration(f);
        if (!f.exists()) {
            if (createFile(Path)) {
                PrintWriter pw = new PrintWriter(new FileWriter(f));
                pw.println(DataName);

                conf.set(DataName, Boolean);
                conf.save(f);
            }
        } else {
            //FileConfiguration conf = YamlConfiguration.loadConfiguration(f);
            conf.set(DataName, Boolean);
            conf.save(f);
        }
    }
    public static String ymlLoad(String Path, String DataName) {
        //File f = new File(Main.getInstance().getDataFolder(), "data/" + FileName + ".yml");
        File f = new File(Path);
        if (!f.exists()) {
            return null;
        } else {
            FileConfiguration conf = YamlConfiguration.loadConfiguration(f);
            return conf.getString(DataName, DataName);
        }
    }
    public static boolean createFile(String Path) throws IOException {
        File file = new File(Path);
        if (!file.getParentFile().exists()) {
            return file.getParentFile().mkdirs() && file.createNewFile();
        }
        return file.createNewFile();

        /*if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        if (!file.exists()) {
            return file.createNewFile();
        }
        return false; */
    }
    public static boolean exists(String path){
        File path1 = new File(path);
        return path1.exists();
    }
}
