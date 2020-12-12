import java.util.Scanner;

public class NikuldensCharity {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            String[] split = command.split(" ");
            String token = split[0];
            switch (token) {
                case "Replace":
                    String currentChar = split[1];
                    String newChar = split[2];
                    line = replace(line, currentChar, newChar);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(split[1]);
                    int endIndex = Integer.parseInt(split[2]);
                    line = cut(line, startIndex, endIndex);
                    break;
                case "Make":
                    String caseToken = split[1];
                    line = changeCase(line, caseToken);
                    break;
                case "Check":
                    String check = split[1];
                    contains(line, check);
                    break;
                case "Sum":
                    startIndex = Integer.parseInt(split[1]);
                    endIndex = Integer.parseInt(split[2]);
                    sumOfSymbols(line, startIndex, endIndex);
                    break;
            }
            command = scanner.nextLine();
        }
    }

    private static void sumOfSymbols(String line, int startIndex, int endIndex) {
        if (startIndex >= 0 && startIndex < line.length() && endIndex >= 0 && endIndex < 10) {
            int result = 0;
            for (int i = startIndex; i <= endIndex; i++) {
                result += line.charAt(i);
            }
            System.out.println(result);
        } else {
            System.out.println("Invalid indexes!");
        }
    }

    private static void contains(String line, String check) {
        if (line.contains(check)) {
            System.out.println("Message contains " + check);
        } else {
            System.out.println("Message doesn't contain " + check);
        }
    }

    private static String changeCase(String line, String caseToken) {
        String result = "";
        if (caseToken.equals("Upper")) {
            result = line.toUpperCase();
            System.out.println(result);
        } else if (caseToken.equals("Lower")) {
            result = line.toLowerCase();
            System.out.println(result);
        }
        return result;
    }

    private static String cut(String line, int startIndex, int endIndex) {
        if (startIndex >= 0 && startIndex < line.length() && endIndex >= 0 && endIndex < 10) {
            String firstPart = line.substring(0, startIndex);
            String secondPart = line.substring(endIndex + 1, line.length());
            System.out.println(firstPart + secondPart);
            return firstPart + secondPart;
        } else {
            System.out.println("Invalid indexes!");
        }
        return null;
    }

    private static String replace(String line, String currentChar, String newChar) {
        String result = line.replace(currentChar, newChar);
        System.out.println(result);
        return result;
    }
}
