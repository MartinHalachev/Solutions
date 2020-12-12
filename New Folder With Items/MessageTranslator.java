import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "([!])(?<command>[A-Z][a-z]{2,})\\1:\\[(?<message>[A-Za-z]{8,})\\]";
        Pattern pattern = Pattern.compile(regex);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                System.out.print(matcher.group("command") + ": ");
                String message = matcher.group("message");
                for (int j = 0; j < message.length(); j++) {
                    System.out.printf("%d ", (int) message.charAt(j));
                }
                System.out.println();
            } else {
                System.out.println("The message is invalid");
            }
        }
    }
}
