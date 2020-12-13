import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String regex = "^^(.+)>(?<numbers>[0-9]{3,3})\\|(?<lower>[a-z]{3,3})\\|(?<upper>[A-Z]{3,3})\\|(?<check>.{3,3})<\\1$";
        Pattern pattern = Pattern.compile(regex);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String check = matcher.group("check");
                if (!check.contains("<") && !check.contains(">")) {
                    StringBuilder result = new StringBuilder();
                    result.append(matcher.group("numbers"));
                    result.append(matcher.group("lower"));
                    result.append(matcher.group("upper"));
                    result.append(matcher.group("check"));
                    System.out.println("Password: " + result);
                } else {
                    System.out.println("Try another password!");
                }
            } else {
                System.out.println("Try another password!");
            }
        }

    }
}
