package pl.BestInTest.Utils;

import pl.BestInTest.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Web {
    public static String checkContent(String arg) throws IOException {
        //Instantiating the URL class
        URL url = new URL(arg);
        //Retrieving the contents of the specified page
        Scanner sc = new Scanner(url.openStream());
        //Instantiating the StringBuffer class to hold the result
        StringBuffer sb = new StringBuffer();
        while(sc.hasNext()) {
            sb.append(sc.next());
            //System.out.println(sc.next());
        }
        //Retrieving the String from the String Buffer object
        String result = sb.toString();
        //System.out.println(result);
        //Removing the HTML tags
        result = result.replaceAll("<[^>]*>", "");
        //System.out.println("Contents of the web page: "+result);
        return result;
    }
    public static String get(String URL) {
        try {
            URL url = new URL(URL);
            URLConnection conn = url.openConnection();
            conn.setReadTimeout(5000);
            conn.addRequestProperty("User-Agent", "Update Checker");
            conn.setDoOutput(true);
            final BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            return reader.readLine();
        } catch (Exception e) {
            Main.getInstance().getLogger().info("Nie mozna polaczyc z serwerem.");
        }
        return "-";
    }
}
