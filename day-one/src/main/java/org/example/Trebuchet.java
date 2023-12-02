package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Trebuchet {

    private boolean isNotNumeric(char check) {
        try {
            Integer.parseInt(String.valueOf(check));
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    private char getFirstNumber(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (isNotNumeric(line.charAt(i))) continue;
            return line.charAt(i);
        }
        return 0;
    }

    private char getLastNumber(String line) {
        for (int i = line.length() - 1; i >= 0; i--) {
            if (isNotNumeric(line.charAt(i))) continue;
            return line.charAt(i);
        }
        return 0;
    }

    public void run() {
        try {
            File textFile = new File("puzzleinput.txt");
            Scanner scanner = new Scanner(textFile);
            int total = 0;
            while (scanner.hasNextLine()) {
                StringBuilder sb = new StringBuilder();
                String line = scanner.nextLine();
                sb.append(getFirstNumber(line));
                sb.append(getLastNumber(line));
                total += Integer.parseInt(sb.toString());
            }
            System.out.println("The calibration value is: " + total);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
