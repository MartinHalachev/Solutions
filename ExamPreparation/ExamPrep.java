import com.sun.source.tree.Tree;

import java.math.BigDecimal;
import java.util.List;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class ExamPrep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Generate")) {
            String[] split = command.split(">>>");
            String token = split[0];
            switch (token) {
                case "Contains":
                    String substring = split[1];
                    contains(line, substring);
                    break;
                case "Flip":
                    String caseUpOrLow = split[1];
                    int startIndex = Integer.parseInt(split[2]);
                    int endIndex = Integer.parseInt(split[3]);
                    line = flipCases(line, caseUpOrLow, startIndex, endIndex);
                    System.out.println(line);
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(split[1]);
                    endIndex = Integer.parseInt(split[2]);
                    line = slice(line, startIndex, endIndex);
                    System.out.println(line);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + line);
    }

    private static String slice(String line, int startIndex, int endIndex) {
        String firstPart = line.substring(0, startIndex);
        String secondPart = line.substring(endIndex, line.length());
        return firstPart + secondPart;
    }

    private static String flipCases(String line, String caseUpOrLow, int startIndex, int endIndex) {
        StringBuilder result = new StringBuilder(line);
        if (caseUpOrLow.equals("Upper")) {
            String upper = result.substring(startIndex, endIndex).toUpperCase();
            result.replace(startIndex, endIndex, upper);
        } else {
            String lower = result.substring(startIndex, endIndex).toLowerCase();
            result.replace(startIndex, endIndex, lower);
        }
        return result.toString();
    }

    private static void contains(String line, String substring) {
        if (line.contains(substring)) {
            System.out.printf("%s contains %s%n", line, substring);
        } else {
            System.out.println("Substring not found!");
        }
    }
}