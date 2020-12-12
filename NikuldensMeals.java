import java.util.*;

public class NikuldensMeals {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        TreeMap<String, List<String>> likedMeals = new TreeMap<>();
        int unliked = 0;
        while (!command.equals("Stop")) {
            String[] split = command.split("-");
            String status = split[0];
            String person = split[1];
            String meal = split[2];
            if (status.equals("Like")) {
                if (!likedMeals.containsKey(person)) {
                    likedMeals.put(person, new ArrayList<>());
                    likedMeals.get(person).add(meal);
                } else {
                    if (!likedMeals.get(person).contains(meal)) {
                        likedMeals.get(person).add(meal);
                    }
                }
            } else if (status.equals("Unlike")) {
                if (!likedMeals.containsKey(person)) {
                    System.out.printf("%s is not at the party.%n", person);
                } else if (!likedMeals.get(person).contains(meal)) {
                    System.out.printf("%s doesn't have the %s in his/her collection.%n", person, meal);
                } else {
                    System.out.printf("%s doesn't like the %s.%n", person, meal);
                    likedMeals.get(person).remove(meal);
                    unliked++;
                }
            }
            command = scanner.nextLine();
        }
        likedMeals.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().size() - a.getValue().size())
                .forEach(e -> System.out.println(e.getKey() + ": " + print(e.getValue())));
        System.out.println("Unliked meals: " + unliked);
    }

    private static String print(List<String> value) {
        return value.toString().replaceAll("[\\[\\]]", "");
    }
}
