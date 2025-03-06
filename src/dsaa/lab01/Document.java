package dsaa.lab01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Document {
    public static void loadDocument(String name, Scanner scan) {
//        ArrayList<String> lines = new ArrayList<String>();
//        try {
//            File myObj = new File(name);
//            scan = new Scanner(myObj);
//            while (scan.hasNextLine()) {
//                String data = scan.nextLine();
//                lines.add(data);
//            }
//            scan.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
        ArrayList<String> words = new ArrayList<String>();
        while (true) {
            String line = scan.nextLine();
            if (line.equals("eod")) {
                break;
            }
            for (String word : line.split(" ")) {
                words.add(word);
            }
        }

        for (String word : words) {
            if (correctLink(word)) {
                System.out.println(word.substring(5).toLowerCase());
            }
        }
    }

    // accepted only small letters, capitalic letter, digits nad '_' (but not on the begin)
    public static boolean correctLink(String link) {
        if (!link.toLowerCase().startsWith("link=")) {
            return false;
        }
        link = link.substring(5);
        if (link.length() == 0) {
            return false;
        }
        if (!Character.isLetter(link.charAt(0))) {
            return false;
        }
        if (!link.matches("[A-Za-z0-9_]+")) {
            return false;
        }
        return true;
    }


}
