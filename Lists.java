import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lists<D extends Number> {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String values = scanner.nextLine();
        List<Integer> items = Arrays.stream(values.split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (int number : items) {
            System.out.print(number);
        }

    }

}
