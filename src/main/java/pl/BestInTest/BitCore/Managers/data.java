package pl.BestInTest.BitCore.Managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
            conf.set(DataName, Boolean);
            conf.save(f);
        }
    }
    public static String ymlLoad(String Path, String DataName) {
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

    }
    public static boolean exists(String path){
        File path1 = new File(path);
        return path1.exists();
    }

    public static void saveList(String Path, String DataName, List list) throws IOException {
        File f = new File(Path);
        FileConfiguration conf = YamlConfiguration.loadConfiguration(f);
        if (!f.exists()) {
            if (createFile(Path)) {
                PrintWriter pw = new PrintWriter(new FileWriter(f));
                pw.println(DataName);

                conf.set(DataName, list);
                conf.save(f);
            }
        } else {
            conf.set(DataName, list);
            conf.save(f);
        }
    }
    public static List getList(String Path, String DataName) {
        File f = new File(Path);
        FileConfiguration conf = YamlConfiguration.loadConfiguration(f);
        return conf.getStringList(DataName);
    }
}
