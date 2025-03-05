package dsaa.lab01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Document {
    public static void loadDocument(String name, Scanner scan) {
        ArrayList<String> lines = new ArrayList<String>();
        try {
            File myObj = new File(name);
            scan = new Scanner(myObj);
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                lines.add(data);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (String line : lines) {
            String words[] = line.split(" ");
            for (String word : words) {
                if (correctLink(word)) {
                    System.out.print(word.substring(5).toLowerCase());
                }
            }
            System.out.println();
        }
    }

    // accepted only small letters, capitalic letter, digits nad '_' (but not on the begin)
    public static boolean correctLink(String link) {
        if (!link.startsWith("link=")) {
            return false;
        } else if (link.charAt(5) == '_') {
            return false;
        }
        return true;
    }

}
