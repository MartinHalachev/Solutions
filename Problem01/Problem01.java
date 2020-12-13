import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Sign up")) {
            String[] split = command.split(" ");
            String token = split[0];

            switch (token) {
                case "Case":
                    String caseType = split[1];
                    line = caseChange(line, caseType);
                    System.out.println(line);
                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(split[1]);
                    int endIndex = Integer.parseInt(split[2]);
                    printReversedPart(line, startIndex, endIndex);
                    break;
                case "Cut":
                    String checkSubstring = split[1];
                    line = cut(line, checkSubstring);
                    break;
                case "Replace":
                    String symbol = split[1];
                    line = replace(line, symbol);
                    System.out.println(line);
                    break;
                case "Check":
                    String contains = split[1];
                    checkSymbol(line, contains);
                    break;
            }
            command = scanner.nextLine();
        }

    }

    private static void checkSymbol(String line, String contains) {
        if (line.contains(contains)) {
            System.out.println("Valid");
        } else {
            System.out.printf("Your username must contain %s.%n", contains);
        }
    }

    private static String replace(String line, String symbol) {
        return line.replace(symbol, "*");

    }

    private static String cut(String line, String checkSubstring) {
        String result = "";
        if (line.contains(checkSubstring)) {
            result = line.replace(checkSubstring, "");
            System.out.println(result);
        } else {
            System.out.printf("The word %s doesn't contain %s.%n", line, checkSubstring);
        }
        return result;
    }

    private static void printReversedPart(String line, int startIndex, int endIndex) {
        if (startIndex >= 0 && startIndex < line.length() && endIndex >= 0 && endIndex < line.length()) {
            String substring = line.substring(startIndex, endIndex + 1);
            StringBuilder result = new StringBuilder();
            for (int i = substring.length() - 1; i >= 0; i--) {
                result.append(substring.charAt(i));
            }
            System.out.println(result);
        }
    }

    private static String caseChange(String password, String caseType) {
        String result = "";
        if (caseType.equals("upper")) {
            result = password.toUpperCase();
        } else if (caseType.equals("lower")) {
            result = password.toLowerCase();
        }
        return result;
    }
}
